package br.edu.ifpe.apae.entidades;

public class Cardiologista implements Policlinica{
	private Policlinica valorConsulta;
	public Cardiologista(Policlinica valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	@Override
	public double getPagamento() {

		return valorConsulta.getPagamento() + 200.00;
	}
}