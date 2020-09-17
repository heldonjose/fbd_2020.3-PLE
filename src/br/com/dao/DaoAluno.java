package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connection.SqlConnection;
import br.com.connection.SqlUtil;
import br.com.exception.DaoException;
import br.com.model.Aluno;
import br.com.model.Contato;

public class DaoAluno implements IDaoAluno {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	public DaoAluno() {

	}

	public void abrirConexao() throws DaoException {
		this.conexao = SqlConnection.getInstance();
	}

	public Aluno salvar(Aluno aluno) throws DaoException {
		this.abrirConexao();
		try {

			this.statement = conexao.prepareStatement(SqlUtil.AlunoSQL.INSERT_ALL);
			this.statement.setString(1, aluno.getNome());
			this.statement.setString(2, aluno.getCpf());
			this.result = this.statement.executeQuery();
			this.result.next();
			aluno.setId(result.getInt(1));

			this.salvarContatos(aluno.getContatos(), aluno.getId());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Problema de conexão, contactar o admin");

		}
		return aluno;
	}

	@Override
	public boolean isPorCpf(String cpf) throws DaoException {
		this.abrirConexao();
		try {
			this.statement = this.conexao.prepareStatement(SqlUtil.AlunoSQL.SELECT_CPF);
			this.statement.setString(1, cpf);
			this.result = this.statement.executeQuery();
			return result.next();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Usuário não existe");

		}
	}

	@Override
	public Aluno getPorCpf(String cpf) throws DaoException {
		this.abrirConexao();
		Aluno aluno = null;
		try {
			this.statement = this.conexao.prepareStatement(SqlUtil.AlunoSQL.SELECT_CPF);
			this.statement.setString(1, cpf);
			this.result = this.statement.executeQuery();
			if (result.next()) {
				aluno = new Aluno();
				aluno.setId(this.result.getInt(1));
				aluno.setNome(this.result.getString(2));
				aluno.setCpf(this.result.getString(3));
				aluno.setContatos(this.getContatosIdAluno(aluno.getId()));
			} else {
				return aluno;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Usuário não existe");

		}

		return aluno;
	}

	private List<Contato> getContatosIdAluno(int idAluno) throws DaoException {
		this.abrirConexao();
		List<Contato> contatos = new ArrayList<>();
		try {
			this.statement = this.conexao.prepareStatement(SqlUtil.ContatoSQL.SELECT_POR_ID_ALUNO);
			this.statement.setInt(1, idAluno);
			this.result = this.statement.executeQuery();
			while (result.next()) {
				Contato c = new Contato();
				c.setId(this.result.getInt(1));
				c.setDescricao(this.result.getString(2));
				contatos.add(c);
			}
			return contatos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro de Conexão");

		}

	}

	private void salvarContatos(List<Contato> contatos, int idAluno) throws DaoException {
		this.abrirConexao();
		try {
			for (Contato contato : contatos) {
				this.statement = conexao.prepareStatement(SqlUtil.ContatoSQL.INSERT_ALL);
				this.statement.setString(1, contato.getDescricao());
				this.statement.setInt(2, idAluno);
				this.statement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Problema de conexão, contactar o admin");

		}
	}

	public List<Aluno> getAll() {
		return null;
	}

}
