package Punto1.punto1Camargo;

public class T extends Thread {

    private int[] array;
    private int maximoParcial;

    public T(int[] array) {
        this.array = array;
        this.maximoParcial = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maximoParcial) {
                maximoParcial = array[i];
            }
        }
        Maximo.getInstance().actualizarMaximo(maximoParcial);
        System.out.println("El máximo parcial es: " + maximoParcial);
    }
}
