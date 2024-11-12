package co.edu.opticacordoba.data.dao;

import co.edu.opticacordoba.croscutting.exceptions.DataOpticaException;
import co.edu.opticacordoba.data.dao.enums.DAOSource;
import co.edu.opticacordoba.data.dao.impl.sql.sqlserver.PostgreSQLDAOFactory;
import co.edu.uco.crosscutting.helpers.TextHelper;

public abstract class DAOFactory {

	public final static DAOFactory getFactory(final DAOSource source) {
		switch (source) {
		case POSTGRESQL: {
			return new PostgreSQLDAOFactory();
		}
		default:
			var userMessage = "Se ha presentdo un problema inesperado tratando de llevar a cabo la operación deseada...";
			var technicalMessage = TextHelper.concat("No existe una factoría implemantada para ", source.toString());
			throw DataOpticaException.crear(userMessage, technicalMessage);
		}
	}

	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract void closeConnection();

	public abstract ClienteDAO getClienteDAO();

	public abstract TipoDocumentoDAO getTipoDocumentoDAO();

}
