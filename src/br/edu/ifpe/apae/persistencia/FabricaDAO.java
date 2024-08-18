package br.edu.ifpe.apae.persistencia;

public class FabricaDAO {
   
    public static <T> GenericDAO<T> getDAO() {
        return (GenericDAO<T>) GenericDAO.getInstancia();
    }
}
