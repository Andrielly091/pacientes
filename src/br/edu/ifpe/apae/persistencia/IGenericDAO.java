package br.edu.ifpe.apae.persistencia;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public interface IGenericDAO<T> {
	public void inserir(T objeto);
	public void editar(T objeto) throws ExcecaoNegocio;
	public List<T> listarTodos();
	T consultar(Paciente paciente2);
	void remover(String cpf) throws ExcecaoNegocio;
	T consultar(String cpf);
}