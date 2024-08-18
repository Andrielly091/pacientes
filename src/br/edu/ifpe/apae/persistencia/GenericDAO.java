package br.edu.ifpe.apae.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.apae.entidades.EntidadeBase;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class GenericDAO<T> implements IGenericDAO<T> {

    private List<T> lista = new ArrayList<>();
    private static GenericDAO<?> instancia;

    private GenericDAO() {}

    public static <T> GenericDAO<T> getInstancia() {
        if (instancia == null) {
            instancia = new GenericDAO<>();
        }
        return (GenericDAO<T>) instancia;
    }

    @Override
    public void inserir(T objeto) {
        lista.add(objeto);
    }

    @Override
    public void editar(T objeto) throws ExcecaoNegocio {
        int indice = lista.indexOf(objeto);
        if (indice != -1) {
            lista.set(indice, objeto);
        } else {
            throw new ExcecaoNegocio("Objeto não encontrado na lista!");
        }
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(lista);
    }

    @Override
    public T consultarPorId(Integer id) throws ExcecaoNegocio {
        for (T objeto : lista) {
            if (objeto instanceof EntidadeBase) {
                EntidadeBase entidade = (EntidadeBase) objeto;
                if (entidade.getId().equals(id)) {
                    return objeto;
                }
            }
        }
        throw new ExcecaoNegocio("Objeto não encontrado na lista!");
    }

    @Override
    public void remover(Integer id) throws ExcecaoNegocio {
        T objeto = consultarPorId(id);
        if (objeto != null) {
            lista.remove(objeto);
        }
    }
}
