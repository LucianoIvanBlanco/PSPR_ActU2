package utad.pspr;

public class Almacen {

    private final int MAX = 50;    // Maximo de plantas que se pueden almacenar

    private int totalPlantas = 0;     // Total de plantas en el almacen

    public Almacen(int totalPlantas) {
        this.totalPlantas = totalPlantas;
    }

    public int getTotalPlantas() {
        return totalPlantas;
    }

    // PARTE CRITICA
    public synchronized void venderPlantas(int cantidad, String nombreConsumidor) {

        try {
            while (cantidad >  totalPlantas) {
                System.out.println("Error: " + nombreConsumidor + ". Estamos preparando su pedido, por favor aguarde un momento.");

                wait();  // Ponemos en espera al consumidor ya que no tenemos plantas disponibles

            }
            System.out.println(nombreConsumidor + " su pedido de " + cantidad + " plantas se ha generado con exito. Muchas gracias!");
            totalPlantas = totalPlantas - cantidad;
            System.out.println("Nos quedan a disposicon un  total de " + totalPlantas + " plantas.");

            notifyAll(); // Notificamos a los productores que ya tenemos sitio en el almacen

        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    public synchronized void almacenarPlantas(int cantidad, String nombreProductor) {

        try {
            if (totalPlantas >= MAX) {
                System.out.println("Error: " + nombreProductor + ". En estos momentos tenemos el almacen completo, aguarde unos instantes mientras hacemos lugar. Gracias!");

                wait(); // Ponemos en espera a los productores ya que no tenemos mas sitio en el almacen

            } else {
                System.out.println("El " + nombreProductor + " almacenó con exito " + cantidad + " plantas.");
                totalPlantas = totalPlantas + cantidad;
                System.out.println("Tenemos en stock " + totalPlantas + " plantas");

                notifyAll();    // Notificamos a los consumidores que ya tenemos plantas disponibles
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

}
