package br.edu.ifpe.apae.util;

import br.com.caelum.stella.validation.CPFValidator;

public class ValidaCPF implements AdapterCPF{

	public  boolean valida(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	
}
