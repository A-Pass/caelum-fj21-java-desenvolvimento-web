package br.com.caelum.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Long id = Long.parseLong(req.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);
		new ContatoDAO().remove(contato);
		System.out.println("Excluindo contato... ");
		return "mvc?logica=ListaContatosLogica";
	}

}
