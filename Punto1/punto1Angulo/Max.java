package Punto1.punto1Angulo; 

public class Max {

    private int maxValor;

    public Max(int maxValor) {
        this.maxValor = maxValor;
    }

    public synchronized void actualizarMaximo(int maxParcial) {
        if (maxParcial > maxValor) {
            maxValor = maxParcial;
        }
    }

    public synchronized int getMax() {
        return maxValor;
    }

}
