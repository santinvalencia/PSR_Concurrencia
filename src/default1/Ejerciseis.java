package default1;
import java.util.concurrent.*;
//Ejercicio 6: Usando Executors y Future

//Clase que calcula la suma de los números hasta el valor que le pasemos
class TareaSumadora implements Callable<Integer> {
 private int numero;

 public TareaSumadora(int numero) {
     this.numero = numero;
 }

 @Override
 public Integer call() throws Exception {
     int suma = 0;
     for (int i = 0; i <= numero; i++) {
         suma += i;
         Thread.sleep(10); // simula que tarda un poco
     }
     System.out.println("Suma de " + numero + " calculada.");
     return suma;
 }
}

//Clase principal (tiene que tener el mismo nombre que el archivo)
public class Ejerciseis {
 public static void main(String[] args) throws InterruptedException, ExecutionException {

     // Creamos un grupo (pool) de 3 hilos
     ExecutorService executor = Executors.newFixedThreadPool(3);

     // Enviamos 3 tareas al executor
     Future<Integer> futuro1 = executor.submit(new TareaSumadora(10));
     Future<Integer> futuro2 = executor.submit(new TareaSumadora(20));
     Future<Integer> futuro3 = executor.submit(new TareaSumadora(30));

     // Obtenemos los resultados (get espera hasta que termine la tarea)
     System.out.println("Resultado 1: " + futuro1.get());
     System.out.println("Resultado 2: " + futuro2.get());
     System.out.println("Resultado 3: " + futuro3.get());

     // Cerramos el executor
     executor.shutdown();
 }
}

/*
Pregunta para pensar:
¿Cuál es la ventaja de usar ExecutorService en vez de crear hilos con new Thread()?

→ Porque con ExecutorService se pueden manejar varios hilos de manera más simple,
reutilizarlos sin tener que crear nuevos todo el tiempo, y además obtener resultados
de cada tarea usando Future. Es más ordenado y eficiente.
*/
