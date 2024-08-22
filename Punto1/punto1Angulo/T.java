package Punto1.punto1Angulo; 

public class T extends Thread{

    private final int [] vector;
    private final int inicio;
    private final int fin;
    private final Max maxParcial;

    public T(int [] vector, int inicio, int fin, Max maxParcial){
        this.vector = vector;
        this.inicio = inicio;
        this.fin = fin;
        this.maxParcial = maxParcial;
    }

    @Override
    public void run(){
        int max = vector[inicio];
        for(int i = inicio; i < fin; i++){
            if(vector[i] > max){
                max = vector[i];
            }
        }
        maxParcial.actualizarMaximo(max);
        System.out.println("El máximo parcial es: " + max);
    }
    
}
