import java.util.ArrayList;


public class Productos {
	private ArrayList<Producto> listaProducto;
	
	public Productos() {
		this.listaProducto = new ArrayList<>();
	}
	
	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}
	
	public String anadirUnidades(int id, int cantidad) {
		for(Producto p: listaProducto) 
		{
			if(p.getId() == id) 
			{
				p.setCantidad(p.getCantidad()+cantidad);
				return "Cantidad actualizada correctamente";
			}
		}
		
		return "Producto inexistente";
		
	}
	public String anadirUnidades(String s, int cantidad) {
		for(Producto p: listaProducto) 
		{
			if(p.getNombre().toUpperCase().equals(s.toUpperCase())||p.getPosicion().toUpperCase().equals(s.toUpperCase())) 
			{
				p.setCantidad(p.getCantidad()+cantidad);
				return "Cantidad actualizada correctamente";
			}
			
		}
		
		return "Producto inexistente";
		
	}
	
	public void listadoProductos() {
		for(Producto p : listaProducto)
		{
			System.out.println("Producto: " + p.getNombre() + " Cantidad: " +p.getCantidad());
		}
	}
	
	public void listadoProductosUsuario() {
		for(Producto p : listaProducto)
		{
			System.out.println("Producto: " + p.getNombre() + " Posicion: " + p.getPosicion());
		}
	}
	
	
	
	public void listadoGanancias() {
		
		double resultado; 
		for(Producto p : listaProducto)
		{
			resultado = p.getPrecioVenta()-p.getPrecioCompra();
			System.out.println("Producto: " + p.getNombre() + " Ganacia por producto: " + Math.round(resultado * 100.0) / 100.0);
		}
	}
	
	public Producto seleccionProducto(String opcion) {
		for(Producto p : listaProducto)
		{
			if(p.getNombre().toUpperCase().equals(opcion.toUpperCase())||p.getPosicion().toUpperCase().equals(opcion.toUpperCase())) 
			{
				return p;
			}
		}
		
		return new Producto();
	}
	
	
	
	
}
