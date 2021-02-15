package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefaController {
	
	private JdbcTarefaDao jdbcTarefaDao;
	
	@Autowired
	public TarefaController(JdbcTarefaDao jdbcTarefaDao) {
		this.jdbcTarefaDao = jdbcTarefaDao;
	}
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors()) {
			return "tarefa/formulario";
		}

		this.jdbcTarefaDao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public ModelAndView lista() {
		List<Tarefa> tarefas = this.jdbcTarefaDao.lista();
		ModelAndView mv = new ModelAndView("tarefa/lista");
		mv.addObject("tarefas", tarefas);
		return mv;
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		this.jdbcTarefaDao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", this.jdbcTarefaDao.buscaPorId(id));
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {		
		this.jdbcTarefaDao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) {
		this.jdbcTarefaDao.finaliza(id);
		model.addAttribute("tarefa", this.jdbcTarefaDao.buscaPorId(id));
		return "tarefa/finalizada";
	}
}
