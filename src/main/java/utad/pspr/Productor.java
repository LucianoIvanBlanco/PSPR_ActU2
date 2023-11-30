package utad.pspr;

public class Productor extends Thread {

    private String nombre;
    private int cantidadPlantas;

    private Almacen miAlmacen;

    public Productor(String nombre, int cantidadPlantas, Almacen miAlmacen) {
        this.nombre = nombre;
        this.cantidadPlantas = cantidadPlantas;
        this.miAlmacen = miAlmacen;
    }

    public void run() {
        while (true) {
            try {
                int intervalo = (int) ((Math.random() * 2 + 4) * 1000);
                Thread.sleep(intervalo);
                miAlmacen.almacenarPlantas(cantidadPlantas, nombre);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

}
