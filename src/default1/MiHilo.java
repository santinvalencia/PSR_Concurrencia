package default1;

class MiHilo extends Thread {
    @Override
    public void run() {
        System.out.println("¡Hola desde mi hilo!");
    }// pimera parte

    public static void main(String[] args) {
        MiHilo hilo = new MiHilo(); 
        hilo.start(); // parte 2
    }
}


/*Si llamo a hilo.run(), 
 * el código dentro del método run() se ejecutará 
 * en el hilo actual (el hilo principal), 
 * no en un nuevo hilo. Esto significa que no se 
 * aprovechará la capacidad de ejecución concurrente 
 * que proporciona la clase Thread. En cambio, 
 * al llamar a hilo.start(), se crea un nuevo hilo 
 * y se ejecuta el método run() en ese nuevo hilo, 
 * permitiendo que el hilo principal y el nuevo hilo 
 * se ejecuten simultáneamente.*/
 