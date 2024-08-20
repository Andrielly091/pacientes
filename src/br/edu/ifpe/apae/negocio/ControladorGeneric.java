package br.edu.ifpe.apae.negocio;

import java.util.List;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.IGenericDAO;

public abstract class ControladorGeneric<T> {
	private IGenericDAO<T> genericDAO;

	public ControladorGeneric() {
		this.genericDAO = FabricaDAO.getDAO();
	}

	public T consultarPorId(Integer id) throws ExcecaoNegocio {
		T entidade = genericDAO.consultarPorId(id);
		if (entidade == null) {
			throw new ExcecaoNegocio("Entidade não encontrada!");
		}
		return entidade;
	}

	public void editar(T objeto) throws ExcecaoNegocio {
		genericDAO.editar(objeto);
	}

	public List<T> consultarTodos() throws ExcecaoNegocio {
		return genericDAO.listarTodos();
	}


	protected IGenericDAO<T> getDao() {
		return genericDAO;
	}
}
