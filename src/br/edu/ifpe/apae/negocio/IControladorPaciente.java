package br.edu.ifpe.apae.negocio;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public interface IControladorPaciente {
	
	void inserir(Paciente paciente) throws ExcecaoNegocio;

}
