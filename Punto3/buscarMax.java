package Punto3;

public class buscarMax extends Thread {

    private int[][] matrix;
    private int rowId;
    private static int globalMax = 0;
    private Id idRef;

    public buscarMax(int[][] matrix, Id idRef) {
        this.matrix = matrix;
        this.idRef = idRef;
        this.rowId = idRef.getId();
    }

    @Override

    public void run(){
        int localMax = 0;
        for (int i=0 ; i <matrix[rowId].length; i++){
            if (matrix[rowId][i] > localMax){
                localMax = matrix[rowId][i];
            }
        }

        updateGlobalMax(localMax);
    }

    private synchronized void updateGlobalMax(int localMax){
        if (localMax > globalMax){
            globalMax = localMax;
        }
    }

    public static int getGlobalMax(){
        return globalMax;
    }
    
}
