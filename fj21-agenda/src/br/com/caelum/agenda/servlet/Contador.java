package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Contador extends HttpServlet {
	private int contador = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		this.contador++;
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Contador</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Contador agora é: " + this.contador);
		out.println("</body>");
		out.println("</html>");
	}
}
