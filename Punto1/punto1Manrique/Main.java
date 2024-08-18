package Punto1.punto1Manrique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Inserte el número de threads");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		T.buscarMaximo(Integer.parseInt(reader.readLine()));
	}

}
