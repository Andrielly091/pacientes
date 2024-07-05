package br.edu.ifpe.apae.apresentacao;

import java.util.Scanner;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.negocio.FabricaControlador;
import br.edu.ifpe.apae.negocio.IControladorPaciente;

public class TelaPaciente {

	Scanner scanner = new Scanner(System.in);

	public void exibir() {

		int opcao = 0;

		do {

			System.out.println("Bem vindo(a)!");  
			System.out.println("Digite 1 para cadastrar um aluno;");
			System.out.println("Digite 2 para editar os dados de um aluno;");
			System.out.println("Digite 3 para remover um aluno;");
			System.out.println("Digite 4 para consultar um aluno; ou");
			System.out.println("Digite 5 para sair");


			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (ClassCastException ex) {
				System.out.println("Digite um número válido!");
			}
		} 
		
		while (opcao < 0 || opcao > 5);

		if (opcao == 1) {

			this.inserir();

		}
	}
		private void inserir() {

			Paciente paciente = new Paciente();

			paciente.setNome("nome");
			paciente.setCpf("CPF");
			paciente.setN_cartao_SUS("SUS");

			IControladorPaciente controladorPaciente = new FabricaControlador().getControladorPaciente();

			try {
				controladorPaciente.inserir(paciente);
			} catch (Exception excecao) {
				System.out.println(excecao.getMessage());
			}
		}

			private String lerString(String nomeAtributo) {
				String entrada = "";

				while (entrada.trim().length() == 0) {
					System.out.println("Digite o " + nomeAtributo + "  do aluno: ");
					entrada = scanner.nextLine();
				}

				return entrada;
			}			

		}
