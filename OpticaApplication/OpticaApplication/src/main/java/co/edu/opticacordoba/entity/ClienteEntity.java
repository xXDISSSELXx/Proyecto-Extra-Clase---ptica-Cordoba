package co.edu.opticacordoba.entity;

import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteEntity extends DomainEntity {
	
	private String numeroDocumento;
	private TipoDocumentoEntity tipoDocumento;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String correo;

	public ClienteEntity() {
		super(IdHelper.getDefault());
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setNombre(TextHelper.EMPTY);
		setApellidos(apellidos);
		setTelefono(telefono);
		setCorreo(correo);
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(final TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(final String apellidos) {
		this.apellidos = TextHelper.applyTrim(apellidos);
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(final String correo) {
		this.correo = TextHelper.applyTrim(correo);
	}
	
	@Override
	public void setId(final int id) {
		super.setId(id);
	}
	
	@Override
	public int getId() {
		return super.getId();
	}
}
