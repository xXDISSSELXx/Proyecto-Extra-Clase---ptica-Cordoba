package co.edu.opticacordoba.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import co.edu.opticacordoba.croscutting.exceptions.DataOpticaException;
import co.edu.opticacordoba.data.dao.ClienteDAO;
import co.edu.opticacordoba.data.dao.TipoDocumentoDAO;
import co.edu.opticacordoba.data.dao.impl.sql.SqlDAO;
import co.edu.opticacordoba.entity.ClienteEntity;
import co.edu.opticacordoba.entity.TipoDocumentoEntity;

public final class TipoDocumentoSqlServerDAO extends SqlDAO implements TipoDocumentoDAO {

		protected TipoDocumentoSqlServerDAO(Connection connection) {
			super(connection);
		}

		@Override
		public void create(final TipoDocumentoEntity data) {
			final StringBuilder statement = new StringBuilder();
			statement.append("INSERT INTO TipoDocumento (id, tipodocumento) VALUES (?, ?)");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				preparedStatement.setInt(1, data.getId());
				preparedStatement.setString(2, data.getTipoDocumento());
				
				preparedStatement.executeUpdate();
				
				
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}
		
		@Override
		public TipoDocumentoEntity findByID(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<TipoDocumentoEntity> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<TipoDocumentoEntity> findByFilter(TipoDocumentoEntity filter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(Integer data) {
			
			final StringBuilder statement = new StringBuilder();
			statement.append("DELETE FROM Cliente WHERE id = ?");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				preparedStatement.setObject(1, data);
				
				preparedStatement.executeUpdate();
				
				
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}

		@Override
		public void update(final TipoDocumentoEntity data) {
			
			final StringBuilder statement = new StringBuilder();
			statement.append("UPDATE Cliente SET tipodocumento = ? WHERE id = ?");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				preparedStatement.setString(1, data.getTipoDocumento());
				preparedStatement.setInt(2, data.getId());
				
				preparedStatement.executeUpdate();
				
				
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}

	}

