
public class Producto {
	private int id;
	private static int cont = 0;
	private String nombre;
	private double precioCompra;
	private double precioVenta; 
	private String posicion;
	private double peso;
	private int cantidad;
	
	public Producto(String nombre, double precioCompra, double precioVenta, String posicion, double peso) {
		this.id = cont;
		cont++;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.posicion = posicion;
		this.peso = peso;
		this.cantidad = 10; 
	}
	



	public Producto() {
		
		this.nombre = "";
		this.precioCompra = 0;
		this.precioVenta = 0;
		this.posicion = "";
		this.peso = 0;
		this.cantidad = 0;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}


	public double getPrecioCompra() {
		return precioCompra;
	}


	public double getPrecioVenta() {
		return precioVenta;
	}
	
	public String getPosicion() {
		return posicion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta
				+ ", posicion=" + posicion + ", peso=" + peso + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(((Producto) o).getId()==this.id)
			return true;
		
		return false;
	}
	
	
	
	
	
	
}
