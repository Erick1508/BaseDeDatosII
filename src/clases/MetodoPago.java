package clases;

public class MetodoPago {
	private int methodId;
	
	// dineroViertual
	private double dineroVirtual;
	
	//tdc
	private int nroTDC;
	private String banco;
	private int codigoSeguridad;
	private String tipo;
	
	private String metodo;
	
	//asociacion 1-* con usuario
	private Usuario usuarioTDC;
	
	//asociacion 1-1 con usuarios
	private Usuario usuarioDP;
	
	//asociacion 1-1 con Compra
	private Compra compra;
	
	public MetodoPago() {
	}
	
	/*constructor tdc*/
	public MetodoPago(int nroTDC, String banco, int codigoSeguridad, String tipo){
		this.methodId = 0;
		this.nroTDC = nroTDC;
		this.banco = banco;
		this.codigoSeguridad = codigoSeguridad;
		this.tipo = tipo;
		this.metodo = "TDC";
	}
	
	/*constructor DP*/
	public MetodoPago(double dineroVirtual){
		this.dineroVirtual = dineroVirtual;
		this.metodo = "DP";
	}

	public int getMethodId() {
		return methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	public double getDineroVirtual() {
		return dineroVirtual;
	}

	public void setDineroVirtual(double dineroVirtual) {
		this.dineroVirtual = dineroVirtual;
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

	public Usuario getUsuarioTDC() {
		return usuarioTDC;
	}

	public void setUsuarioTDC(Usuario usuarioTDC) {
		this.usuarioTDC = usuarioTDC;
	}

	public Usuario getUsuarioDP() {
		return usuarioDP;
	}

	public void setUsuarioDP(Usuario usuarioDP) {
		this.usuarioDP = usuarioDP;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	
	
	
}
