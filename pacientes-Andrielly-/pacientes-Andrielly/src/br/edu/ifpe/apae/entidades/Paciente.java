package br.edu.ifpe.apae.entidades;

public class Paciente {
	private Integer id;
	private String nome;
	private String nCartaoSUS;
	private String cpf;

	public Paciente() {}

	public Paciente(Integer id, String nome, String n_cartao_SUS, String cpf) {

		this.nome = nome;
		this.nCartaoSUS = n_cartao_SUS;
		this.cpf = cpf;
		this.id = id;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getnCartaoSUS() {
		return nCartaoSUS;
	}

	public void setnCartaoSUS(String nCartaoSUS) {
		this.nCartaoSUS = nCartaoSUS;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public static class PacienteBuilder{
		private Integer id;
		private String nome;
		private String nCartaoSUS;
		private String cpf;
		
		public PacienteBuilder nome (String nome) {
			this.nome = nome;
			
			return this;
			
		}
		public PacienteBuilder NCartaoSUS (String nCartaoSUS) {
			this.nCartaoSUS = nCartaoSUS;
			
			return this;
			
		}
		public PacienteBuilder cpf (String cpf) {
			this.cpf = cpf;
			
			return this;
			
		}
		public Paciente criar() {
			return new Paciente(this.id, cpf,this.nCartaoSUS, this.nCartaoSUS);
			
		}		
		
		
	}
	
}
