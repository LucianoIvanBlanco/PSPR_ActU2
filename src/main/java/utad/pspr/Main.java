package utad.pspr;

public class Main {

    public static void main(String[] args) {

        // Creamos las instancias
        Almacen miAlmacen = new Almacen(10);     // Inicializamos el almcacen con 10 plantas

        Productor productor1 = new Productor("productor1", 2, miAlmacen);
        Productor productor2 = new Productor("productor2", 4, miAlmacen);
        Productor productor3 = new Productor("productor3", 6, miAlmacen);

        Consumidor consumidor1 = new Consumidor("consumidor1", 6, miAlmacen);
        Consumidor consumidor2 = new Consumidor("consumidor2", 8, miAlmacen);
        Consumidor consumidor3 = new Consumidor("consumidor3", 5, miAlmacen);


        // Iniciaremos la ejecicion de todos los hilos

        productor1.start();
        productor2.start();
        productor3.start();

        consumidor1.start();
        consumidor2.start();
        consumidor3.start();

        System.out.println("Tenemos en stock " + miAlmacen.getTotalPlantas() + " plantas");

    }
}