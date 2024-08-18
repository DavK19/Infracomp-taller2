package Punto1.punto1Manrique;

public class T extends Thread{

	private static Maximo oMax = new Maximo ();
	private int[] v;
	private int inicio, fnl;
	private static int hilosTer = 0;
	private static int totalH;
	
	public T(int[] v, int inicio, int fnl) {
		this.v = v;
		this.inicio = inicio;
		this.fnl = fnl;
	}
	
	@Override
	public void run() {
		for (int i = this.inicio; i < this.fnl; i++) {
			oMax.anotar(v[i]);
		}
		hiloTerminado();
	}
	
	private static synchronized void hiloTerminado() {
		hilosTer++;
		if (hilosTer == totalH) {
			System.out.println("El máximo es: " + oMax.darMaximo());
		}
	}
	
	public static void buscarMaximo(int nThreads) {
		int[] vector = {1, 2, 3, 4, 6, 0, 122, 43};
		int distribucion = vector.length / nThreads;
		
		totalH = nThreads;
		T[] threads = new T[nThreads];
		
		for (int i = 0; i < nThreads; i++) {
			int init = i * distribucion;
			int fnl = (i == nThreads - 1) ? vector.length : init + distribucion;
			threads[i] = new T(vector, init, fnl);
			threads[i].start();
		}
	}

}
