import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private Productos listaProductos;
	private Monedas listaMonedas;
	
	public Menu()
	{
		this.listaProductos = new Productos();
		this.listaMonedas = new Monedas();
	}
	
	public void inicioMenuAdmin() {
		int n = -1;
		Scanner sc = new Scanner (System.in);
		
		
		while (n != 0) {
			System.out.println("Bienvenido al intefez de administrador");
			System.out.println("Pulse 1 para Insertar Productos");
			System.out.println("Pulse 2 para Insertar Monedas");
			System.out.println("Pulse 3 para Ver el Listado de Productos");
			System.out.println("Pulse 4 para Ver el Listado de Monedas");
			System.out.println("Pulse 5 para Ver el Listado de Ganancias por Producto");
			System.out.println("Pulse 0 para Salir");
			
			n = sc.nextInt();
			sc.nextLine();
			
			switch (n) {
				case 1:
					System.out.println("Ingrese el nombre o la posición del producto que quiere modificar");
					String nombre = sc.nextLine();
					System.out.println("Ingrese la cantidad del producto que quiere añadir");
					int cantidad = sc.nextInt();
					listaProductos.anadirUnidades(nombre, cantidad);
					break;
				case 2:
					System.out.println("Ingrese el valor de la Moneda que quiere añadir");
					int valor = sc.nextInt();
					System.out.println("Ingrese la cantidad de la moneda que quiere añadir");
					int cantidadM = sc.nextInt();
					listaMonedas.anadirMonedas(valor, cantidadM);
					break;
				case 3:
					listaProductos.listadoProductos();
					break;
				case 4:
					listaMonedas.listadoMonedas();
					break;
				case 5:
					listaProductos.listadoGanancias();
					break;
				case 0: 
					System.out.println("Gracias por utilizar la aplicación");
					break;
				default: 
					System.out.println("Numero incorrecto");
				
			
			}
			
		}
	}
	
	public void inicioMenuUser() {
	
		int n = -1;
		Scanner sc = new Scanner (System.in);
		Producto auxProducto;
		Monedas auxMonedas = new Monedas();
		
		while (n != 0) {
			System.out.println("Bienvenido Usuario");
			System.out.println("Pulse 1 para Seleccionar Producto");
			System.out.println("Pulse 2 para Insertar Monedas");
			System.out.println("Pulse 3 para la devolución de su importe");
			System.out.println("Pulse 4 para ver el listado de productos");
			System.out.println("Pulse 0 para Salir");
			
			n = sc.nextInt();
			sc.nextLine();
			
			switch (n) {
				case 1:
					System.out.println("Ingrese el nombre o la posición del producto que desea");
					String s = sc.nextLine();
					auxProducto = listaProductos.seleccionProducto(s);
					
					
					if(auxProducto.getNombre().equals("")) 
					{
						System.out.println("El producto no existe");	
					}else 
					{	
						System.out.println("Ha selecionado el producto " + auxProducto + "De importe" + auxProducto.getPrecioVenta());
						cobrarProducto(auxProducto, auxMonedas, this.listaMonedas);
						auxMonedas.getListaMoneda().clear();
					}
					
					break;
				case 2:
					int i = -1;
					while(i != 0) {
						System.out.println("Ingrese el valor de la Moneda que quiere añadir");
						double valor = sc.nextDouble();
						
						System.out.println("Ingrese la cantidad de la moneda que quiere añadir");
						int cantidadM = sc.nextInt();
						
						auxMonedas.insercionMonedas(valor, cantidadM);
						
						System.out.println("Pulsa 1 para añadir otra moneda y 0 para finalizar");
						i = sc.nextInt();
						sc.nextLine();
						
					}
					break;
				case 3:
					auxMonedas.devolucionMonedas();
					auxMonedas.getListaMoneda().clear();
					break;
				case 4:
					this.listaProductos.listadoProductosUsuario();
					break;
				case 0: 
					System.out.println("Gracias por utilizar la aplicación");
					break;
				default: 
					System.out.println("Numero incorrecto");
				
			
			}
		}
	}
	
	public void cobrarProducto(Producto p, Monedas cliente, Monedas empresa) {
		double importeDevolucion;
		double importeCliente = 0;

		for(Moneda m: cliente.getListaMoneda())
		{
			importeCliente += m.getValor()*m.getCantidad(); 
		}
		
		if(importeCliente-p.getPrecioVenta() >=0) 
		{
			importeDevolucion =importeCliente-p.getPrecioVenta();
			System.out.print("Importe total de la devolución de : " + importeDevolucion);

			devolucionOptimo(importeDevolucion);
		}else
			System.out.println("Importe insuficiente");
	}
	
	public void devolucionOptimo(double importe) {
		System.out.println("Devolucion de :");
		 
	
		for(int i = 0; i< this.listaMonedas.getListaMoneda().size();) 
		{
			if(importe-this.listaMonedas.getListaMoneda().get(i).getValor()>=0 && this.listaMonedas.getListaMoneda().get(i).getCantidad()>0) 
			{
				importe -= this.listaMonedas.getListaMoneda().get(i).getValor();
				this.listaMonedas.getListaMoneda().get(i).setCantidad(this.listaMonedas.getListaMoneda().get(i).getCantidad()-1);
				System.out.println(this.listaMonedas.getListaMoneda().get(i).getValor());
			}else
				i++;
		}
		
		
	}
	
	public void rellenar() {
		this.listaMonedas.getListaMoneda().add(new Moneda (2));
		this.listaMonedas.getListaMoneda().add(new Moneda (1));
		this.listaMonedas.getListaMoneda().add(new Moneda (0.5));
		this.listaMonedas.getListaMoneda().add(new Moneda (0.2));
		this.listaMonedas.getListaMoneda().add(new Moneda (0.1));
		this.listaMonedas.getListaMoneda().add(new Moneda (0.05));
		this.listaMonedas.getListaMoneda().add(new Moneda (0.02));
		this.listaMonedas.getListaMoneda().add(new Moneda (0.01));
		
		this.listaProductos.getListaProducto().add(new Producto("Lays Punto de sal", 0.49,0.8 ,"A1",44 ));
		this.listaProductos.getListaProducto().add(new Producto("Lays Campesinas",0.49 ,0.8 ,"A2",44 ));
		this.listaProductos.getListaProducto().add(new Producto("Lays Mediterraneas",0.49 ,0.8 ,"A3",44 ));
		this.listaProductos.getListaProducto().add(new Producto("Lays gourmet",0.49 ,0.95 ,"A4",45 ));
		this.listaProductos.getListaProducto().add(new Producto("Ruffles Jamon",0.49 ,0.8 ,"A5",40 ));
		this.listaProductos.getListaProducto().add(new Producto("Pelotazos",0.49 ,0.8 ,"B1",40 ));
		this.listaProductos.getListaProducto().add(new Producto("Pandilla",0.49 ,0.8 ,"B2",36 ));
		this.listaProductos.getListaProducto().add(new Producto("Conos 3d",0.49 ,0.8 ,"B3",40 ));
		this.listaProductos.getListaProducto().add(new Producto("Doritos",0.49 ,0.9 ,"B4",40 ));
		this.listaProductos.getListaProducto().add(new Producto("Oregano",0.38 ,1.1 ,"B5",26 ));
		this.listaProductos.getListaProducto().add(new Producto("Choco Bom",0.59 ,1.5 ,"C1",100 ));
		this.listaProductos.getListaProducto().add(new Producto("Oreo",0.42 ,1.8 ,"C2",66 ));
		this.listaProductos.getListaProducto().add(new Producto("KitKat",0.39 ,1.2 ,"C3",41.5 ));
		this.listaProductos.getListaProducto().add(new Producto("Mikado",0.68 ,1.2 ,"C4",39 ));
		this.listaProductos.getListaProducto().add(new Producto("Gofre",0.62 , 1,"C5",140 ));
		this.listaProductos.getListaProducto().add(new Producto("Kinder Bueno", 0.59 , 2,"D1",39 ));
		this.listaProductos.getListaProducto().add(new Producto("Milka Lu",0.48 , 1.8,"D2",35 ));
		this.listaProductos.getListaProducto().add(new Producto("Conguitos",0.52 , 1.9,"D3",45 ));
		
	}	
}
	
