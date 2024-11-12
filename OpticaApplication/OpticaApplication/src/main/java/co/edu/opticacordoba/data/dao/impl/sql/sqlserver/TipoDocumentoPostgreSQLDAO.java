package co.edu.opticacordoba.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.opticacordoba.croscutting.exceptions.DataOpticaException;
import co.edu.opticacordoba.data.dao.TipoDocumentoDAO;
import co.edu.opticacordoba.data.dao.impl.sql.SqlDAO;
import co.edu.opticacordoba.entity.ClienteEntity;
import co.edu.opticacordoba.entity.TipoDocumentoEntity;

public final class TipoDocumentoPostgreSQLDAO extends SqlDAO implements TipoDocumentoDAO {

		protected TipoDocumentoPostgreSQLDAO(Connection connection) {
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
			final StringBuilder statement = new StringBuilder();
			   statement.append("SELECT * FROM tipodocumento");
			    
			    if (id != null) {
			        statement.append(" WHERE id = ?");
			    }
			    
			    try {Connection connection = getConnection(); 
			            var preparedStatement = connection.prepareStatement(statement.toString());
			       if (id != null) {
			            preparedStatement.setObject(1, id);
			        }
			        try (ResultSet resultSet = preparedStatement.executeQuery()) {
			            var tipoDocumento = new TipoDocumentoEntity();
			            if (resultSet.next()) {
			            	tipoDocumento.setId(resultSet.getInt("id"));
			            	tipoDocumento.setTipoDocumento(resultSet.getString("tipodocumento"));
			            }
			            return tipoDocumento;
			        }
			    } catch (final SQLException exception) {
			        var userMessage = "Se ha presentado un problema tratando de llevar a cabo la consulta del tipo de documento. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			        var technicalMessage = "Se ha presentado un problema al tratar de obtener la información del tipo de documento en la base de datos PostgreSQL. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			        throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			    }
		}

		@Override
		public List<TipoDocumentoEntity> findAll() {
			final StringBuilder statement = new StringBuilder();
			var tiposDocumento = new ArrayList<TipoDocumentoEntity>();
			statement.append("SELECT * FROM tipodocumento");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					
					while(resultSet.next()) {
						var tipoDocumento = new TipoDocumentoEntity();
						var tipoDocumentoId = resultSet.getInt("id");
						var tipoDocumentoName = resultSet.getString("tipodocumento");
		                tipoDocumento.setId(tipoDocumentoId);
		                tipoDocumento.setTipoDocumento(tipoDocumentoName);
						tiposDocumento.add(tipoDocumento);
					}
					return tiposDocumento;
				}
			} catch (final SQLException exception) {
				var userMessage = "Se ha presentado un problema tratando de llevar a cabo la consulta de los clientes.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage = "Se ha presentado un problema al tratar consultar la información de los clientes en la base de datos PosgrSQL. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
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

