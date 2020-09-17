package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	int id;
	String nome;
	String cpf;
	List<Contato> contatos;
	
	public Aluno() {
		this.contatos = new ArrayList<>();
	}
	
	public Aluno(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.contatos = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public void addContato(Contato contato) {
		this.contatos.add(contato);
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", contatos=" + contatos + "]";
	}

	
	
	
//	public String toSql() {
//		return "insert into aluno(nome, cpf) values("+this.nome+","+this.cpf+")";
//	}
	
}
