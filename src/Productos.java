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
	
	public void listadoProductos() {
		for(Producto p : listaProducto)
		{
			System.out.println("Producto: " + p.getNombre() + " Cantidad: " +p.getCantidad());
		}
	}
	
	
	
	public void listadoGanancias() {
		for(Producto p : listaProducto)
		{
			System.out.println("Producto: " + p.getNombre() + " Ganacia por producto: " + (p.getPrecioVenta()-p.getPrecioCompra()));
		}
	}
	
	public Producto seleccionProducto(String opcion) {
		for(Producto p : listaProducto)
		{
			if(p.getNombre().equals(opcion)||p.getPosicion().equals(opcion)) 
			{
				return p;
			}
		}
		
		return new Producto();
	}
	
	
	
	
}
