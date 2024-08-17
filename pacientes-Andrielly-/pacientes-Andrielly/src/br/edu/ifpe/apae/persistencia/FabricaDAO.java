package br.edu.ifpe.apae.persistencia;

import br.edu.ifpe.apae.entidades.Paciente;

public class FabricaDAO {

	public static <T> GenericDAO<T> getDAO() {
		return GenericDAO.getInstancia();
	}
}
