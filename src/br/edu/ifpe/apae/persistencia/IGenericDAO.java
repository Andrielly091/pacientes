package br.edu.ifpe.apae.persistencia;

import java.util.List;

public interface IGenericDAO<T> {
	
	public void inserir(T objeto);
	
	public void editar(T objeto);
	
	public boolean remover(String cpf);
	
	public List<T> listar(T objeto);
	
}
