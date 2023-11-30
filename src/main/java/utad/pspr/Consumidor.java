package utad.pspr;

public class Consumidor extends Thread {

    private String nombreConsumidor;
    private int cantidadPlantas;

    private Almacen miAlmacen;


    public Consumidor(String nombreConsumidor, int cantidadPlantas, Almacen miAlmacen) {
        this.nombreConsumidor = nombreConsumidor;
        this.cantidadPlantas = cantidadPlantas;
        this.miAlmacen = miAlmacen;
    }


    public void run() {
        while (true) {
            try {
                int intervalo = (int) ((Math.random() * 3 + 5) * 1000);
                Thread.sleep(intervalo);
                miAlmacen.venderPlantas(cantidadPlantas, nombreConsumidor);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
