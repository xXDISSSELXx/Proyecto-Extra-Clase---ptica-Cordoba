package co.edu.opticacordoba.domain;

import co.edu.opticacrosscutting.helpers.TextHelper;
public class ClienteDomain extends Domain{
	
	private int numeroDocumento;
	private TipoDocumento tipoDocumento;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String correo;

	protected ClienteDomain(final int id, final int numeroDocumento, final TipoDocumento tipoDocumento, final String nombre, 
			final String apellidos, final int telefono, final String correo) {
		super(id);
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setNombre(nombre);
		setApellidos(apellidos);
		setTelefono(telefono);
		setCorreo(correo);
	}
	
	public static final ClienteDomain create(final int id, final int numeroDocumento, final TipoDocumento tipoDocumento,
											final String nombre, final String apellidos, final int telefono, final String correo) {
		return new ClienteDomain(id, numeroDocumento, tipoDocumento, nombre, apellidos, telefono, correo);
	}
	
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	
	private void setNumeroDocumento(final int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	
	private void setTipoDocumento(final TipoDocumento tipoDocuemto) {
		this.tipoDocumento = tipoDocuemto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(final String name) {
		this.nombre = TextHelper.applyTrim(name);
	}

	public String getApellidos() {
		return apellidos;
	}
	
	private void setApellidos(final String apellidos) {
		this.apellidos = TextHelper.applyTrim(apellidos);
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	private void setTelefono(final int telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	private void setCorreo(final String correo) {
		this.correo = TextHelper.applyTrim(correo);
	}
}
