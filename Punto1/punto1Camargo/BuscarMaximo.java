package Punto1.punto1Camargo;

import java.util.Scanner;

public class BuscarMaximo {

    private int[] array;

    public static void main(String[] args) {

        // Recoger los datos para construir el array y la cantidad de threads
        System.out.println("Inserte los numeros a incluir en el array separados por comas");
        Scanner scanner = new Scanner(System.in);
        String[] numeros = scanner.nextLine().split(",");
        int[] array = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            array[i] = Integer.parseInt(numeros[i]);
        }

        System.out.println("Inserte el numero de threads");
        int numThreads = scanner.nextInt();

        scanner.close();

        int tamano = array.length / numThreads;

        T[] threads = new T[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int[] subArray;

            if (i == numThreads - 1) {
                subArray = new int[array.length - i * tamano];
                System.arraycopy(array, i * tamano, subArray, 0, array.length - i * tamano);
            } else{
                subArray = new int[tamano];
                System.arraycopy(array, i * tamano, subArray, 0, tamano);
            }
            
            threads[i] = new T(subArray);
            threads[i].start();
        }


        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El máximo es: " + Maximo.getInstance().getMaximoTotal());
    }
}
