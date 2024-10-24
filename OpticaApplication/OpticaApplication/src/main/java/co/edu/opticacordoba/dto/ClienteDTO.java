package co.edu.opticacordoba.dto;

import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteDTO extends DomainDTO{

	private int numeroDocumento;
	private TipoDocumentoDTO tipoDocumento;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String correo;
	
	public ClienteDTO() {
		super(IdHelper.getDefaultAsString());
		
		// TODO Auto-generated constructor stub
	}

	public static final ClienteDTO create() {
		return new ClienteDTO();
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public ClienteDTO setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
		return this;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public ClienteDTO setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = ObjectHelper.getDefault(tipoDocumento, TipoDocumentoDTO.create());
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public ClienteDTO setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public String getApellidos() {
		return apellidos;
	}

	public ClienteDTO setApellidos(String apellidos) {
		this.apellidos = TextHelper.applyTrim(apellidos);
		return this;
	}

	public int getTelefono() {
		return telefono;
	}

	public ClienteDTO setTelefono(int telefono) {
		this.telefono = telefono;
		return this;
	}

	public String getCorreo() {
		return correo;
	}

	public ClienteDTO setCorreo(String correo) {
		this.correo = TextHelper.applyTrim(correo);
		return this;
	}

	@Override
	public String getId() {
		return super.getId();
	}
	
	public ClienteDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
}