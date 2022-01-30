package main.banco;

public class Cuenta {
	
	
	private String nss;
	private double saldo;
	private int numIngresos=0;
	private int numReintegros=0;
	
	// Contructor
	public Cuenta(String nss)
	{
		this.nss = nss;
		this.saldo= 0;
		
	
		
	}

	public Cuenta(String nss, double saldo) {
		super();
		this.nss = nss;
		this.saldo = saldo;
		this.numIngresos=1;
	}

	public String getNss() {
		return nss;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getNumIngresos() {
		return numIngresos;
	}

	public int getNumReintegros() {
		return numReintegros;
	}

	@Override
	public String toString() {
		return "Cuenta [nss=" + nss + ", saldo=" + saldo + ", numIngresos=" + numIngresos + ", numReintegros="
				+ numReintegros + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nss == null) ? 0 : nss.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (nss == null) {
			if (other.nss != null)
				return false;
		} else if (!nss.equals(other.nss))
			return false;
		return true;
	}
	
	public void ingresar(double cantidad) {
		this.saldo = this.saldo+cantidad;
	}
	
	public void reintegrar(double cantidad) {
		this.saldo = this.saldo-cantidad;
	}
	
	
	
}
