package br.edu.ifpe.apae.apresentacao;

public class Psicologo implements Policlinica{
	Policlinica valorConsulta;

	public Psicologo(Policlinica valorConsulta) {

		this.valorConsulta = valorConsulta;
	}

	@Override
	public double getPagamento() {
		
		return valorConsulta.getPagamento() + 150.00;
	}
	
	
	

}
