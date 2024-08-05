package br.edu.ifpe.apae.entidades;

public class EntidadeBase {
	private static Integer nextID = 1;
	private Integer id;
	
	public EntidadeBase(Integer id) {

		this.id = nextID++;
	}

	public static Integer getNextID() {
		return nextID;
	}

	public static void setNextID(Integer nextID) {
		EntidadeBase.nextID = nextID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	

}
