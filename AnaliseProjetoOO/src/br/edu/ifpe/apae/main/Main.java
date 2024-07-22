package br.edu.ifpe.apae.main;

import br.edu.ifpe.apae.apresentacao.Cardiologista;
import br.edu.ifpe.apae.apresentacao.Consultas;
import br.edu.ifpe.apae.apresentacao.Policlinica;
import br.edu.ifpe.apae.apresentacao.TelaPaciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class Main {

	public static void main(String[] args) throws ExcecaoNegocio {

		//new TelaPaciente().exibir();

		Policlinica valorConsultas = new Consultas();

		System.out.println("Valor de consultas: " + valorConsultas.getPagamento());

		Policlinica valorCardiologista = new Cardiologista(valorConsultas);

		System.out.println("Valor de cardiologista: " + valorCardiologista.getPagamento());
		
		Policlinica valorCardiologista2 = new Cardiologista(valorCardiologista);

		System.out.println("Valor de cardiologista atual: " + valorCardiologista2.getPagamento());
	}

}
