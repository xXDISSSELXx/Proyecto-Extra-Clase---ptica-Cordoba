package co.edu.opticacordoba.businesslogic.usecase.cliente.impl;

import java.util.List;

import co.edu.opticacordoba.businesslogic.usecase.cliente.FindCliente;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.domain.ClienteDomain;

public class FindClienteImpl implements FindCliente{

	public FindClienteImpl(DAOFactory factory) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ClienteDomain> execute(ClienteDomain data) {
		
		return null;
	}

}
