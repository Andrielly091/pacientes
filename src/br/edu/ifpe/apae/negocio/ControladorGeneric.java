package br.edu.ifpe.apae.negocio;

import java.util.List;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
import br.edu.ifpe.apae.persistencia.IGenericDAO;

public abstract class ControladorGeneric<T> {
    private IGenericDAO<T> genericDAO;

    public ControladorGeneric() {
        this.genericDAO = FabricaDAO.getDAO();
    }

    public List<T> listarTodos() throws ExcecaoNegocio {
        return genericDAO.listarTodos();
    }

    public T consultarPorId(Integer id) throws ExcecaoNegocio {
        return genericDAO.consultarPorId(id);
    }

    public void inserir(T objeto) throws ExcecaoNegocio {
        genericDAO.inserir(objeto);
    }

    public void editar(T objeto) throws ExcecaoNegocio {
        genericDAO.editar(objeto);
    }

    public void remover(Integer id) throws ExcecaoNegocio {
        genericDAO.remover(id);
    }

    protected IGenericDAO<T> getDao() {
        return genericDAO;
    }
}
