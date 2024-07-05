package br.edu.ifpe.apae.entidades;

public class Paciente {

	private String nome;
	private String N_cartao_SUS;
	private String cpf;

	public Paciente() {}

	public Paciente(String nome, String n_cartao_SUS, String cpf) {

		this.nome = nome;
		N_cartao_SUS = n_cartao_SUS;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getN_cartao_SUS() {
		return N_cartao_SUS;
	}

	public void setN_cartao_SUS(String n_cartao_SUS) {
		N_cartao_SUS = n_cartao_SUS;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public static class PacienteBuilder{
		private String nome;
		private String N_cartao_SUS;
		private String cpf;
		
		public PacienteBuilder nome (String nome) {
			this.nome = nome;
			
			return this;
			
		}
		public PacienteBuilder N_cartao_SUS (String N_cartao_SUS) {
			this.N_cartao_SUS = N_cartao_SUS;
			
			return this;
			
		}
		public PacienteBuilder cpf (String cpf) {
			this.cpf = cpf;
			
			return this;
			
		}
		public Paciente criar() {
			return new Paciente(this.nome, this.N_cartao_SUS, this.cpf);
			
		}
		
		
		
		
		
		
	}
	
	


}
