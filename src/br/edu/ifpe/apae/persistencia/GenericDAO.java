package br.edu.ifpe.apae.persistencia;

import java.util.List;

public class GenericDAO<T> implements IGenericDAO<T> {

	@Override
	public void inserir(T objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editar(T objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remover(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> listar(T objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
