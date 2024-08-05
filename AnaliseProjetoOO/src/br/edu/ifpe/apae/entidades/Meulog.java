package br.edu.ifpe.apae.entidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Meulog {

	private static final String NOME_ARQUIVO = "arquivo.txt";

	public Meulog() throws Exception {

		Writer writer = new FileWriter(NOME_ARQUIVO);

		writer.write("INFO\n");
	} 


}
