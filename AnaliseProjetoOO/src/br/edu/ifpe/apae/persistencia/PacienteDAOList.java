package br.edu.ifpe.apae.persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;

public class PacienteDAOList implements IPacienteDAO{

	private List<Paciente> pacientes;
	private static PacienteDAOList instancia;

	public PacienteDAOList() {
		this.pacientes = new ArrayList<>();

	}

	protected static PacienteDAOList getInstancia() {
		if(instancia == null) {
			instancia = new PacienteDAOList();
		}
		return instancia;

	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public static void setInstancia(PacienteDAOList instancia) {
		PacienteDAOList.instancia = instancia;
	}

	public void inserir(Paciente paciente) {
		this.pacientes.add(paciente);
	}
	
	@Override
	public void editar(Paciente paciente) {
		for (Paciente elementoPaciente : pacientes) {
			if(elementoPaciente.getCpf().equals(paciente.getCpf())) {

				elementoPaciente.setCpf(paciente.getCpf());
				elementoPaciente.setnCartaoSUS(paciente.getnCartaoSUS());
				elementoPaciente.setNome(paciente.getNome());
				
				return;

			}
		}
	}
	@Override
	public void remover(String cpf) {
		pacientes.removeIf(paciente -> paciente.getCpf() == cpf);
		
	}

	public Paciente consultar(String cpf){
		for (Paciente paciente : pacientes) {
			if(paciente.getCpf() == paciente.getCpf()) {
				return paciente;
			}
		}
		return null;
		
	}

	

	@Override
	public List<Paciente> listarTodos() {
		return pacientes;
	}






}
