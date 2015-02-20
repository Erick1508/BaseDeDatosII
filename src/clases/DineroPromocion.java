package clases;

public class DineroPromocion extends MetodoPago{

	private double dineroVirtual;
	
	//asociacion 1-1 con usuarios
	private Usuario usuario;

	public DineroPromocion(){}
	
	public DineroPromocion(double dineroVirtual) {
		super();
		this.dineroVirtual = dineroVirtual;
	}

	public double getDineroVirtual() {
		return dineroVirtual;
	}

	public void setDineroVirtual(double dineroVirtual) {
		this.dineroVirtual = dineroVirtual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
