package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;
import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaListaContato {

	public static void main(String[] args) {
		List<Contato> contatos = new ContatoDAO().getListaNomeContem("Ander");

		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());

			System.out.println("Data de Nascimento: "
					+ new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()) + "\n");
		}
	}

}
