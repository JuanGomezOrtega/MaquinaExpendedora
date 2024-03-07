import java.util.ArrayList;

public class Monedas {
	private ArrayList<Moneda> listaMoneda;
	
	public Monedas() {
		this.listaMoneda = new ArrayList<>();
	}
	
	public ArrayList<Moneda> getListaMoneda() {
		return listaMoneda;
	}


	public String anadirMonedas(double valor, int cantidad) {
		for(Moneda m: listaMoneda) 
		{
			if(m.getValor() == valor) 
			{
				m.setCantidad(m.getCantidad()+cantidad);
				return "Cantidad actualizada correctamente";
			}
		}
		
		return "Moneda inexistente";
		
	}
	
	public void listadoMonedas() {
		for(Moneda m: listaMoneda)
		{
			System.out.println("Valor de la moneda: " + m.getValor() + " Cantidad: " +m.getCantidad());
		}
	}
	
	public void insercionMonedas(double valor, int cantidad){
		for(Moneda m: listaMoneda) 
		{
			if(m.getValor() == valor) 
			{
				m.setCantidad(m.getCantidad()+cantidad);
			}
		}
		
		this.listaMoneda.add(new Moneda(valor, cantidad));
		
	}
	
	public void devolucionMonedas() {
		for(Moneda m: this.listaMoneda)
		{
			if(m.getCantidad()>1)
				for(int i = 0; i<m.getCantidad();i++) 
				{
					System.out.println("Se ha devuelto la moneda: " + m.getValor());
				}			
			
		}
	}
}
