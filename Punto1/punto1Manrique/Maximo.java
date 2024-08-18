package Punto1.punto1Manrique;

public class Maximo {
	
	private int maximo = 0;
	
	public synchronized void anotar(int n) {
		if (n > maximo)
			maximo = n;
	}
	
	public synchronized int darMaximo() {
		return maximo;
	}

}
