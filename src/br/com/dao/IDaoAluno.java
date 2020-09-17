package br.com.dao;

import java.util.List;

import br.com.exception.DaoException;
import br.com.model.Aluno;

public interface IDaoAluno {
	public Aluno salvar(Aluno aluno) throws DaoException;
	public Aluno getPorCpf(String cpf) throws DaoException;
	public boolean isPorCpf(String cpf) throws DaoException;
	
	public List<Aluno> getAll();
//	Mais métodos
}
