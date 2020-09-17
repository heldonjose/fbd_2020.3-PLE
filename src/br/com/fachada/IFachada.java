package br.com.fachada;

import java.util.List;

import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.model.Aluno;

public interface IFachada {
	public Aluno salvarAluno(Aluno aluno) throws BusinessException;
	public Aluno getAlunoPorCpf(String cpf) throws BusinessException;
	public boolean isAlunoPorCpf(String cpf) throws BusinessException;
	public List<Aluno> getAllAluno();
}
