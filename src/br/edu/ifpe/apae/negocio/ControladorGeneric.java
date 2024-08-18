package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.GenericDAO;

public abstract class ControladorGeneric<T> {
	private GenericDAO<T> genericDAO;
	public ControladorGeneric() {
		this.genericDAO = FabricaDAO.getDAO();
	}

	public List<T> consultarTodos() throws ExcecaoNegocio {
		return genericDAO.listarTodos();
	}
	protected GenericDAO<T> getDao() {
		return genericDAO;
	}

	public Paciente consultar(Paciente paciente) throws ExcecaoNegocio {
		// TODO Auto-generated method stub
		return null;
	}
}