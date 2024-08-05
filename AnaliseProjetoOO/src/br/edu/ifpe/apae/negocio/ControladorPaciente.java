package br.edu.ifpe.apae.negocio;

import java.util.List;


import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.GenericDAO;
import br.edu.ifpe.apae.persistencia.IGenericDAO;

public class ControladorPaciente implements IControladorPaciente{
	
	private boolean verifica(Paciente paciente) {
		return true;
	}

	@Override
	public void inserir(Paciente paciente) throws ExcecaoNegocio {
		if (!this.verifica(paciente)) {
			throw new ExcecaoNegocio("Paciente cadastrado!");
		}
		
		GenericDAO<Paciente> pacienteDao = FabricaDAO.getDAO();
		pacienteDao.inserir(paciente);
	}
	
	@Override
	public void editar(Paciente paciente) throws ExcecaoNegocio {
		if (!this.verifica(paciente)) {
			throw new ExcecaoNegocio("Inválido!");
		}
		
		GenericDAO<Paciente> pacienteDao = FabricaDAO.getDAO();
		pacienteDao.editar(paciente);
		
	}

	@Override
	public void remover(String cpf) throws ExcecaoNegocio {
		GenericDAO<Paciente> pacienteDAO = FabricaDAO.getDAO();
		if(!pacienteDAO.remover(cpf)) {
			throw new ExcecaoNegocio("Paciente não encontrado!");
		}
		
	}
	
	@Override
	public Paciente consultar(String cpf) throws ExcecaoNegocio{
		GenericDAO<Paciente> pacienteDAO = FabricaDAO.getDAO();
		Paciente paciente = pacienteDAO.consultar(cpf);
		if(paciente == null) {
			throw new ExcecaoNegocio("Paciente não encontrado");
		}
		
		return paciente;	
		
	}

	@Override
	public List<Paciente> listarTodos() {
		GenericDAO<Paciente> pacienteDAO = FabricaDAO.getDAO();	
		return pacienteDAO.listarTodos();
		
	}	
	

}
