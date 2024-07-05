package br.edu.ifpe.apae.negocio;

import br.edu.ifpe.apae.entidades.Paciente;
import br.edu.ifpe.apae.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apae.persistencia.FabricaDAO;
//import br.edu.ifpe.apae.persistencia.IPacienteDAO;

public class ControladorPaciente implements IControladorPaciente{
	
	public void inserir(Paciente paciente) throws ExcecaoNegocio{
		
		/*if(!this.isValido(paciente)){
			
			throw new ExcecaoNegocio("Paciente Inválido!")
			
		}
		
		IPacienteDAO dao = FabricaDAO.getPacienteDAO();
		dao.inserir(paciente);
		
	*/} 

	private void isValido(Paciente paciente) {
		
		
		
	}
	
	
	

}
