package co.edu.opticacordoba.data.dao;

import java.util.List;

import co.edu.opticacordoba.entity.ClienteEntity;

public interface ClienteDAO 
extends CreateDAO<ClienteEntity>, RetrieveDAO<ClienteEntity, Integer>, DeleteDAO<Integer>, UpdateDAO<ClienteEntity>{

	List<ClienteEntity> findAll();
}
