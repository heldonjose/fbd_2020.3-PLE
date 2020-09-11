package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.connection.SqlConnection;
import br.com.connection.SqlUtil;
import br.com.exception.DaoException;
import br.com.model.Aluno;

public class DaoAluno implements IDaoAluno{
	
	private Connection conexao;
	private PreparedStatement statement;
	
	public DaoAluno() {
		this.conexao = SqlConnection.getInstance();
	}
	
	public Aluno salvar(Aluno aluno) throws DaoException{
		try {
			this.statement = conexao.prepareStatement(SqlUtil.AlunoSQL.INSERT_ALL);
			this.statement.setString(1, aluno.getNome());
			this.statement.setString(2, aluno.getCpf());
			this.statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Problema de conexão, contactar o admin");
			
		}
		
		
		return aluno;
	}
	public List<Aluno> getAll(){
		return null;
	}
}
