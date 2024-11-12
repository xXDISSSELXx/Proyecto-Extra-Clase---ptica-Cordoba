package co.edu.opticacordoba.businesslogic.usecase.tipodocumento.impl;

import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.DeleteTipoDocumento;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacrosscutting.helpers.ObjectHelper;

public class DeleteTipoDocumentoImpl implements DeleteTipoDocumento{

	private DAOFactory daoFactory;
	
	public DeleteTipoDocumentoImpl(DAOFactory daoFactory) {
		
		setDaoFactory(daoFactory);
	}

	private void setDaoFactory(DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage= "Se ha presentado un problema inesperado tratando de llevar a cabo la eliminación del tipo de documento. Por favor intente de nuevo y si el problema persiste, llame...";
			var technicalMessage = "El dao factory requerido para consultar la clase que elimina un tipo de documento llegó nula...";
			
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
		
	}
	@Override
	public void execute(Integer id) {
		daoFactory.getTipoDocumentoDAO().delete(id);
		
	}

}
