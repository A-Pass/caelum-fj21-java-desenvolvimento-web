package br.com.caelum.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class MostraContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new ContatoDAO().pesquisar(id);
		
		req.setAttribute("contato", contato);
		
		return "mostra-contato.jsp";
	}

}
