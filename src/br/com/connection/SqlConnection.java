package br.com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	private static Connection conexao = null;
	
	private SqlConnection() {
		
	}

	public static Connection getInstance() {
		
			try {
				if(conexao == null || conexao.isClosed()) {
				conexao = DriverManager.getConnection(
						SqlUtil.URL, 
						SqlUtil.LOGIN, 
						SqlUtil.SENHA);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conexao;
		
	}
	
}
