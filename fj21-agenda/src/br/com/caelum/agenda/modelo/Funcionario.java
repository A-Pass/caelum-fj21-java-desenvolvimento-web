package br.com.caelum.agenda.modelo;

public class Funcionario {
	private long id;
	private String nome;
	private String usuario;
	private String senha;

	public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}

	public final String getUsuario() {
		return usuario;
	}

	public final void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public final String getSenha() {
		return senha;
	}

	public final void setSenha(String senha) {
		this.senha = senha;
	}
}
