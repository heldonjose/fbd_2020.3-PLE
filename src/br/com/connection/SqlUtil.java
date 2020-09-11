package br.com.connection;

public class SqlUtil {
	public final static String URL = "jdbc:postgresql://localhost:5432/aulafbd";
	public final static String LOGIN = "postgres";
	public final static String SENHA = "postgres";
	public final static String COL_ID = "id";
	
	public static class AlunoSQL{
		public final static String NAME_TABLE = "aluno";
		public final static String COL_NOME = "nome";
		public final static String COL_CPF = "cpf";

		
		public final static String INSERT_ALL = ""
				+ "INSERT INTO "+ NAME_TABLE+
				"("+COL_NOME+","+COL_CPF+") VALUES(?,?)";
	}
	
}
