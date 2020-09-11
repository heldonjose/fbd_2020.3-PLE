package br.com.business;

import java.util.List;

import br.com.exception.BusinessException;
import br.com.model.Aluno;

public interface IBusinessAluno {
	public Aluno salvar(Aluno aluno) throws BusinessException;
	public List<Aluno> getAll();
}
