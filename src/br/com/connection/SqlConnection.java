package br.com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.exception.DaoException;

public class SqlConnection {
	private static Connection conexao = null;
	
	private SqlConnection() {
		
	}

	public static Connection getInstance() throws DaoException {
		
			try {
				if(conexao == null || conexao.isClosed()) {
				conexao = DriverManager.getConnection(
						SqlUtil.URL, 
						SqlUtil.LOGIN, 
						SqlUtil.SENHA);
				}	
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException("Erro ao conectar o banco de dados");
			}
			return conexao;
		
	}
	
}
