package default1;
class MiHiloTarea extends Thread {
 private String nombre;

 public MiHiloTarea(String nombre) {
     this.nombre = nombre;
 }

 @Override
 public void run() {
     for (int i = 0; i < 5; i++) {
         System.out.println(nombre + " - Iteración " + (i + 1));
         try {
             Thread.sleep(100); // Pausa por 100 milisegundos
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt(); // Manejo básico de la interrupción
         }
     }
 }
 public static void main(String[] args) {
     // Crear varios hilos
     MiHiloTarea hilo1 = new MiHiloTarea("Hilo 1");
     MiHiloTarea hilo2 = new MiHiloTarea("Hilo 2");
     MiHiloTarea hilo3 = new MiHiloTarea("Hilo 3");

     // Iniciar los hilos
     hilo1.start();
     hilo2.start();
     hilo3.start();

}}
 /* El orden de las salidas no es el mismo por la naturaleza 
  * concurrente de la ejecución de hilos en Java. La 
  * planificación de los hilos es realizada por el Scheduler 
  * del JVM (Java Virtual Machine), que decide qué hilo ejecutar 
  * a continuación. Este proceso puede variar dependiendo de 
  * factores como la carga del sistema, el número de CPUs 
  * disponibles, y la prioridad de los hilos.
  * 
  */



