package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class Fachada {
	
	ControladorPaciente controladorPaciente;
	
	public Fachada() {
		this.controladorPaciente = new ControladorPaciente();
	}
	
	void inserir(Paciente paciente) throws ExcecaoNegocio{
		controladorPaciente.inserir(paciente);
	}

	void editar(Paciente paciente) throws ExcecaoNegocio{
		controladorPaciente.editar(paciente);
	}

	void remover(String cpf) throws ExcecaoNegocio{
		controladorPaciente.remover(cpf);
	}

	List<Paciente> listarTodos(){
		return controladorPaciente.listarTodos();
	}
	
	Paciente consultarPorCPF(String cpf) throws ExcecaoNegocio {
		return controladorPaciente.consultarPorCPF(cpf);
	}

}
