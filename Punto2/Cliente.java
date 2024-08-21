package ejercicio2LabInfraComp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cliente extends Thread {

	private static Pastel pastel;

	public Cliente(Pastel pastel) {
		Cliente.pastel = pastel;
	}

	private void definirPastel() {
    	System.out.println("Definiendo pastel...");
    	int radio = Integer.parseInt(input("Ingrese el radio del pastel"));
    	int alto = Integer.parseInt(input("Ingrese el alto del pastel"));
    	String sabor = input("Ingrese el sabor del pastel");
    	String color = input("Ingrese el color del pastel");
    	
    	pastel.hacerPedido(alto, radio, sabor, color);
    	
    	synchronized (pastel) {
    		try {
				pastel.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	}
	
	public static String input(String mensaje) {
		try {
			System.out.println(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void run() {
		definirPastel();
	}
}
