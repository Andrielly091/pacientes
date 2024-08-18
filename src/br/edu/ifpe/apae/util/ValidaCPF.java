package br.edu.ifpe.apae.util;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidaCPF implements AdapterCPF{
	private static final String CPF_PATTERN = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    public boolean valida(String cpf) {
      
        if (!cpf.matches(CPF_PATTERN)) {
            System.err.println("Erro: CPF deve estar no formato 000.000.000-00.");
            return false;
        }

        if (cpf.length() != 14) {
            System.err.println("Erro: CPF deve ter 14 caracteres.");
            return false;
        }

        if (!cpf.equals(cpf)) {
            System.err.println("Erro: CPFs não correspondem.");
            return false;
        }
		return true;

      
    }
}
