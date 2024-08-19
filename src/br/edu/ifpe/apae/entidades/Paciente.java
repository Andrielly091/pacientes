package br.edu.ifpe.apae.entidades;


public class Paciente extends EntidadeBase {
    private String nome;
    private String nCartaoSUS;
    private String cpf;
    
    public Paciente() {}

    public Paciente(String nome, String nCartaoSUS, String cpf) {
        super();
        this.nome = nome;
        this.nCartaoSUS = nCartaoSUS;
        this.cpf = cpf;
    }

    // Getters e Setters
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

    public static class PacienteBuilder {
        private String nome;
        private String nCartaoSUS;
        private String cpf;
		private Integer id;
        
        
        public PacienteBuilder id(Integer id) {
			this.id = id;
			return this;
		}

        public PacienteBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PacienteBuilder nCartaoSUS(String nCartaoSUS) {
            this.nCartaoSUS = nCartaoSUS;
            return this;
        }

        public PacienteBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Paciente criar() {
            return new Paciente(this.nome, this.nCartaoSUS, this.cpf);
        }
    }
}
