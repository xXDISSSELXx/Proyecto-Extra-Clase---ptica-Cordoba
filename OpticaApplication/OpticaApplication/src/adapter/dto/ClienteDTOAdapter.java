package co.edu.opticacordoba.businesslogic.adapter.dto;

import co.edu.opticacordoba.businesslogic.adapter.Adapter;
import co.edu.opticacordoba.domain.ClienteDomain;
import co.edu.opticacordoba.domain.TipoDocumentoDomain;
import co.edu.opticacordoba.dto.ClienteDTO;
import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.NumericHelper;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteDTOAdapter implements Adapter<ClienteDomain, ClienteDTO>{

private static final Adapter<ClienteDomain, ClienteDTO> instance = new ClienteDTOAdapter();
	
	private ClienteDTOAdapter() {
		
	}
	
	public static Adapter<ClienteDomain, ClienteDTO>  getCountryDTOAdapter() {
		return instance;
	}
	@Override
	public ClienteDomain adaptSource(ClienteDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, ClienteDTO.create());
		return ClienteDomain.create(IdHelper.convertToNumber(dtoToAdapt.getId()),dtoToAdapt.getNumeroDocumento(), TipoDocumentoDTOAdapter.getTipoDocumentoDTOAdapter().adaptSource(dtoToAdapt.getTipoDocumento()), dtoToAdapt.getNombre(), dtoToAdapt.getApellidos(), dtoToAdapt.getTelefono(), dtoToAdapt.getCorreo());
	}

	@Override
	public ClienteDTO adaptTarget(ClienteDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, ClienteDomain.create(IdHelper.getDefault(), NumericHelper.ZERO, TipoDocumentoDomain.create(IdHelper.getDefault(), TextHelper.EMPTY), TextHelper.EMPTY, TextHelper.EMPTY, NumericHelper.ZERO, TextHelper.EMPTY));
		return ClienteDTO.create().setId("").setNumeroDocumento(domainToAdapt.getNumeroDocumento()).setTipoDocumento(TipoDocumentoDTOAdapter.getTipoDocumentoDTOAdapter().adaptTarget(domainToAdapt.getTipoDocumento())).setNombre(domainToAdapt.getNombre()).setApellidos(domainToAdapt.getApellidos()).setTelefono(domainToAdapt.getTelefono()).setCorreo(domainToAdapt.getCorreo());
	}

}
