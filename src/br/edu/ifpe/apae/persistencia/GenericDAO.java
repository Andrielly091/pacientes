package br.edu.ifpe.apae.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;

public class GenericDAO<T> implements IGenericDAO<T> {

	private List<T> lista;

	private static GenericDAO<?> instancia;

	private GenericDAO() {
		this.lista = new ArrayList<>();

	}

	public static <T> GenericDAO<T> getInstancia(){
		if(instancia == null) {
			instancia = new GenericDAO<>();
		}
		return (GenericDAO<T>) instancia;	

	}

	@Override
	public void inserir(T objeto) {
		this.lista.add(objeto);	

	}

	@Override
	public void editar(T objeto) throws ExcecaoNegocio {
		int indice = lista.indexOf(objeto);
		if(indice != -1) {
			lista.set(indice, objeto);
		}else {
			throw new ExcecaoNegocio("Objeto não encontrado na lista!");
		}

	}



	public T consultar1(String cpf) {
		for (T objeto : lista) {
			if(objeto instanceof Paciente) {
				Paciente paciente = (Paciente) objeto;
				if(paciente.getCpf().equals(cpf)) {

					return objeto;
				}	
			}

		}
		return null;
	}

	@Override
	public List<T> listarTodos() {

		return new ArrayList<>(this.lista);
	}



	@Override
	public T consultar(Paciente paciente2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T consultar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String cpf) throws ExcecaoNegocio {
		// TODO Auto-generated method stub
		
	}


}
