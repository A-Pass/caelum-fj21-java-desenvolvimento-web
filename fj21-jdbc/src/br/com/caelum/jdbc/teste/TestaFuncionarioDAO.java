package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionarioDAO {

	public static void main(String[] args) {
		System.out.println("Teste de CRUD - Funcionarios");

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		System.out.println("  -> Cadastrando... ");
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Nome do funcionario");
		funcionario.setUsuario("Usuario");
		funcionario.setSenha("123");
		funcionarioDAO.adiciona(funcionario);
		
		System.out.println("  -> Resgatando... ");
		funcionario = funcionarioDAO.pesquisar(2);
		System.out.println("     ok!");

		System.out.println("  -> Alterando...");
		funcionario.setNome("Novo nome");
		funcionarioDAO.altera(funcionario);
		System.out.println("     ok!");

		System.out.println("  -> Deletando...");
		funcionarioDAO.remove(funcionario);
		System.out.println("     ok!");
	}

}
