package default1;
//Ejercicio 5: Productor - Consumidor Simple (wait() y notify())

//Clase principal (debe llamarse igual que el archivo)
public class Buffer {
public static void main(String[] args) {
   Recurso b = new Recurso();
   Productor p = new Productor(b);
   Consumidor c = new Consumidor(b);

   p.start();
   c.start();
}
}


class Recurso {
 private int dato;
 private boolean disponible = false; // true si hay algo para consumir

 // Método para poner un dato
 public synchronized void put(int valor) {
     while (disponible) { // si ya hay un dato, el productor espera
         try {
             wait();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
     dato = valor;
     disponible = true;
     System.out.println("Productor puso: " + dato);
     notifyAll(); // avisa a los consumidores que hay dato
 }

 // Método para obtener un dato
 public synchronized int get() {
     while (!disponible) { // si no hay dato, el consumidor espera
         try {
             wait();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
     disponible = false;
     System.out.println("Consumidor obtuvo: " + dato);
     notifyAll(); // avisa a los productores que el buffer está vacío
     return dato;
 }
}

//Clase Productor
class Productor extends Thread {
 private Recurso buffer;

 public Productor(Recurso b) {
     this.buffer = b;
 }

 public void run() {
     for (int i = 1; i <= 5; i++) {
         buffer.put(i);
         try {
             sleep(500); // para que se vea más claro en la consola
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

//Clase Consumidor
class Consumidor extends Thread {
 private Recurso buffer;

 public Consumidor(Recurso b) {
     this.buffer = b;
 }

 public void run() {
     for (int i = 1; i <= 5; i++) {
         buffer.get();
         try {
             sleep(700); // para que no vaya tan rápido
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}



/*
Pregunta para pensar:
¿Por qué usamos while en lugar de if?
Porque si un hilo se despierta antes de que realmente cambie la condición,
el while vuelve a comprobarla. Con if podría seguir ejecutándose aunque
todavía no sea su turno.
*/
