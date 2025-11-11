package default1;
//Ejercicio 7: CountDownLatch para Sincronización
import java.util.concurrent.CountDownLatch;

//Clase que representa una tarea que se ejecuta en un hilo
class TareaInicial extends Thread {
 private CountDownLatch latch;
 private String nombre;

 public TareaInicial(CountDownLatch latch, String nombre) {
     this.latch = latch;
     this.nombre = nombre;
 }

 @Override
 public void run() {
     try {
         System.out.println("Tarea " + nombre + " iniciando su trabajo...");
         Thread.sleep((long) (Math.random() * 2000)); // simula que tarda un poco
         System.out.println("Tarea " + nombre + " ha terminado.");
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
     } finally {
         latch.countDown(); // resta 1 al contador del latch
     }
 }
}

//Clase principal (debe tener el mismo nombre que el archivo)
public class Ejercisiete {
 public static void main(String[] args) throws InterruptedException {

     int numeroDeTareas = 3; // cantidad de tareas a ejecutar
     CountDownLatch latch = new CountDownLatch(numeroDeTareas);

     // Creamos y arrancamos las tareas
     for (int i = 1; i <= numeroDeTareas; i++) {
         new TareaInicial(latch, "Tarea-" + i).start();
     }

     System.out.println("Hilo principal esperando a que las tareas terminen...");
     latch.await(); // el hilo principal se queda esperando hasta que todas terminen

     System.out.println("Todas las tareas han terminado. Hilo principal continuando.");
 }
}

/*
Pregunta para pensar:
¿En qué casos CountDownLatch es más útil que Thread.join()?

→ CountDownLatch sirve cuando queremos esperar que varias tareas terminen al mismo tiempo,
sin tener que hacer join() una por una. Es muy útil cuando hay muchas tareas paralelas
y necesitamos que todas finalicen antes de continuar.
*/
