package Punto3;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserte el número de filas: ");
        int numRows = scanner.nextInt();
        System.out.println("Inserte el número de columnas: ");
        int numCols = scanner.nextInt();

        int [][] matrix = new int[numRows][numCols];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        Id id = new Id();

        buscarMax[] threads = new buscarMax[numRows];
        for (int i = 0; i < numRows; i++) {
            threads[i] = new buscarMax(matrix, id);
            threads[i].start();
        }

        // Esperar a que todos los threads terminen
        for (int i = 0; i < numRows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Obtener y mostrar el máximo global
        System.out.println("El valor máximo en la matriz es: " + buscarMax.getGlobalMax());

    }

        

}
    

