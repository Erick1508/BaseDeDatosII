package clases;

public class TDC extends MetodoPago{

	private int nroTDC;
	private String banco;
	private int codigoSeguridad;
	private String tipo;
	
	//asociacion 1-* con usuario
	private Usuario usuario;
	
	public TDC(int nroTDC, String banco, int codigoSeguridad, String tipo) {
		super();
		this.nroTDC = nroTDC;
		this.banco = banco;
		this.codigoSeguridad = codigoSeguridad;
		this.tipo = tipo;
	}

	public int getNroTDC() {
		return nroTDC;
	}

	public void setNroTDC(int nroTDC) {
		this.nroTDC = nroTDC;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
