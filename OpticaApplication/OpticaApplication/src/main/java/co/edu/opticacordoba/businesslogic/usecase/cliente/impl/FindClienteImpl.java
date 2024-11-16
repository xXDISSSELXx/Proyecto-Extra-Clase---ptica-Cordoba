package co.edu.opticacordoba.businesslogic.usecase.cliente.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.opticacordoba.businesslogic.adapter.entity.ClienteEntityAdapter;
import co.edu.opticacordoba.businesslogic.usecase.cliente.FindCliente;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteExists;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteExistsImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.domain.ClienteDomain;
import co.edu.opticacordoba.entity.ClienteEntity;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
public class FindClienteImpl implements FindCliente{

	private DAOFactory factory;
	ClienteExists clienteExists = new ClienteExistsImpl();
	
	public FindClienteImpl(DAOFactory factory) {
		setDaoFactory(factory);
	}

	@Override
	public ClienteDomain execute(Integer data) {
		clienteExists.execute(data, factory);
		var clienteEntity = factory.getClienteDAO().findByID(data);
		
		return  ClienteEntityAdapter.getClienteEntityAdapter().adaptSource(clienteEntity);
	}
	
	private void setDaoFactory(final DAOFactory factory) {
		if (ObjectHelper.isNull(factory)) {
			var userMessage= "Se ha presentado un problema inesperado tratando de llevar a cabo la consulta de la información de los clientes deseada. Por favor intente de nuevo y si el problema persiste, llame...";
			var technicalMessage = "El dao factory requerido para consultar la clase que consulta los clientes llegó nula...";
			
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage);
		}
		this.factory = factory;
	}
}
