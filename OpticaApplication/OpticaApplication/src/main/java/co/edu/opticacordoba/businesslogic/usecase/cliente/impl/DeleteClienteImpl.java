package co.edu.opticacordoba.businesslogic.usecase.cliente.impl;

import co.edu.opticacordoba.businesslogic.usecase.cliente.DeleteCliente;
import co.edu.opticacordoba.data.dao.DAOFactory;

public class DeleteClienteImpl implements DeleteCliente{
	
	private DAOFactory daoFactory;
	
	public DeleteClienteImpl(DAOFactory daoFactory) {
			
			setDaoFactory(daoFactory);
		}
	
	private void setDaoFactory(DAOFactory daoFactory2) {
			
			
		}

	@Override
	public void execute(Integer data) {
		// TODO Auto-generated method stub
		
	}

}
