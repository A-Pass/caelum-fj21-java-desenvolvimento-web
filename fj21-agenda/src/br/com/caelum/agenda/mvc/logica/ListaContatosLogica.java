package br.com.caelum.agenda.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<Contato> contatos = new ContatoDAO((Connection) req.getAttribute("conexao")).getLista();

		req.setAttribute("contatos", contatos);
		
		return "WEB-INF/jsp/lista-contatos.jsp";
	}

}
