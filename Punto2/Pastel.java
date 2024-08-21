package ejercicio2LabInfraComp;

public class Pastel {

    private int alto = 0;
    private int radio = 0;
    private String sabor = "";
    private String color = "";

    public synchronized void hacerPedido(int alto, int radio, String sabor, String color){
        this.alto = alto;
        this.radio = radio;
        this.sabor = sabor;
        this.color = color;
        System.out.println("Pastel pedido: " + alto + " " + radio + " " + sabor + " " + color);
    }

    public synchronized String consultarDetallesPedido(){
        return "Alto: " + alto + " Radio: " + radio + " Sabor: " + sabor + " Color: " + color;
    }

    public synchronized boolean consultarEstadoPedido(){
        if(alto == 0 && radio == 0 && sabor.equals("") && color.equals("")){
            return false;
        }
        return true;
    }

}
