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
	public void inserir(Paciente paciente) {
		this.pacientes.add(paciente);
	}

	public void editar(Paciente paciente) {
		for (Paciente elementoPaciente : pacientes) {
			if(elementoPaciente.getCpf() == paciente.getCpf()) {

				elementoPaciente.setCpf(paciente.getCpf());
				elementoPaciente.setN_cartao_SUS(paciente.getN_cartao_SUS());
				elementoPaciente.setNome(paciente.getNome());

			}
		}
	}
	public void remover(String cpf) {
		for (Iterator<Paciente> iterator = pacientes.iterator(); iterator.hasNext();) {
			Paciente paciente = iterator.next();

			if (paciente.getCpf().equalsIgnoreCase(cpf)) {
				iterator.remove();

			}
		}
	}
	public List<Paciente> pacientes_total(){
		return pacientes;

	}
	public List<Paciente> consultar(String cpf){
		List<Paciente> consultandoPacientes = new ArrayList<>();
		for (Paciente paciente : pacientes) {
			if(paciente.getCpf().equalsIgnoreCase(cpf)) {
				consultandoPacientes.add(paciente);
			}
		}
		return consultandoPacientes;
	}






}
