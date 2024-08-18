package br.edu.ifpe.apae.negocio;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.GenericDAO;

public class ControladorPaciente extends ControladorGeneric<Paciente> implements IControladorPaciente {

    private GenericDAO<Paciente> pacienteDAO = FabricaDAO.getDAO();

    @Override
    public void inserir(Paciente paciente) throws ExcecaoNegocio {
        if (consultarPorCPF(paciente.getCpf()) != null) {
            throw new ExcecaoNegocio("Paciente com CPF já cadastrado.");
        }
        pacienteDAO.inserir(paciente);
    }

    @Override
    public Paciente consultarPorCPF(String cpf) throws ExcecaoNegocio {
        for (Paciente paciente : pacienteDAO.listarTodos()) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public void editar(Paciente paciente) throws ExcecaoNegocio {
        if (pacienteDAO.consultarPorId(paciente.getId()) == null) {
            throw new ExcecaoNegocio("Paciente não encontrado.");
        }
        pacienteDAO.editar(paciente);
    }

    @Override
    public Paciente consultarPorId(Integer id) throws ExcecaoNegocio {
        Paciente paciente = pacienteDAO.consultarPorId(id);
        if (paciente == null) {
            throw new ExcecaoNegocio("Paciente não encontrado.");
        }
        return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteDAO.listarTodos();
    }

    @Override
    public void remover(String cpf) throws ExcecaoNegocio {
        Paciente paciente = consultarPorCPF(cpf);
        if (paciente != null) {
            pacienteDAO.remover(paciente.getId());
        } else {
            throw new ExcecaoNegocio("Paciente com CPF não encontrado.");
        }
    }
}
