package co.edu.opticacordoba.domain;


import co.edu.opticacrosscutting.helpers.TextHelper;
public class ClienteDomain extends Domain{
	
	private String numeroDocumento;
	private TipoDocumentoDomain tipoDocumento;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String correo;

	protected ClienteDomain(final int id, final String numeroDocumento, final TipoDocumentoDomain tipoDocumento, final String nombre, 
			final String apellidos, final String telefono, final String correo) {
		super(id);
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setNombre(nombre);
		setApellidos(apellidos);
		setTelefono(telefono);
		setCorreo(correo);
	}
	
	public static final ClienteDomain create(final int id, final String numeroDocumento, final TipoDocumentoDomain tipoDocumento,
											final String nombre, final String apellidos, final String telefono, final String correo) {
		return new ClienteDomain(id, numeroDocumento, tipoDocumento, nombre, apellidos, telefono, correo);
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	private void setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public TipoDocumentoDomain getTipoDocumento() {
		return tipoDocumento;
	}
	
	private void setTipoDocumento(final TipoDocumentoDomain tipoDocuemto) {
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
	
	public String getTelefono() {
		return telefono;
	}
	
	private void setTelefono(final String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	private void setCorreo(final String correo) {
		this.correo = TextHelper.applyTrim(correo);
	}
	
	@Override
	public int getId() {
		return super.getId();
	}
}
