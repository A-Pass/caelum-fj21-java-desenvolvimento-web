package br.com.caelum.agenda.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionaContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimentoTxt = req.getParameter("dataNascimento");

		Calendar dataNascimento = null;

		try {
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTxt));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		new ContatoDAO((Connection) req.getAttribute("conexao")).adiciona(contato);

		return "mvc?logica=ListaContatosLogica";
	}

}
