package br.edu.ifpe.apae.negocio;

import java.util.List;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.GenericDAO;

public abstract class ControladorGeneric<T> {
	private GenericDAO<T> genericDAO;
	public ControladorGeneric() {
		this.genericDAO = FabricaDAO.getDAO();
	}

	public T consultarPorId(Integer id) throws ExcecaoNegocio {
		T entidade = genericDAO.consultar(id);
		if (entidade == null) {
			throw new ExcecaoNegocio("Entidade não encontrada!");
		}
		return entidade;
	}
	public void remover(Integer id) throws ExcecaoNegocio {
		if (!genericDAO.remover(id)) {
			throw new ExcecaoNegocio("Entidade não encontrada!");
		}
	}
	public List<T> consultarTodos() throws ExcecaoNegocio {
		return genericDAO.listarTodos();
	}
	protected GenericDAO<T> getDao() {
		return genericDAO;
	}
}