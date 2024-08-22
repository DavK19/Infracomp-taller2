///Grupo 5 
/// Maria Alejandra Angulo Mejia - 202121458
/// Juan Miguel Manrique Cruz - 202021447
/// Juan David Camargo Parra - 202220493
package Punto1.punto1Angulo; 
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserte el numero de threads. Debe ser menor al tamaño del vector");
        int numThreads = scanner.nextInt();

        System.out.println("Inserte el tamaño del vector");
        int vectorSize = scanner.nextInt();

        if (numThreads > vectorSize) {
            System.out.println("El número de threads debe ser menor al tamaño del vector");
            System.exit(1);
        }

        System.out.println("Inserte el valor máximo del vector");
        int maxValue = scanner.nextInt();

        scanner.close();

        int[] vector = new int[vectorSize];
        
        Random rand = new Random();
        for (int i = 0; i < vectorSize; i++) {
            vector[i] = rand.nextInt(maxValue);
            System.out.print(vector[i] + " "); 
        }
        System.out.println();

        Max max = new Max(Integer.MIN_VALUE);
        T[] threads = new T[numThreads];
        int revisionSize = vectorSize/numThreads;

        for (int i = 0; i < numThreads; i++) {
            int inicio = i * revisionSize;
            int fin;
            if (i == numThreads - 1) {
                fin = vectorSize - 1;
            } else {
                fin = inicio + revisionSize - 1;
            }

            threads[i] = new T(vector, inicio, fin, max);
            threads[i].start();
        }

        for (T thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        System.out.println("El máximo es: " + max.getMax());

    }
}
