package br.com.caelum.agenda.modelo;

import java.util.Calendar;

public class Contato {
	private long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

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

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getEndereco() {
		return endereco;
	}

	public final void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public final Calendar getDataNascimento() {
		return dataNascimento;
	}

	public final void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
