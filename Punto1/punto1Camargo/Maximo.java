package Punto1.punto1Camargo;

public class Maximo {

    private int maximoTotal;

    private static Maximo instance;

    private Maximo() {
        maximoTotal = 0;
    }

    public static Maximo getInstance() {
        if (instance == null) {
            instance = new Maximo();
        }
        return instance;
    }

    public synchronized void actualizarMaximo(int maximoParcial) {
        if (maximoParcial > maximoTotal) {
            maximoTotal = maximoParcial;
        }
    }

    public synchronized int getMaximoTotal() {
        return maximoTotal;
    }
}
