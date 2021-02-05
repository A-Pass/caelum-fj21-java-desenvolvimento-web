package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaContatoDAO {

	public static void main(String[] args) {
		System.out.println("Teste de CRUD - Contatos");

		ContatoDAO contatoDAO = new ContatoDAO();

		System.out.println("  -> Cadastrando... ");
		System.out.print("     ");
		TestaInseriContato.main(args);

		System.out.println("  -> Resgatando... ");
		Contato contato = contatoDAO.pesquisar(1);
		System.out.println("     ok!");

		System.out.println("  -> Alterando...");
		contato.setEndereco("Novo endereco");
		contatoDAO.altera(contato);
		System.out.println("     ok!");

		System.out.println("  -> Deletando...");
		contatoDAO.remove(contato);
		System.out.println("     ok!");
	}

}
