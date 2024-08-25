package br.edu.ifpe.apae.negocio;

import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.IGenericDAO;

public abstract class ControladorGeneric<T> {
	private IGenericDAO<T> genericDAO;

	public ControladorGeneric() {
		this.genericDAO = FabricaDAO.getDAO();
	}

	public abstract T consultarPorId(Integer id) throws ExcecaoNegocio;

	public abstract void editar(T objeto) throws ExcecaoNegocio;

	protected IGenericDAO<T> getDao() {
		return genericDAO;
	}
}
