package br.edu.ifpe.apae.persistencia;

import java.util.List;

import br.edu.ifpe.apae.entidades.Paciente;

public class FabricaDAO {

	/*public static <T> IGenericDAO<T> getDAO(){
		
		return new GenericDAO<T>();
	}*/
	
	public static IPacienteDAO getPacienteDAO() {
        return PacienteDAOList.getInstancia();
    }
}
