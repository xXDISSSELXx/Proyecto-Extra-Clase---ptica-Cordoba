package co.edu.opticacordoba.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import co.edu.opticacordoba.croscutting.exceptions.DataOpticaException;
import co.edu.opticacordoba.data.dao.ClienteDAO;
import co.edu.opticacordoba.data.dao.impl.sql.SqlDAO;
import co.edu.opticacordoba.entity.ClienteEntity;

public final class ClienteSqlServerDAO extends SqlDAO implements ClienteDAO {

		protected ClienteSqlServerDAO(Connection connection) {
			super(connection);
		}

		@Override
		public void create(final ClienteEntity data) {
			final StringBuilder statement = new StringBuilder();
			statement.append("INSERT INTO Cliente(id, numerodocumento, tipoDocumento, nombre, apellidos, telefono, correo) VALUES (?, ?, ?, ?, ? , ?, ?)");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				preparedStatement.setObject(1, data.getId());
				preparedStatement.setInt(2, data.getNumeroDocumento());
				preparedStatement.setInt(3, data.getTipoDocumento().getId());
				preparedStatement.setString(4, data.getNombre());
				preparedStatement.setString(5, data.getApellidos());
				preparedStatement.setInt(6, data.getTelefono());
				preparedStatement.setString(7, data.getCorreo());
				
				preparedStatement.executeUpdate();
				
				
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}
		
		@Override
		public ClienteEntity findByID(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<ClienteEntity> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<ClienteEntity> findByFilter(ClienteEntity filter) {
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
		public void update(final ClienteEntity data) {
			
			final StringBuilder statement = new StringBuilder();
			statement.append("UPDATE Cliente SET numerodocumento = ?, tipodocumento = ?, name = ?, apellidos = ?, telefono = ?, correo = ? WHERE id = ?");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				preparedStatement.setInt(1, data.getNumeroDocumento());
				preparedStatement.setInt(2, data.getTipoDocumento().getId());
				preparedStatement.setString(3, data.getNombre());
				preparedStatement.setString(4, data.getApellidos());
				preparedStatement.setInt(5, data.getTelefono());
				preparedStatement.setString(6, data.getCorreo());
				
				preparedStatement.executeUpdate();
				
				
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}

	}

