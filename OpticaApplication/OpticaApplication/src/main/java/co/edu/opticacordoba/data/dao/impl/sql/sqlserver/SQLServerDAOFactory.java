package co.edu.opticacordoba.data.dao.impl.sql.sqlserver;

import java.sql.Connection;

import co.edu.opticacordoba.data.dao.ClienteDAO;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.data.dao.TipoDocumentoDAO;
import co.edu.opticacrosscutting.helpers.SqlConnectionHelper;

public final class SQLServerDAOFactory extends DAOFactory{
	
	private Connection connection;

	public SQLServerDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		SqlConnectionHelper.validateIfConnectionIsOpen(connection);
		var connectionString = "jdbc:sqlserver://ucobet-server.database.windows.net:1433;database=ucobet-db;user=ucobetdbuser;password=uc0b3tdbus3r!;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		connection = SqlConnectionHelper.openConnection(connectionString);
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
		// TODO Auto-generated method stub
		return new ClienteSqlServerDAO(connection);
	}

	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		// TODO Auto-generated method stub
		return new TipoDocumentoSqlServerDAO(connection);
	}

}
