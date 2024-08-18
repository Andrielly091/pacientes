package br.edu.ifpe.apae.entidades;

public class Dermatologista implements Policlinica{
	Policlinica valorConsulta;
	public Dermatologista(Policlinica valorConsulta) {
		super();
		this.valorConsulta = valorConsulta;
	}
	@Override
	public double getPagamento() {
		
		return valorConsulta.getPagamento() + 100.00;
	}
}