package Punto1.punto1Angulo; 

public class Max {

    private int max;

    public Max(int initialMax) {
        this.max = initialMax;
    }

    public synchronized void actualizarMaximo(int maxParcial) {
        if (maxParcial > max) {
            max = maxParcial;
        }
    }

    public synchronized int getMax() {
        return max;
    }
    
}
