package co.edu.opticacordoba.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.opticacordoba.croscutting.exceptions.DataOpticaException;
import co.edu.opticacordoba.data.dao.ClienteDAO;
import co.edu.opticacordoba.data.dao.impl.sql.SqlDAO;
import co.edu.opticacordoba.entity.ClienteEntity;
import co.edu.opticacordoba.entity.TipoDocumentoEntity;
import co.edu.opticacrosscutting.helpers.TextHelper;

public final class ClientePostgreSQLDAO extends SqlDAO implements ClienteDAO {

		protected ClientePostgreSQLDAO(Connection connection) {
			super(connection);
		}

		@Override
		public void create(final ClienteEntity data) {
			final StringBuilder statement = new StringBuilder();
			
			statement.append("INSERT INTO cliente(numerodocumento, tipoDocumento, nombre, apellidos, telefono");
			if (!TextHelper.isEmptyApplyingTrim(data.getCorreo())) {
				statement.append(", correo) VALUES (?, ?, ?, ? , ?, ?)");
			} else {
				statement.append(") VALUES (?, ?, ?, ?, ?)");
			}
			try {Connection connection = getConnection(); 
		            var preparedStatement = connection.prepareStatement(statement.toString());
				preparedStatement.setString(1, data.getNumeroDocumento());
				preparedStatement.setInt(2, data.getTipoDocumento().getId());
				preparedStatement.setString(3, data.getNombre());
				preparedStatement.setString(4, data.getApellidos());
				preparedStatement.setString(5, data.getTelefono());
				if (!TextHelper.isEmptyApplyingTrim(data.getCorreo())) {
					preparedStatement.setString(6, data.getCorreo());
				}
				
				preparedStatement.executeUpdate();
				
				
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo cliente.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de registrar la información del nuevo cliente en la base de datos PostgreSQL. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}
		
		@Override
		public ClienteEntity findByID(Integer id) {
			final StringBuilder statement = new StringBuilder();
			   statement.append("SELECT * FROM cliente");
			    
			    if (id != null) {
			        statement.append(" WHERE id = ?");
			    }
			    
			    
			    Connection connection = getConnection();
			    try (var preparedStatement = connection.prepareStatement(statement.toString())) {
			       if (id != null) {
			            preparedStatement.setObject(1, id);
			        }
			        try (ResultSet resultSet = preparedStatement.executeQuery()) {
			            var cliente = new ClienteEntity();
			            var tipoDocumento = new TipoDocumentoEntity();
			            if (resultSet.next()) {
			            	tipoDocumento.setId(resultSet.getInt("tipodocumento"));
				            cliente.setId(resultSet.getInt("id"));
				            cliente.setNumeroDocumento(resultSet.getString("numerodocumento"));
				            cliente.setNombre(resultSet.getString("nombre"));
				            cliente.setApellidos(resultSet.getString("apellidos"));
				            cliente.setTelefono(resultSet.getString("telefono"));
				            cliente.setCorreo(resultSet.getString("correo"));
			            }
			            
			            cliente.setTipoDocumento(tipoDocumento);
			            return cliente;
			        }
			    } catch (final SQLException exception) {
			        var userMessage = "Se ha presentado un problema tratando de llevar a cabo la consulta del cliente. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			        var technicalMessage = "Se ha presentado un problema al tratar de obtener la información del cliente en la base de datos PostgreSQL. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			        throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			    }
		}

		@Override
		public List<ClienteEntity> findAll() {
			final StringBuilder statement = new StringBuilder();
			var clientes = new ArrayList<ClienteEntity>();
			statement.append("SELECT * FROM cliente");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while(resultSet.next()) {
						var cliente = new ClienteEntity();
						var tipoDocumento = new TipoDocumentoEntity();
						var clienteId = resultSet.getInt("id");
						var clienteNumeroDocumento = resultSet.getString("numerodocumento");
						var clienteNombre = resultSet.getString("nombre");
						var clienteApellidos = resultSet.getString("apellidos");
						var clienteTelefono = resultSet.getString("telefono");
						var clienteCorreo = resultSet.getString("correo");
						var tipoDocumentoId = resultSet.getInt("tipodocumento");
		                tipoDocumento.setId(tipoDocumentoId);
						cliente.setId(clienteId);
						cliente.setTipoDocumento(tipoDocumento);
						cliente.setNumeroDocumento(clienteNumeroDocumento);
						cliente.setNombre(clienteNombre);
						cliente.setApellidos(clienteApellidos);
						cliente.setTelefono(clienteTelefono);
						cliente.setCorreo(clienteCorreo);
						clientes.add(cliente);
					}
					return clientes;
				}
			} catch (final SQLException exception) {
				var userMessage = "Se ha presentado un problema tratando de llevar a cabo la consulta de los clientes.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage = "Se ha presentado un problema al tratar consultar la información de los clientes en la base de datos PosgrSQL. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}

		@Override
		public List<ClienteEntity> findByFilter(ClienteEntity filter) {
			final StringBuilder statement = new StringBuilder();
			   statement.append("SELECT * FROM cliente WHERE 1=1");
			   if (filter.getTipoDocumento().getId() != 0) {
			        statement.append(" AND tipodocumento = ?");
			    }
			   if(!TextHelper.isEmptyApplyingTrim(filter.getNumeroDocumento())) {
				   statement.append(" AND numerodocumento = ?");
			   }
			   if (!TextHelper.isEmptyApplyingTrim(filter.getNombre())) {
			        statement.append(" AND nombre = ?");
			    }
			   if (!TextHelper.isEmptyApplyingTrim(filter.getApellidos())) {
			        statement.append(" AND apellidos = ?");
			    } 
			   if (!TextHelper.isEmptyApplyingTrim(filter.getTelefono())) {
			        statement.append(" AND telefono = ?");
			    }
			   if (!TextHelper.isEmptyApplyingTrim(filter.getCorreo())) {
			        statement.append(" AND correo = ?");
			    }
			    try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {
			        int parameterIndex = 1;
			       if (filter.getTipoDocumento().getId() != 0) {
			        	preparedStatement.setInt(parameterIndex++, filter.getTipoDocumento().getId());
				    }
				   if(!TextHelper.isEmptyApplyingTrim(filter.getNumeroDocumento())) {
					   preparedStatement.setString(parameterIndex++, filter.getNumeroDocumento());;
				   }
				   if (!TextHelper.isEmptyApplyingTrim(filter.getNombre())) {
					   preparedStatement.setString(parameterIndex++, filter.getNombre());
				    }
				   if (!TextHelper.isEmptyApplyingTrim(filter.getApellidos())) {
					   preparedStatement.setString(parameterIndex++, filter.getApellidos());
				    } 
				   if (!TextHelper.isEmptyApplyingTrim(filter.getTelefono())) {
					   preparedStatement.setString(parameterIndex++, filter.getTelefono());
				    }
				   if (!TextHelper.isEmptyApplyingTrim(filter.getCorreo())) {
					   preparedStatement.setString(parameterIndex++, filter.getCorreo());
				    }
			        

			        try (ResultSet resultSet = preparedStatement.executeQuery()) {
			            List<ClienteEntity> clientes = new ArrayList<>();

			            while (resultSet.next()) {
			                int clienteId = resultSet.getInt("id");
			                int clienteTipoDocumento = resultSet.getInt("tipodocumento");
			                String clienteNumeroDocumento = resultSet.getString("numerodocumento"); 
			                String clienteNombre = resultSet.getString("nombre");
			                String clienteApellidos = resultSet.getString("apellidos");
			                String clienteTelefono = resultSet.getString("telefono");
			                String clienteCorreo = resultSet.getString("correo");
			                
			                var tipoDocumento = new TipoDocumentoEntity();
			                tipoDocumento.setId(clienteTipoDocumento);
			                ClienteEntity cliente = new ClienteEntity();
			                cliente.setId(clienteId);
			                cliente.setTipoDocumento(tipoDocumento);
			                cliente.setNumeroDocumento(clienteNumeroDocumento);
			                cliente.setNombre(clienteNombre);
			                cliente.setApellidos(clienteApellidos);
			                cliente.setTelefono(clienteTelefono);
			                cliente.setCorreo(clienteCorreo);
			                clientes.add(cliente);
			            }
			            return clientes;
			        }
			    } catch (final SQLException exception) {
			        var userMessage = "Se ha presentado un problema tratando de llevar a cabo la consulta de los clientes. Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
			        var technicalMessage = "Se ha presentado un problema al tratar de obtener la información de los clientes en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			        throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			    }
			    
		}

		@Override
		public void delete(Integer data) {
			
			final StringBuilder statement = new StringBuilder();
			statement.append("DELETE FROM Cliente WHERE id = ?");
			
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				
				preparedStatement.setObject(1, data);
				
				preparedStatement.executeUpdate();
				
				
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo la eliminación del cliente.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de eliminar el nuevo cliente en la base de datos PostgreSQL. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}

		@Override
		public void update(final ClienteEntity data) {
			
			final StringBuilder statement = new StringBuilder();
			statement.append("UPDATE Cliente SET");
			
			boolean firstField = true;

			if (data.getTipoDocumento() != null && data.getTipoDocumento().getId() != 0) {
			    statement.append(" tipodocumento = ?");
			    firstField = false;
			}
			if (!TextHelper.isEmptyApplyingTrim(data.getNombre())) {
			    if (!firstField) statement.append(", ");
			    statement.append(" nombre = ?");
			    firstField = false;
			}
			if (!TextHelper.isEmptyApplyingTrim(data.getApellidos())) {
			    if (!firstField) statement.append(", ");
			    statement.append(" apellidos = ?");
			    firstField = false;
			}
			if (!TextHelper.isEmptyApplyingTrim(data.getTelefono())) {
			    if (!firstField) statement.append(", ");
			    statement.append(" telefono = ?");
			    firstField = false;
			}
			if (!TextHelper.isEmptyApplyingTrim(data.getCorreo())) {
			    if (!firstField) statement.append(", ");
			    statement.append(" correo = ?");
			}
		   statement.append(" WHERE id = ?");
			try(final var preparedStatement = getConnection().prepareStatement(statement.toString()))  {
				int parameterIndex = 1;
		        
		       if (data.getTipoDocumento().getId() != 0) {
		        	preparedStatement.setInt(parameterIndex++, data.getTipoDocumento().getId());
			    }
		       if (!TextHelper.isEmptyApplyingTrim(data.getNombre())) {
				   preparedStatement.setString(parameterIndex++, data.getNombre());
			    }
			   if (!TextHelper.isEmptyApplyingTrim(data.getApellidos())) {
				   preparedStatement.setString(parameterIndex++, data.getApellidos());
			    } 
			   if (!TextHelper.isEmptyApplyingTrim(data.getTelefono())) {
				   preparedStatement.setString(parameterIndex++, data.getTelefono());
			    }
			   if (!TextHelper.isEmptyApplyingTrim(data.getCorreo())) {
				   preparedStatement.setString(parameterIndex++, data.getCorreo());
			   }
			   preparedStatement.setInt(parameterIndex, data.getId());
			   
			   preparedStatement.executeUpdate();
			} catch (final SQLException exception) {
				var userMessage ="Se ha presentado un problema tratando de llevar a cabo la actualización de la información del cliente.Por favor intente de nuevo, y si el problema persiste, reporte la novedad...";
				var technicalMessage="Se ha presentado un problema al tratar de actualizar la información del cliente en la base de datos PostgreSQL. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
				
				throw DataOpticaException.crear(userMessage, technicalMessage, exception);
			}
		}

	}

