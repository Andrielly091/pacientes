package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public interface IControladorPaciente {
	
	void inserir(Paciente paciente) throws ExcecaoNegocio;

	Paciente consultar(String cpf);

	void editar(Paciente paciente) throws ExcecaoNegocio;

	Paciente remover(String cpf);

	List<Paciente> listarTodos();


}
