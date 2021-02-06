package br.com.caelum.agenda.dao;

import java.sql.SQLException;

public class DAOException extends RuntimeException {

	public DAOException(SQLException e) {
		super(e);
	}

}
