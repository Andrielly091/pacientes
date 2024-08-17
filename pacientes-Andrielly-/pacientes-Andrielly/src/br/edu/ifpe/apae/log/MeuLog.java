package br.edu.ifpe.apae.log;

import java.io.FileWriter;
import java.io.IOException;

public class MeuLog {
	
	private static final String REGISTROS_PACIENTES = "pacientes.txt";
	
	public static void registrarPacientes(String descricao) throws IOException{
		FileWriter writer = new FileWriter(REGISTROS_PACIENTES, true);
		writer.write(descricao);
		writer.close();
		
	}

}

