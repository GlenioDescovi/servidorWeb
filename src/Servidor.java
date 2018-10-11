import java.io.IOException;
import java.net.ServerSocket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    public static void main(String[] args) throws IOException {
        /* cria um socket "servidor" associado a porta 8000
         já aguardando conexões
         */
            ServerSocket servidor = new ServerSocket(8000);
            ExecutorService pool = Executors.newFixedThreadPool(20);

            while (true) {
                //cria uma nova thread para cada nova solicitacao de conexao
                pool.execute(new ThreadConexao(servidor.accept()));
            }
        }
}
