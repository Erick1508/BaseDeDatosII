package clases;

public class Telefono {

	private int codigoPais;
	private int codigoArea;
	private int numeroTlf;
	
	public Telefono(){}
	
	public Telefono(int codigoPais, int codigoArea, int numeroTlf) {
		this.codigoPais = codigoPais;
		this.codigoArea = codigoArea;
		this.numeroTlf = numeroTlf;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}
	
	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public int getNumeroTlf() {
		return numeroTlf;
	}

	public void setNumeroTlf(int numeroTlf) {
		this.numeroTlf = numeroTlf;
	}
	
	
}
