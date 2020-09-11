package br.com.dao;

import java.util.List;

import br.com.exception.DaoException;
import br.com.model.Aluno;

public interface IDaoAluno {
	public Aluno salvar(Aluno aluno) throws DaoException;
	public List<Aluno> getAll();
//	Mais métodos
}
