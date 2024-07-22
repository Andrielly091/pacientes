package br.edu.ifpe.apae.persistencia;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;

public interface IPacienteDAO {
	
	void inserir(Paciente paciente);
	void editar(Paciente paciente);
	void remover(String cpf);

	Paciente consultar(String cpf);
	List<Paciente> listarTodos();

}
