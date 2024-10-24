package co.edu.opticacordoba.data.dao;

import java.util.List;
import co.edu.opticacordoba.entity.TipoDocumentoEntity;

public interface TipoDocumentoDAO
extends CreateDAO<TipoDocumentoEntity>, RetrieveDAO<TipoDocumentoEntity, Integer>, DeleteDAO<Integer>, UpdateDAO<TipoDocumentoEntity>{

	List<TipoDocumentoEntity> findAll();
}
