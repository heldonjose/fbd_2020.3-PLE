package br.com.business;

import java.util.List;

import br.com.dao.DaoAluno;
import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.model.Aluno;

public class BusinessAluno implements IBusinessAluno{
	private DaoAluno daoAluno;
	
	public BusinessAluno() {
		this.daoAluno = new DaoAluno();
	}
	
	
	public Aluno salvar(Aluno aluno) throws BusinessException {
//		Lógica de negócio
		if(aluno.getNome().split(" ").length<2) {
			throw new BusinessException("Nome deve conter nome e sobrenome");
		}
		try {
			aluno =  daoAluno.salvar(aluno);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());

			
		}
		return aluno;
	}
	public List<Aluno> getAll(){
		return null;
	}
}
