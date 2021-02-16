package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Usuario;

public class AdicionaUsuario {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setLogin("a-pass");
		usuario.setSenha("a-pass");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();	
		
		manager.persist(usuario);
		
		manager.getTransaction().commit();
		
		System.out.println("ID da tarefa: " + usuario.getId());
		
		manager.close();

	}

}
