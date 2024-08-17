package br.edu.ifpe.apae.persistencia;

import java.util.List;

import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public interface IGenericDAO<T> {
	
	public void inserir(T objeto);
	
	public void editar(T objeto) throws ExcecaoNegocio;
	
	public boolean remover(Integer id) throws ExcecaoNegocio;
	
	public T consultar(Integer id);

	public List<T> listarTodos();
	
}
