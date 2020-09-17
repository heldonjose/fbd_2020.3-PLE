package br.com.fachada;

import java.util.List;

import br.com.business.BusinessAluno;
import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.model.Aluno;

public class Fachada implements IFachada {
	private BusinessAluno businessAluno = new BusinessAluno();
//	private BusinessTurma businessTurma = new BusinessTurma();
//	private BusinessProfessor businessProfessor = new BusinessProfessor();
	
	public Aluno salvarAluno(Aluno aluno) throws BusinessException{
		return this.businessAluno.salvar(aluno);
	}
	
	public Aluno getAlunoPorCpf(String cpf) throws BusinessException{
		return this.businessAluno.getPorCpf(cpf);
	}
	public boolean isAlunoPorCpf(String cpf) throws BusinessException{
		return this.businessAluno.isPorCpf(cpf);
	}
	public List<Aluno> getAllAluno(){
		return null;
	}
}
