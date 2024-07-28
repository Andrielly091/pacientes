package br.edu.ifpe.apae.persistencia;

import java.util.List;
import br.edu.ifpe.apae.entidades.Paciente;

public class FabricaDAO {

	public static <T> GenericDAO<Paciente> getDAO() {
		return GenericDAO.getInstancia();
	}
}
