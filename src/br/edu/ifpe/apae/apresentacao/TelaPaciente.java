package br.edu.ifpe.apae.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.entidades.Paciente.PacienteBuilder;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.negocio.FabricaControlador;
import br.edu.ifpe.apae.negocio.IControladorPaciente;

public class TelaPaciente {

	Scanner scanner = new Scanner(System.in);

	public void exibir() throws ExcecaoNegocio {

		int opcao = 0;

		while (opcao != 6) {

			System.out.println("Bem vindo(a)!");  
			System.out.println("Digite 1 para cadastrar um paciente;");
			System.out.println("Digite 2 para editar os dados de um paciente;");
			System.out.println("Digite 3 para remover um paciente;");
			System.out.println("Digite 4 para consultar um paciente; ou");
			System.out.println("Digite 5 para sair");


			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (ClassCastException ex) {
				System.out.println("Digite um número válido!");
			}
			
			if (opcao == 1) {
				this.inserir();
			}
			else if(opcao == 2) {
				this.editar();
			}
			else if(opcao == 3) {
				this.remover();
			}
			else if(opcao == 4) {
				this.consultar();
			}
			else if(opcao != 5) {
				System.out.println("Invalido");
			}

		} 

		
	}
	private String lerString(String nome) {
		String valorInicial = "";

		while (valorInicial.trim().isEmpty()) {
			System.out.println("Digite o " + nome + ": ");
			valorInicial = scanner.nextLine();

		}
		return valorInicial;
	}

	private void inserir() throws ExcecaoNegocio {
		String cpf = lerString("cpf");

		IControladorPaciente controladorPaciente = FabricaControlador.getControladorPaciente();

		Paciente colisao = controladorPaciente.consultar(cpf);

		if (colisao != null) {
			System.out.println("Paciente já cadastrado!");	
		}

		Paciente paciente = new Paciente();

		paciente.setN_cartao_SUS(this.lerString("N°̣do cartão do SUS"));
		paciente.setNome(this.lerString("Nome"));

		controladorPaciente.inserir(paciente);
		System.out.println("Paciente cadastrado com sucesso");			
	}

	private void editar() throws ExcecaoNegocio {
		String cpf = lerString("cpf");

		IControladorPaciente controladorPaciente = FabricaControlador.getControladorPaciente();

		String novoSUS = lerString("novo SUS");
		String novoNome = lerString("Novo nome");

		Paciente paciente = new Paciente();

		controladorPaciente.editar(paciente);

	}
	private void consultar() throws ExcecaoNegocio {
		String cpf = lerString("cpf");

		IControladorPaciente controladorPaciente = FabricaControlador.getControladorPaciente();

		Paciente paciente = controladorPaciente.consultar(cpf);

		if (paciente != null) {
			System.out.println("Paciente encontrado:");
			System.out.println("CPF: " + paciente.getCpf());
			System.out.println("N°̣do cartão do SUS: " + paciente.getN_cartao_SUS());
			System.out.println("Nome: " + paciente.getNome());

		}else {
			System.out.println("Paciente não encontrado");
		}

	}
	private void remover() throws ExcecaoNegocio {
		String cpf = lerString("cpf");

		IControladorPaciente controladorPaciente = FabricaControlador.getControladorPaciente();

		Paciente paciente = controladorPaciente.remover(cpf);
		System.out.println("Paciente removido com sucesso");

	}

	private void listarTodos() throws ExcecaoNegocio {
		IControladorPaciente controladorPaciente = FabricaControlador.getControladorPaciente();

		List<Paciente> listaPacientes = controladorPaciente.listarTodos();

		if (!listaPacientes.isEmpty()) {
			System.out.println("Pacientes: ");
			for (Paciente paciente : listaPacientes) {
				System.out.println("CPF: " + paciente.getCpf());
				System.out.println("Ṇ̣°̣ do cartão do SUS: " + paciente.getN_cartao_SUS());
				System.out.println("Nome: " + paciente.getNome());

			}
		}else {
			System.out.println("Paciente não encontrado");
		}
	}
}
