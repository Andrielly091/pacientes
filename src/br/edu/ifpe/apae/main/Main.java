package br.edu.ifpe.apae.main;
import java.io.IOException;

import br.edu.ifpe.apae.apresentacao.TelaPaciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class Main {
	public static void main(String[] args) throws ExcecaoNegocio, IOException {
		new TelaPaciente().exibir();  
		
	}
}