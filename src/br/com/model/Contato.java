package br.com.model;

public class Contato {
	int id;
	String descricao;
	
	
	public Contato() {
	}
	
	public Contato(String descricao) {
		super();
		this.descricao = descricao;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", descricao=" + descricao + "]";
	}

	
	
}
