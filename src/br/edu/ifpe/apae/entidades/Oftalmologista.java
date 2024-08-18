package br.edu.ifpe.apae.entidades;

public class Oftalmologista implements Policlinica{
	Policlinica valorConsulta;
	public Oftalmologista(Policlinica valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	@Override
	public double getPagamento() {	
		return valorConsulta.getPagamento() + 175.00;
	}
}