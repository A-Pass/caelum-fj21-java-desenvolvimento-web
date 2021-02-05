package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInseriContato {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Anderson Passos Silva");
		contato.setEmail("a-pass@passos.com");
		contato.setEndereco("Rua a-pass n. 12345");
		Calendar data = Calendar.getInstance();
		data.set(2000, Calendar.JANUARY, 1);
		contato.setDataNascimento(data);
		
		new ContatoDAO().adiciona(contato);
		
		System.out.println("Gravado!");
	}
}
