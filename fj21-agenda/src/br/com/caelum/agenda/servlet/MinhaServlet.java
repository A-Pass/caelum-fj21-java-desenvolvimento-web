package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("Método service da servlet");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>teste</title></head><body>MinhaServlet</body></html>");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}
}