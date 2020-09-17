package br.com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.connection.SqlConnection;
import br.com.exception.BusinessException;
import br.com.fachada.Fachada;
import br.com.model.Aluno;
import br.com.model.Contato;

public class Main {

	public static void main(String[] args) {
		System.out.println("INICIO");

		Fachada fachada = new Fachada();
//		
		Aluno aluno1 = new Aluno("HELOA Dantas", "1111");
		aluno1.addContato(new Contato("11111111"));
		aluno1.addContato(new Contato("22222222222"));
//		Aluno aluno2 = new Aluno("CARLOS CARLOS", "456");
//		
		try {
//			if(!fachada.isAlunoPorCpf(aluno1.getCpf())) {
//				aluno1 = fachada.salvarAluno(aluno1);
//				System.out.println("Aluno salvo com sucesso " + aluno1.getId());
//			}else {
//				System.out.println("Aluno de CPF: " + aluno1.getCpf()+" já existe");
//			}
//			if(!fachada.isAlunoPorCpf(aluno2.getCpf())) {
//				fachada.salvarAluno(aluno1);
//			}else {
//				System.out.println("Aluno de CPF: " + aluno2.getCpf()+" já existe");
//			}
			Aluno aluno = fachada.getAlunoPorCpf("1111");
			System.out.println(aluno);

		} catch (BusinessException e) {
			// tratamento correto de exibir a mensagem de erro;
			e.printStackTrace();
		}

		System.out.println("FIM");
	}

}
