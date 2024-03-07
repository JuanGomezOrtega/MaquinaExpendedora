import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Menu m = new Menu();
		m.rellenar();
		
		String pass = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Si eres administrador pulsa 1, en caso contrario pulsa 0");
		int n = sc.nextInt();
		sc.nextLine();
		
		if(n == 0) {
			m.inicioMenuUser();
		}else if(n == 1) {
			System.out.print("Ingrese la contraseña");
			pass = sc.nextLine();
			
			if(pass.equals("D2315A"))
				m.inicioMenuAdmin();
		}else
			System.out.print("Código incorrecto");
			
		
		/*
		Moneda m = new Moneda(1);
		Monedas m1= new Monedas();
		
		m1.getListaMoneda().add(m);
		
		System.out.println(m1.getListaMoneda());
		
		m1.getListaMoneda().remove(m);
		
		System.out.println(m1.getListaMoneda());
		*/
	}

}
