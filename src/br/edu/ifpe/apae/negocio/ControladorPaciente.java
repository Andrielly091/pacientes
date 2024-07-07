package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
//import br.edu.ifpe.apae.persistencia.IPacienteDAO;

public class ControladorPaciente implements IControladorPaciente{


	@Override
	public Paciente consultar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente remover(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Paciente paciente) throws ExcecaoNegocio {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
