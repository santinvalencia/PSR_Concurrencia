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
     // Crear un Contador
     Contador contador = new Contador();

     // Crear varios Incrementador
     int numHilos = 5;
     Incrementador[] hilos = new Incrementador[numHilos];
     for (int i = 0; i < numHilos; i++) {
         hilos[i] = new Incrementador(contador);
         hilos[i].start();
     }

     // Esperar a que todos los hilos terminen
     for (Incrementador hilo : hilos) {
         hilo.join();
     }

     // Imprimir el valor final del contador
     System.out.println("Valor final del contador: " + contador.getValor());

}
}
