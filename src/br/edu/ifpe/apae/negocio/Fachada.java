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

	Paciente consultar(Integer id) throws ExcecaoNegocio{
		return controladorPaciente.consultar(id);
	}

	void editar(Paciente paciente) throws ExcecaoNegocio{
		controladorPaciente.editar(paciente);
	}

	void remover(Integer id) throws ExcecaoNegocio{
		controladorPaciente.remover(id);
	}

	List<Paciente> listarTodos(){
		return controladorPaciente.listarTodos();
	}

}
