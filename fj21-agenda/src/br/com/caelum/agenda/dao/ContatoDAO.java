package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.agenda.factory.ConnectionFactory;

public class ContatoDAO {
	private Connection connection;

	public ContatoDAO(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<>();
		try (PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				contatos.add(this.novoContato(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return contatos;
	}

	public List<Contato> getListaNomeContem(String nomeParcial) {
		List<Contato> contatos = new ArrayList<>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome like ?");
			stmt.setString(1, "%" + nomeParcial + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contatos.add(this.novoContato(rs));
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public Contato pesquisar(long id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Contato contato = null;
			if (rs.next()) {
				contato = this.novoContato(rs);
			}
			rs.close();
			stmt.close();
			return contato;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	private Contato novoContato(ResultSet rs) throws SQLException {
		Contato contato = new Contato();

		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataNascimento"));
		contato.setDataNascimento(data);
		return contato;
	}

	public void altera(Contato contato) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement(
					"update contatos set nome = ?, email = ?, endereco = ?, dataNascimento = ? where id = ?");
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from contatos where id = ?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
