package br.edu.ifpe.apae.apresentacao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import br.edu.ifpe.apae.entidades.Cardiologista;
import br.edu.ifpe.apae.entidades.Consultas;
import br.edu.ifpe.apae.entidades.Fisioterapeuta;
import br.edu.ifpe.apae.entidades.Oftalmologista;
import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.entidades.Policlinica;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.log.MeuLog;
import br.edu.ifpe.apae.negocio.FabricaControlador;
import br.edu.ifpe.apae.negocio.Fachada;
import br.edu.ifpe.apae.negocio.IControladorPaciente;
import br.edu.ifpe.apae.util.AdapterCPF;
import br.edu.ifpe.apae.util.ValidaCPF;

public class TelaPaciente {

	private Fachada fachada;
	private final Scanner scanner = new Scanner(System.in);
	private AdapterCPF validaCPF;
	private IControladorPaciente controlador;

	public TelaPaciente() {
		this.validaCPF = new ValidaCPF();
		this.controlador = FabricaControlador.getControladorPaciente();
		this.fachada = new Fachada();

	}

	public void exibir() throws ExcecaoNegocio, IOException {
		String opcao;
		do {
			mostrarMenuPrincipal();
			opcao = lerString("Escolha uma opção");

			switch (opcao) {
			case "1":
				cadastrarPaciente();
				break;
			case "2":
				editarPaciente();
				break;
			case "3":
				removerPaciente();
				break;
			case "4":
				consultarPaciente();
				break;
			case "5":
				listarTodosPacientes();
				break;
			case "6":
				System.out.println("Volte sempre");
				MeuLog.registrarPacientes("Paciente encerrou sessão");
				break;
			default:
				System.out.println("Opção inválida! Digite um número entre 1 e 6.");
				break;
			}
		} while (opcao != "6");
	}

	private void mostrarMenuPrincipal() {
		System.out.println("Bem-vindo(a)!");
		System.out.println("Digite 1 para cadastrar um paciente;");
		System.out.println("Digite 2 para editar os dados de um paciente;");
		System.out.println("Digite 3 para remover um paciente;");
		System.out.println("Digite 4 para consultar um paciente;");
		System.out.println("Digite 5 para consultar todos os pacientes;");
		System.out.println("Digite 6 para sair");
		System.out.println("-------------------------------------------");
	}

	private void cadastrarPaciente() {
		System.out.println("Cadastro de Pacientes");

		while (true) {
			String cpf = lerString("CPF do paciente");

			if (!validaCPF.valida(cpf)) {
				System.out.println("CPF inválido! Tente novamente.");
				continue;
			}

			try {
				if (fachada.consultarPorCPF(cpf) != null) {
					System.out.println("CPF já cadastrado! Tente novamente.");
					continue;
				}

				String nCartaoSUS = lerString("N° cartão do SUS");
				if (!validaCartaoSUS(nCartaoSUS)) {
					System.out.println("Número do cartão do SUS inválido! Tente novamente.");
					continue;
				}

				String nome = lerString("Nome");
				Paciente paciente = new Paciente.PacienteBuilder()
						.cpf(cpf)
						.nCartaoSUS(nCartaoSUS)
						.nome(nome)
						.criar();

				fachada.inserir(paciente);
				System.out.println("Paciente cadastrado com sucesso!");
				MeuLog.registrarPacientes("\nPaciente cadastrado com sucesso!");
				exibirFichaPaciente(paciente);

				selecionarEspecialidade();

			} catch (ExcecaoNegocio e) {
				System.out.println("Erro ao cadastrar paciente: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Erro inesperado: " + e.getMessage());
			}

			if (!perguntarSeDesejaCadastrarOutro()) {
				break;
			}
		}
	}

	private void exibirFichaPaciente(Paciente paciente) {
		System.out.println("\n--- Ficha do Paciente ---");
		System.out.println("ID: " + paciente.getId());
		System.out.println("CPF: " + paciente.getCpf());
		System.out.println("Cartão do SUS: " + paciente.getnCartaoSUS());
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("-------------------------------------------------------");
	}

	private void selecionarEspecialidade() {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		double valorTotal = 0.0;

		while (continuar) {
			System.out.println("1 - Cardiologista");
			System.out.println("2 - Fisioterapeuta");
			System.out.println("3 - Oftalmologista");
			System.out.println("4 - Sair");
			String opcao = lerString(scanner, "Escolha especialidade");

			Policlinica valorConsulta = new Consultas();
			String especialidade = "";
			double valorConsultaAtual = 0.0;

			switch (opcao) {
			case "1":
				valorConsulta = new Cardiologista(valorConsulta);
				especialidade = "Cardiologista";
				break;
			case "2":
				valorConsulta = new Fisioterapeuta(valorConsulta);
				especialidade = "Fisioterapeuta";
				break;
			case "3":
				valorConsulta = new Oftalmologista(valorConsulta);
				especialidade = "Oftalmologista";
				break;
			case "4":
				continuar = false;
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				continue;
			}

			if (continuar) {
				valorConsultaAtual = valorConsulta.getPagamento();
				int quantidadeConsultas = lerInt(scanner, "Quantas consultas deseja realizar com o(a) " + especialidade + "?");
				valorTotal += valorConsultaAtual * quantidadeConsultas;

				System.out.println("Você escolheu: " + especialidade);
				System.out.println("Valor da consulta (" + especialidade + "): R$ " + valorConsultaAtual);
				System.out.println("Valor total para " + quantidadeConsultas + " consulta(s): R$ " + (valorConsultaAtual * quantidadeConsultas));

				String sairOuContinuar = lerString(scanner, "Deseja sair? (Digite 'sim' para sair ou pressione Enter para continuar)");
				if (sairOuContinuar.equalsIgnoreCase("sim")) {
					continuar = false;
					System.out.println("Saindo...");
				}
			}
		}

		System.out.println("Valor total de todas as consultas: R$ " + valorTotal);
	}
	private boolean validaCartaoSUS(String nCartaoSUS) {
		String regex = "^[0-9]{1,15}(\\.[0-9]{1,15})?$";
		return Pattern.matches(regex, nCartaoSUS);
	}

	private void editarPaciente() {
		System.out.println("Editar Paciente");

		String cpf = lerString("CPF do paciente");

		try {
			Paciente pacienteExistente = fachada.consultarPorCPF(cpf); 
			if (pacienteExistente == null) {
				System.out.println("Paciente não encontrado com o CPF: " + cpf);
				return;
			}

			String novaNCartaoSUS = lerString("Novo N° cartão do SUS");
			String novoNome = lerString("Novo nome");

			Paciente pacienteAtualizado = new Paciente.PacienteBuilder()
					.cpf(cpf) 
					.nCartaoSUS(novaNCartaoSUS)
					.nome(novoNome)
					.criar();

			fachada.editar(pacienteExistente);

			System.out.println("Paciente editado com sucesso!");
			MeuLog.registrarPacientes(novaNCartaoSUS);
			MeuLog.registrarPacientes(novoNome);

		} catch (ExcecaoNegocio e) {
			System.out.println("Erro ao editar paciente com o CPF " + cpf + ": " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado ao editar paciente com o CPF " + cpf + ": " + e.getMessage());
		}
	}


	private void removerPaciente() {
		System.out.println("Remover Paciente");

		String cpf = lerString("CPF do paciente");

		try {
			fachada.remover(cpf);
			System.out.println("Paciente removido com sucesso!");
		} catch (ExcecaoNegocio e) {
			System.out.println("Erro ao remover paciente: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado ao remover paciente: " + e.getMessage());
		}
	}

	private void consultarPaciente() {
		System.out.println("Consultar Paciente");

		String cpf = lerString("CPF do paciente");

		try {
			Paciente paciente = fachada.consultarPorCPF(cpf);
			if (paciente != null) {
				System.out.println("Paciente encontrado:");
				exibirFichaPaciente(paciente);
			} else {
				System.out.println("Paciente não encontrado.");
			}
		} catch (ExcecaoNegocio e) {
			System.out.println("Erro ao consultar paciente: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado ao consultar paciente: " + e.getMessage());
		}
	}

	private void listarTodosPacientes() {
		System.out.println("Lista de Todos os Pacientes");

		try {
			List<Paciente> pacientes = fachada.listarTodos();
			if (!pacientes.isEmpty()) {
				System.out.println("Lista de Pacientes:");
				for (Paciente paciente : pacientes) {
					exibirFichaPaciente(paciente);
				}
			} else {
				System.out.println("Nenhum paciente encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro inesperado ao listar pacientes: " + e.getMessage());
		}
	}

	private String lerString(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}

	private String lerString(Scanner scanner, String mensagem) {
		System.out.print(mensagem + ": ");
		return scanner.nextLine();
	}

	private Integer lerInteiro(String prompt) {
		System.out.print(prompt + ": ");
		return Integer.parseInt(scanner.nextLine());
	}

	private int lerInt(Scanner scanner, String mensagem) {
		System.out.print(mensagem + ": ");
		while (!scanner.hasNextInt()) {
			System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
			scanner.next(); // Limpar a entrada inválida
		}
		return scanner.nextInt();
	}

	private boolean perguntarSeDesejaCadastrarOutro() {
		System.out.print("Deseja cadastrar outro paciente? (S/N) ");
		return scanner.nextLine().trim().equalsIgnoreCase("S");
	}
}
