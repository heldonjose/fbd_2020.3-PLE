package br.com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.connection.SqlConnection;
import br.com.exception.BusinessException;
import br.com.fachada.Fachada;
import br.com.model.Aluno;

public class Main {

	public static void main(String[] args) {
		System.out.println("INICIO");
		
		Fachada fachada = new Fachada();
		
		Aluno aluno1 = new Aluno("HELDON JOSE", "123");
		Aluno aluno2 = new Aluno("CARLOS", "456");
		
		try {
			fachada.salvarAluno(aluno1);
			fachada.salvarAluno(aluno2);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("FIM");
	}

}
