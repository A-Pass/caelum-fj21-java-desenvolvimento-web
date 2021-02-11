package br.com.caelum.agenda.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {


		long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimentoTxt = req.getParameter("dataNascimento");

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTxt));

		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDAO contatoDAO = new ContatoDAO((Connection) req.getAttribute("conexao"));
		contatoDAO.altera(contato);		
		List<Contato> contatos = contatoDAO.getLista();

		req.setAttribute("contatos", contatos);

		return "mvc?logica=ListaContatosLogica";
	}
}
