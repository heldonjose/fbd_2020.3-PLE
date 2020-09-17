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

		String createTable = "create table aluno(\n" + 
				"	id serial primary key, \n" + 
				"	nome varchar(255),\n" + 
				"	cpf varchar(11) unique\n" + 
				")";
		
		
		public final static String INSERT_ALL = ""
				+ "INSERT INTO "+ NAME_TABLE+
				"("+COL_NOME+","+COL_CPF+") VALUES(?,?) RETURNING id";
		
		public final static String SELECT_CPF = ""
				+ "SELECT * FROM "+ NAME_TABLE+
				" a WHERE a.cpf = ?";
	}
	public static class ContatoSQL{
		public final static String NAME_TABLE = "contato";
		public final static String COL_DESCRICAO = "descricao";
		public final static String COL_ALUNO_ID = "aluno_id";

//		String createTable = "create table aluno(\n" + 
//				"	id serial primary key, \n" + 
//				"	nome varchar(255),\n" + 
//				"	cpf varchar(11) unique\n" + 
//				")";
		
		
		public final static String INSERT_ALL = ""
				+ "INSERT INTO "+ NAME_TABLE+
				"("+COL_DESCRICAO+","+COL_ALUNO_ID+") VALUES(?,?) RETURNING id";
		
		public final static String SELECT_POR_ID_ALUNO = ""
				+ "SELECT * FROM "+ NAME_TABLE+
				" c WHERE c."+COL_ALUNO_ID+" = ?";
	}
}
//select * from aluno a where a.cpf = '123';