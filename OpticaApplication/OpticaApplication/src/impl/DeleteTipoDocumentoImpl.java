package co.edu.opticacordoba.businesslogic.usecase.tipodocumento.impl;

import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.DeleteTipoDocumento;
import co.edu.opticacordoba.data.dao.DAOFactory;

public class DeleteTipoDocumentoImpl implements DeleteTipoDocumento{

	private DAOFactory daoFactory;
	
	public DeleteTipoDocumentoImpl(DAOFactory daoFactory) {
		
		setDaoFactory(daoFactory);
	}

	private void setDaoFactory(DAOFactory daoFactory2) {
		
		
	}
	@Override
	public void execute(Integer data) {
		// TODO Auto-generated method stub
		
	}

}
