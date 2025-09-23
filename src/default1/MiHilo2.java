package default1;

class MiTarea implements Runnable {
    @Override
    public void run() {
        System.out.println("¡Hola desde mi tarea con Runnable!");
    }//parte 1
    public static void main(String[] args) {
        MiTarea tarea = new MiTarea(); 
        Thread hilo = new Thread(tarea); 
        hilo.start(); //parte 2
    }
 
}
/*Usar Runnable me da mayor 
 * flexibilidad, ya que puedes implementar 
 * Runnable en cualquier clase y reutilizar 
 * la misma instancia en múltiples hilos, a 
 * diferencia de extender Thread.
 */