package reserva.teste;

import java.util.HashSet;
import java.util.Set;

public class testeAlgumaCoisa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new testeAlgumaCoisa().executa();
    }

    private int i = 0;

    private Set<Integer> numeros = new HashSet<>();
    private Object monitor = new Object();

    public void executa() {
        new Thread(new HelloRunnable("Thread 1")).start();
        new Thread(new HelloRunnable("Thread 2")).start();
    }

    class HelloRunnable implements Runnable {

        private String nome;

        public HelloRunnable(String nome) {
            this.nome = nome;
        }

        @Override
        public void run() {
            while(true) {
                synchronized(numeros) {
                    int meuI = i++;
                    //System.out.println("[" + nome + "]: i = " + i);
                    if (!numeros.add(meuI)) {
                        System.out.println("[" + nome + "]: Problema. i = " + i);
                    }

                }

                //try { Thread.sleep(100l); } catch (Exception e) { }
            }
        }

    }

}
