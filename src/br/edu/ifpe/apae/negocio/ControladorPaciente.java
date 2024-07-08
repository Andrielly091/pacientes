package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.IPacienteDAO;
//import br.edu.ifpe.apae.persistencia.IPacienteDAO;

public class ControladorPaciente implements IControladorPaciente{
	
	private boolean verifica(Paciente paciente) {
		return true;
	}

	@Override
	public void inserir(Paciente paciente) throws ExcecaoNegocio {
		if (!this.verifica(paciente)) {
			throw new ExcecaoNegocio("Paciente cadastrado!");
		}
		
		IPacienteDAO pacienteDAO = FabricaDAO.getPacienteDAO();
		pacienteDAO.inserir(paciente);
	}
	
	@Override
	public void editar(Paciente paciente) throws ExcecaoNegocio {
		if (!this.verifica(paciente)) {
			throw new ExcecaoNegocio("Inválido!");
		}
		
		IPacienteDAO pacienteDAO = FabricaDAO.getPacienteDAO();
		pacienteDAO.editar(paciente);
		
	}

	@Override
	public Paciente remover(String cpf) {
		IPacienteDAO pacienteDAO = FabricaDAO.getPacienteDAO();
		return pacienteDAO.remover(cpf);
		
	}
	
	@Override
	public Paciente consultar(String cpf) {
		IPacienteDAO pacienteDAO = FabricaDAO.getPacienteDAO();
		return pacienteDAO.consultar(cpf);
		
		
	}

	@Override
	public List<Paciente> listarTodos() {
		IPacienteDAO pacienteDAO = FabricaDAO.getPacienteDAO();	
		return pacienteDAO.listarTodos();
		
	}
	
	
	
	

}
