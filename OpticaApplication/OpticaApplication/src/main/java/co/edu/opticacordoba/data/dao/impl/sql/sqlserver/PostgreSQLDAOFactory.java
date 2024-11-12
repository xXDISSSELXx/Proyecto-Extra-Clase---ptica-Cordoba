package co.edu.opticacordoba.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;

import co.edu.opticacordoba.data.dao.ClienteDAO;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.data.dao.TipoDocumentoDAO;
import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;

public final class PostgreSQLDAOFactory extends DAOFactory{
	
	private Connection connection;

	public PostgreSQLDAOFactory() {
		openConnection();
	}
	
	@Override
	protected void openConnection() {
		SqlConnectionHelper.validateIfConnectionIsOpen(connection);
		var connectionString = "jdbc:postgresql://localhost:5432/OpticaDOO?user=postgres&password=musical2";
		connection = SqlConnectionHelper.openConnection("jdbc:postgresql://localhost:5432/OpticaDOO", "postgres", "musical2");
	}

	@Override
	public void initTransaction() {
		SqlConnectionHelper.initTransaction(connection);
	}

	@Override
	public void commitTransaction() {
		SqlConnectionHelper.commitTransaction(connection);
	}

	@Override
	public void rollbackTransaction() {
		
		SqlConnectionHelper.rollbackTransaction(connection);
	}

	@Override
	public void closeConnection() {
		SqlConnectionHelper.closeConnection(connection);
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new ClientePostgreSQLDAO(connection);
	}

	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		return new TipoDocumentoPostgreSQLDAO(connection);
	}

}
