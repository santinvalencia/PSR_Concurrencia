package default1;

class Contador {
 private int valor = 0;

 public synchronized void incrementar() {
     valor++;
 }

 public int getValor() {
     return valor;
 }
}

//Clase Incrementador que extiende de Thread
class Incrementador extends Thread {
 private Contador contador;

 public Incrementador(Contador contador) {
     this.contador = contador;
 }

 @Override
 public void run() {
     for (int i = 0; i < 1000; i++) {
         contador.incrementar();
     }
 }


public static void main(String[] args) throws InterruptedException {
     
     Contador contador = new Contador();

     int numHilos = 5;
     Incrementador[] hilos = new Incrementador[numHilos];
     for (int i = 0; i < numHilos; i++) {
         hilos[i] = new Incrementador(contador);
         hilos[i].start();
     }

     for (Incrementador hilo : hilos) {
         hilo.join();
     }

     System.out.println("Valor final del contador: " + contador.getValor());

}

/* Synchronized resuelve el problema de concurrencia al bloquear 
 * el acceso a un recurso compartido. Bloquea el objeto que está 
 * siendo utilizado, impidiendo que otros hilos accedan a 
 * métodos o bloques de código sincronizados en ese objeto 
 * hasta que el hilo actual termine su ejecución. Esto evita 
 * condiciones de carrera y asegura la integridad de los datos.
 */
}
