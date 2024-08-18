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

	private final Scanner scanner = new Scanner(System.in);
	private AdapterCPF validaCPF;
	private Fachada fachada;

	public TelaPaciente() {
		this.validaCPF = new ValidaCPF();
		this.fachada = new Fachada();
	}

	public void exibir() throws ExcecaoNegocio, IOException {
		int opcao = 0;
		do {
			System.out.println("Bem-vindo(a)!");
			System.out.println("Digite 1 para cadastrar um paciente;");
			System.out.println("Digite 2 para editar os dados de um paciente;");
			System.out.println("Digite 3 para remover um paciente;");
			System.out.println("Digite 4 para consultar um paciente;");
			System.out.println("Digite 5 para consultar todos os pacientes;");
			System.out.println("Digite 6 para sair");

			System.out.println("-------------------------------------------");

			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Digite um número válido!");
			}

			switch (opcao) {
			case 1:
				this.inserir();
				break;
			case 2:
				this.editar();
				break;
			case 3:
				this.remover();
				break;
			case 4:
				this.consultar();
				break;
			case 5:
				this.consultarTodos();
				break;
			case 6:
				System.out.println("Volte sempre");
				MeuLog.registrarPacientes("Paciente encerrou sessão");
				break;
			default:
				System.out.println("Opção inválida! Digite os números entre 1 e 6.");
				break;
			}
		} while (opcao != 6);
	}

	private void inserir() {
		System.out.println("Cadastro de Pacientes");
		IControladorPaciente controlador = FabricaControlador.getControladorPaciente();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String cpf = lerString("CPF do paciente");

			if (!validaCPF.valida(cpf)) {
				System.out.println("CPF inválido! Verifique o número e tente novamente.");
				continue; // Continua o loop para permitir outro cadastro
			}

			try {
				if (controlador.consultarPorCPF(cpf) != null) {
					System.out.println("CPF já cadastrado! Verifique o número e tente novamente.");
					continue; // Continua o loop para permitir outro cadastro
				}

				String nCartaoSUS = lerString("N° cartão do SUS");
				if (!validaCartaoSUS(nCartaoSUS)) {
					System.out.println("Número do cartão do SUS inválido! O cartão deve conter apenas números e pontos, e ter até 15 dígitos.");
					continue; // Continua o loop para permitir outro cadastro
				}




				String nome = lerString("Nome");

				Paciente.PacienteBuilder builder = new Paciente.PacienteBuilder()
						.cpf(cpf)
						.nCartaoSUS(nCartaoSUS)
						.nome(nome);

				Paciente paciente = builder.criar();

				controlador.inserir(paciente);
				System.out.println("Paciente cadastrado com sucesso!");
				System.out.println("CPF: " + paciente.getCpf());
				System.out.println("Cartão do SUS: " + paciente.getnCartaoSUS());
				System.out.println("Nome: " + paciente.getNome());
				System.out.println("ID: " + paciente.getId());

				// Seleciona a especialidade e calcula o valor da consulta
				System.out.println("1 - Cardiologista");
				System.out.println("2 - Fisioterapeuta");
				System.out.println("3 - Oftalmologista");
				System.out.println("4 - Sair");

				int opcao = lerInteiro("Qual especialidade médica? ");
				Policlinica valorConsulta = new Consultas();
				String especialidade = "";
				double valorTotal = 0.0;

				switch (opcao) {
				case 1:
					valorConsulta = new Cardiologista(valorConsulta);
					especialidade = "Cardiologista";
					break;
				case 2:
					valorConsulta = new Fisioterapeuta(valorConsulta);
					especialidade = "Fisioterapeuta";
					break;
				case 3:
					valorConsulta = new Oftalmologista(valorConsulta);
					especialidade = "Oftalmologista";
					break;
				case 4:
					System.out.println("Saindo do cadastro...");
					return; // Encerra o método para sair
				default:
					System.out.println("Opção inválida! Tente novamente.");
					continue; // Continua o loop para permitir outro cadastro
				}

				valorTotal = valorConsulta.getPagamento();
				System.out.println("Total da consulta: R$ " + valorTotal);

				// Exibe a ficha com todas as informações
				System.out.println("\n--- Ficha do Paciente ---");
				System.out.println("ID: " + paciente.getId());
				System.out.println("CPF: " + paciente.getCpf());
				System.out.println("Cartão do SUS: " + paciente.getnCartaoSUS());
				System.out.println("Nome: " + paciente.getNome());
				System.out.println("Especialidade: " + especialidade);
				System.out.println("Valor Total da Consulta: R$ " + valorTotal);
				System.out.println("--------------------------");

			} catch (ExcecaoNegocio excecao) {
				System.out.println("Erro ao cadastrar paciente: " + excecao.getMessage());
			}

			System.out.println("Deseja cadastrar outro paciente? [s/n]");
			String resposta = scanner.nextLine().trim().toLowerCase();
			if (resposta.equals("n")) {
				break; // Encerra o loop para sair
			}
		}
	}
	private boolean validaCartaoSUS(String nCartaoSUS) {
		
		String regex = "^[0-9]{1,15}(\\.[0-9]{1,15})?$";

		return Pattern.matches(regex, nCartaoSUS);
		
	}
	private void editar() {
		System.out.println("Editar Paciente");
		IControladorPaciente controlador = FabricaControlador.getControladorPaciente();

		Integer id = lerInteiro("ID do paciente");

		Paciente pacienteExistente = null;
		try {
			//pacienteExistente = controlador.consultar(id);
		} catch (Exception e) {
			System.out.println("Erro ao consultar paciente: " + e.getMessage());
			return;
		}

		if (pacienteExistente == null) {
			System.out.println("Paciente não encontrado com o ID: " + id);
			return;
		}

		String novaNCartaoSUS = lerString("novo N° cartão do SUS");
		String novoNome = lerString("novo nome");

		Paciente paciente = new Paciente(id, novoNome, novaNCartaoSUS, pacienteExistente.getCpf());

		try {
			controlador.editar(paciente);
			System.out.println("Paciente editado com sucesso!");
		} catch (ExcecaoNegocio e) {
			System.out.println("Erro ao editar paciente com o ID " + id);
		}
	}

	private void remover() {
		System.out.println("Remover Paciente");
		IControladorPaciente controlador = FabricaControlador.getControladorPaciente();

		String cpf = lerString("CPF do paciente");

		try {
			controlador.remover(cpf);
			System.out.println("Paciente removido com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao remover paciente: " + e.getMessage());
		}
	}

	private void consultar() {
		System.out.println("Consulta de Paciente");
		IControladorPaciente controlador = FabricaControlador.getControladorPaciente();

		String cpf = lerString("CPF do paciente");

		try {
			Paciente paciente = controlador.consultarPorCPF(null);
			if (paciente != null) {
				System.out.println("Paciente encontrado:");
				System.out.println("ID: " + paciente.getId());
				System.out.println("Nome: " + paciente.getNome());
				System.out.println("CPF: " + paciente.getCpf());
				System.out.println("N° cartão do SUS: " + paciente.getnCartaoSUS());
			} else {
				System.out.println("Paciente não encontrado.");
			}
		} catch (ExcecaoNegocio e) {
			System.out.println("Erro ao consultar paciente: " + e.getMessage());
		}
	}

	private void consultarTodos() {
		System.out.println("Lista de Todos os Pacientes");
		IControladorPaciente controlador = FabricaControlador.getControladorPaciente();

		try {
			List<Paciente> pacientes = controlador.listarTodos();
			if (!pacientes.isEmpty()) {
				System.out.println("Lista de pacientes:");
				for (Paciente p : pacientes) {
					System.out.println("---------------------------------------------");
					System.out.println("ID: " + p.getId());
					System.out.println("Nome: " + p.getNome());
					System.out.println("CPF: " + p.getCpf());
					System.out.println("N° cartão do SUS: " + p.getnCartaoSUS());
				}
				System.out.println("---------------------------------------------");
			} else {
				System.out.println("Não há pacientes cadastrados.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao consultar pacientes: " + e.getMessage());
		}
	}

	private int lerInteiro(String mensagem) {
		int entrada = 0;
		boolean valido = false;

		while (!valido) {
			System.out.println("Digite o " + mensagem + ": ");
			String input = scanner.nextLine();

			try {
				entrada = Integer.parseInt(input);
				valido = true;
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas números inteiros!");
			}
		}
		return entrada;
	}

	private String lerString(String nomeAtributo) {
		String entrada = "";

		while (entrada.trim().isEmpty()) {
			System.out.println("Digite o " + nomeAtributo + ": ");
			entrada = scanner.nextLine();
		}
		return entrada;
	}

	private boolean isCPFValido(String cpf) {
		cpf = cpf.replaceAll("[^\\d]", "");
		if (cpf.length() != 11) {
			return false;
		}
		if (cpf.matches("(\\d)\\1{10}")) {
			return false;
		}
		int[] digitos = new int[11];
		for (int i = 0; i < 11; i++) {
			digitos[i] = Character.getNumericValue(cpf.charAt(i));
		}
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += digitos[i] * (10 - i);
		}
		int primeiroDigitoVerificador = (soma * 10) % 11;
		if (primeiroDigitoVerificador == 10) {
			primeiroDigitoVerificador = 0;
		}
		if (digitos[9] != primeiroDigitoVerificador) {
			return false;
		}
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += digitos[i] * (11 - i);
		}
		int segundoDigitoVerificador = (soma * 10) % 11;
		if (segundoDigitoVerificador == 10) {
			segundoDigitoVerificador = 0;
		}
		return digitos[10] == segundoDigitoVerificador;
	}
}
