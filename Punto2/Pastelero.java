public class Pastelero extends Thread {

    private Pastel pastel;
    
    
    public Pastelero(Pastel pastel){
        this.pastel = pastel;
    }

    private void prepararPastel(){
        System.out.println("Preparando pastel");
        try {
            int randomNumber = 5 + (int) (Math.random() * (15 - 5 + 1));
            Thread.sleep(1000*randomNumber);
            System.out.println("Pastel listo con las caracteristicas:\n" + pastel.consultarDetallesPedido());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        System.out.println("Pastelero a la espera de pedidos");

        while (!pastel.consultarEstadoPedido()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        prepararPastel();
    }
}
