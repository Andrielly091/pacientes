package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public interface IControladorPaciente{
	
	void inserir(Paciente paciente) throws ExcecaoNegocio;

	void editar(Paciente paciente) throws ExcecaoNegocio;

	List<Paciente> listarTodos();

	void remover(Integer id) throws ExcecaoNegocio;

	Paciente consultar(Integer id) throws ExcecaoNegocio;

}
