package co.edu.opticacordoba.businesslogic.usecase.cliente;

import java.util.List;

import co.edu.opticacordoba.businesslogic.usecase.UseWithReturn;
import co.edu.opticacordoba.domain.TipoDocumentoDomain;

public interface FindCliente extends UseWithReturn<TipoDocumentoDomain, List<TipoDocumentoDomain>>{

}
