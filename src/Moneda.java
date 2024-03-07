
public class Moneda {
	private double valor;
	private int cantidad;
	
	public Moneda(double valor, int cantidad) {
		this.valor = valor;
		this.cantidad = cantidad;
	}
	
	public Moneda(double valor) {
		this.valor = valor;
		this.cantidad = 20;
	}
	@Override
	public String toString() {
		return "Moneda [valor=" + valor + ", cantidad=" + cantidad + "]";
	}

	public Moneda() {
		this.valor = 0;
		this.cantidad = 0;
	}

	public double getValor() {
		return valor;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Moneda) 
		{
			if(((Moneda) o).getValor()==this.valor)
				return true;
		}
		return false;
	}
	
}
