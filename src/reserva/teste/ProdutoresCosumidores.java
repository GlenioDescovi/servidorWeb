package reserva.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ProdutoresCosumidores {

    private List<Integer> buffer = new ArrayList<>();
    public static final int MAX_BUFFER = 10;


    public static void main(String[] args) {
        new ProdutoresCosumidores().inicia();
    }

    private void inicia() {
        new Thread(new ConsumidorRunnable()).start();
        new Thread(new ConsumidorRunnable()).start();
        new Thread(new ProdutorRunnable()).start();
        new Thread(new ProdutorRunnable()).start();
    }

    private class ProdutorRunnable implements Runnable {

        private int numProdutor = numeroProd++;
        private Random rnd = new SecureRandom();

        @Override
        public void run() {
            while(true) {
                int dado = produzDado();
                synchronized(buffer) {
                    if (buffer.size() == MAX_BUFFER) {
                        try {
                            System.out.println("[PROD" + numProdutor + "] Buffer cheio. Dormindo...");
                            buffer.wait();
                            System.out.println("[PROD" + numProdutor + "] Acordando.");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProdutoresCosumidores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("[PROD" + numProdutor + "] Colocou " + dado + " no buffer.");
                    buffer.add(dado);
                    if (buffer.size() == 1) {
                        buffer.notify();
                    }
                }
            }
        }

        private int produzDado() {
            return rnd.nextInt();
        }

    }

    private static int numeroCons = 1;
    private static int numeroProd = 1;

    private class ConsumidorRunnable implements Runnable {

        private int numConsumidor = numeroCons++;

        @Override
        public void run() {
            while(true) {
                synchronized(buffer) {
                    if (buffer.size() == 0) {
                        try {
                            System.out.println("[CONS" + numConsumidor + "] Buffer vazio. Dormindo...");
                            buffer.wait();
                            System.out.println("[CONS" + numConsumidor + "] Acordou.");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProdutoresCosumidores.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //if (buffer.size() > 0) {
                    int dado = buffer.remove(0);
                    consomeDado(dado);
                    //}
                    if (buffer.size() == MAX_BUFFER - 1) {
                        buffer.notify();
                    }
                }
            }
        }

        private void consomeDado(int dado) {
            System.out.println("[CONS" + numConsumidor + "] Consumiu dado " + dado + ".");
        }

    }

}