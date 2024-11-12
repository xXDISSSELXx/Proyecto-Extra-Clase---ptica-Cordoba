package co.edu.opticacordoba.businesslogic.usecase.cliente.impl;

import co.edu.opticacordoba.businesslogic.usecase.cliente.DeleteCliente;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacrosscutting.helpers.ObjectHelper;

public class DeleteClienteImpl implements DeleteCliente{
	
	private DAOFactory daoFactory;
	
	public DeleteClienteImpl(DAOFactory daoFactory) {
			
			setDaoFactory(daoFactory);
		}
	
	private void setDaoFactory(DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage= "Se ha presentado un problema inesperado tratando de llevar a cabo la eliminación del cliente. Por favor intente de nuevo y si el problema persiste, llame...";
			var technicalMessage = "El dao factory requerido para consultar la clase que elimina un cliente llegó nula...";
			
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}

			


	@Override
	public void execute(Integer id) {
		daoFactory.getClienteDAO().delete(id);
	}

}
