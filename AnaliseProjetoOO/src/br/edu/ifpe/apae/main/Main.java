package br.edu.ifpe.apae.main;

import br.edu.ifpe.apae.apresentacao.Cardiologista
;
import br.edu.ifpe.apae.apresentacao.Consultas;
import br.edu.ifpe.apae.apresentacao.Dermatologista;
import br.edu.ifpe.apae.apresentacao.Fisioterapeuta;
import br.edu.ifpe.apae.apresentacao.Oftalmologista;
import br.edu.ifpe.apae.apresentacao.Policlinica;
import br.edu.ifpe.apae.apresentacao.TelaPaciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class Main {

	public static void main(String[] args) throws ExcecaoNegocio {

		//new TelaPaciente().exibir();
		
		
		Policlinica valorConsultas = new Consultas();
		
		Policlinica valorCardiologista = new Cardiologista(valorConsultas);

		System.out.println("Valor de cardiologista: " + valorCardiologista.getPagamento());
		

		Policlinica valorCardiologista2 = new Cardiologista(valorCardiologista);

		System.out.println("Valor de cardiologista atual: " + valorCardiologista2.getPagamento());

		Policlinica valorOftalmologista = new Oftalmologista(valorConsultas);

		System.out.println("Valor do oftalmologista: " +  valorOftalmologista.getPagamento());

		Policlinica valorDermatologista = new Dermatologista(valorConsultas);

		System.out.println("Valor do Dermatologista: " +  valorDermatologista.getPagamento());

		Policlinica valorDermatologista2 = new Dermatologista(valorOftalmologista);

		System.out.println("Valor atual das consultas: " +  valorDermatologista2.getPagamento());

		Policlinica valorFisioterapeuta = new Fisioterapeuta(valorConsultas);

		System.out.println("Valor do Fisioterapeuta: " + valorFisioterapeuta.getPagamento());

		Policlinica valorPsicologo = new Fisioterapeuta(valorConsultas);

		System.out.println("Valor do Psicólogo: " + valorPsicologo.getPagamento());



	}

}
