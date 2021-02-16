package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.UsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Transactional
@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("jpaUsuarioDao")
	private UsuarioDao usuarioDao;

	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (this.usuarioDao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:menu";
		}

		return "redirect:loginForm";
	}

	@RequestMapping("menu")
	public String home() {
		return "menu";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuarioLogado");
		return "redirect:loginForm";
	}
}
