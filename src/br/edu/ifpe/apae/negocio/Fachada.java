package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class Fachada {
	
	private IControladorPaciente controladorPaciente;
	
	public Fachada() {
		controladorPaciente = FabricaControlador.getControladorPaciente();
	}
	
	public void inserir(Paciente paciente) throws ExcecaoNegocio{
		controladorPaciente.inserir(paciente);
	}

	public void editar(Paciente paciente) throws ExcecaoNegocio{
		controladorPaciente.editar(paciente);
	}

	public void remover(String cpf) throws ExcecaoNegocio{
		controladorPaciente.remover(cpf);
	}

	public List<Paciente> listarTodos(){
		return controladorPaciente.listarTodos();
	}
	
	public Paciente consultarPorCPF(String cpf) throws ExcecaoNegocio {
		return controladorPaciente.consultarPorCPF(cpf);
	}

}
