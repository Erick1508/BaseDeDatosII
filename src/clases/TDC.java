package clases;

public class TDC extends MetodoPago{

	private int nroTDC;
	private String banco;
	
	public TDC(int nroTDC, String banco) {
		super();
		this.nroTDC = nroTDC;
		this.banco = banco;
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
	
}
