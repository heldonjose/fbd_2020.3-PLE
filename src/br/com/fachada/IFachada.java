package br.com.fachada;

import java.util.List;

import br.com.exception.BusinessException;
import br.com.model.Aluno;

public interface IFachada {
	public Aluno salvarAluno(Aluno aluno) throws BusinessException;
	public List<Aluno> getAllAluno();
}
