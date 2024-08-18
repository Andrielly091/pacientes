package br.edu.ifpe.apae.persistencia;

import java.util.List;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public interface IGenericDAO<T> {
    void inserir(T objeto);
    void editar(T objeto) throws ExcecaoNegocio;
    List<T> listarTodos();
    T consultarPorId(Integer id) throws ExcecaoNegocio;
    void remover(Integer id) throws ExcecaoNegocio;
}
