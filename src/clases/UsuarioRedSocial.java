package clases;

public class UsuarioRedSocial {
	
	private int urs_id;
	private String nombreUsuario;

	// asociacion con Usuario
	private Usuario usuario;
	
	public UsuarioRedSocial() {	}
	
	public UsuarioRedSocial(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getUrs_id() {
		return urs_id;
	}
	public void setUrs_id(int urs_id) {
		this.urs_id = urs_id;
	}
}
