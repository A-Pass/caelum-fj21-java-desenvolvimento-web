package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDAO {
	private Connection connection;

	public FuncionarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionarios (nome, usuario, senha) values (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Funcionario> getLista() {
		List<Funcionario> funcionarios = new ArrayList<>();
		try (PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				funcionarios.add(this.novoFuncionario(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return funcionarios;
	}

	public List<Funcionario> getListaNomeContem(String nomeParcial) {
		List<Funcionario> funcionarios = new ArrayList<>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios where nome like ?");
			stmt.setString(1, "%" + nomeParcial + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				funcionarios.add(this.novoFuncionario(rs));
			}
			rs.close();
			stmt.close();
			return funcionarios;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public Funcionario pesquisar(int id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Funcionario funcionario = null;
			if (rs.next()) {
				funcionario = this.novoFuncionario(rs);
			}
			rs.close();
			stmt.close();
			return funcionario;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	private Funcionario novoFuncionario(ResultSet rs) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(rs.getLong("id"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setUsuario(rs.getString("usuario"));
		funcionario.setSenha(rs.getString("senha"));
		return funcionario;
	}

	public void altera(Funcionario funcionario) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("update funcionarios set nome = ?, usuario = ?, senha = ? where id = ?");
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			
			stmt.execute();
			
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void remove(Funcionario funcionario) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from funcionarios where id = ?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
