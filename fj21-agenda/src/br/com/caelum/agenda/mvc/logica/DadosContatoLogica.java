package br.com.caelum.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class DadosContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String idTxt = req.getParameter("id");
		Contato contato = null;
		
		if(idTxt != null) {
			contato = new ContatoDAO().pesquisar(Long.parseLong(idTxt));
			req.setAttribute("contato", contato);
		}
		
		return "WEB-INF/jsp/dados-contato.jsp";
	}

}
