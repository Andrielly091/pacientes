package br.edu.ifpe.apae.entidades;

public class Fisioterapeuta implements Policlinica{
	Policlinica valorConsulta;

	public Fisioterapeuta(Policlinica valorConsulta) {

		this.valorConsulta = valorConsulta;
	}
	@Override
	public double getPagamento() {
		
		return valorConsulta.getPagamento() + 200.00;
	}
}