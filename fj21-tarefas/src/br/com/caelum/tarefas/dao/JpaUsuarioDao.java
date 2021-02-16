package br.com.caelum.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Usuario;

@Repository
public class JpaUsuarioDao implements UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean existeUsuario(Usuario usuario) {
		List<Usuario> usuarios = manager
				.createQuery("select u from Usuario u where login = :login and senha = :senha", Usuario.class)
				.setParameter("login", usuario.getLogin())
				.setParameter("senha", usuario.getSenha())
				.getResultList();
		
		return !usuarios.isEmpty();
	}

}
