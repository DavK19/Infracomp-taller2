package Punto3;

public class Id {

    private int currentId = 0;

    public synchronized int getId() {
        return currentId++;
    }
    
}
