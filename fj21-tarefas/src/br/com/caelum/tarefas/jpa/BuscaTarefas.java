package br.com.caelum.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class BuscaTarefas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");

		EntityManager manager = factory.createEntityManager();

		List<Tarefa> tarefas = manager
				.createQuery("select t from Tarefa as t where t.finalizado = :paramFinalizado", Tarefa.class)
				.setParameter("paramFinalizado", true).getResultList();

		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa.getId() + ":" + tarefa.getDescricao());
		}

		manager.close();
	}

}
