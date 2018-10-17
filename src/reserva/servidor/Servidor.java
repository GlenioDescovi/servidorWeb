package reserva.servidor;

import reserva.AssentosReservados;
import reserva.log.Log;
import reserva.model.Bus;

import java.io.IOException;
import java.net.ServerSocket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    public static void main(String[] args) throws IOException {
        /* cria um socket "servidor" associado a porta 8000
         já aguardando conexões
         */
        ServerSocket servidor = new ServerSocket(8080);
        ExecutorService pool = Executors.newFixedThreadPool(40);
        Bus bus = new Bus();

        //nova thread para o consumidor ficar observando o produtor
        //poll de thread fundiona do mesmo jeito que o pull de conexoes, inserido no java 5
        pool.execute(new Log.Escreve());

        while (true) {
            //cria uma nova thread para cada nova solicitacao de conexao
            pool.execute(new ThreadConexao(servidor.accept(), bus));
        }
    }
}
