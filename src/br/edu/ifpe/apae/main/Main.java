package br.edu.ifpe.apae.main;
import br.edu.ifpe.apae.apresentacao.TelaPaciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class Main {
	public static void main(String[] args) throws ExcecaoNegocio {
		new TelaPaciente().exibir();
	}
}