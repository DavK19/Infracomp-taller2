public class Pasteleria {
    private Pastelero pastelero;
    private Cliente cliente;
    private static Pastel pastel = new Pastel();

    public void iniciar(){
        pastelero = new Pastelero(pastel);
        cliente = new Cliente(pastel);
        
        pastelero.start();
        cliente.start();
    }

    public static void main (String[] args) {
        Pasteleria pasteleria = new Pasteleria();
        pasteleria.iniciar();
    }
}
