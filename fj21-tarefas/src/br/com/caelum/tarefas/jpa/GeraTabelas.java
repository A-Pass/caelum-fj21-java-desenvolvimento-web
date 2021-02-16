package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) {
		GeraTabelas.create("tarefas");
		GeraTabelas.create("usuarios");
	}
	
	private static void create(String unitName) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitName);
		factory.close();
	}

}
