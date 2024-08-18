package br.edu.ifpe.apae.negocio;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.GenericDAO;

public class ControladorPaciente extends ControladorGeneric<Paciente> implements IControladorPaciente{
	
	private List<Paciente> pacientes = new ArrayList<>();
	
	private boolean verifica(Paciente paciente) {
		return true;
	}

    @Override
    public void inserir(Paciente paciente) throws ExcecaoNegocio {
        if (consultarPorCPF(paciente.getCpf()) != null) {
            throw new ExcecaoNegocio("Paciente com CPF já cadastrado.");
        }
        pacientes.add(paciente);
    }

    @Override
    public Paciente consultarPorCPF(String cpf) throws ExcecaoNegocio {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
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
	public Paciente consultar(Paciente paciente) throws ExcecaoNegocio{
		GenericDAO<Paciente> pacienteDAO = FabricaDAO.getDAO();
		Paciente paciente1 = pacienteDAO.consultar(paciente);
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

	@Override
	public void remover(String cpf) throws ExcecaoNegocio {
		GenericDAO<Paciente> pacienteDAO = FabricaDAO.getDAO();
		pacienteDAO.remover(cpf);
		
		
	}
	
}