import html.Html;
import reserva.model.Bus;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Glenio on 11/10/2018.
 */


public class ThreadConexao implements Runnable {

    private final Socket socket;
    private boolean conectado;
    private String nomeUsuario;

    public ThreadConexao(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        conectado = true;
        while (conectado) {
            try {
                //cria uma requisicao a partir do InputStream do cliente
                RequisicaoHTTP requisicao = RequisicaoHTTP.lerRequisicao(socket.getInputStream());
                //se a conexao esta marcada para se mantar viva entao seta keepalive e o timeout
                if (requisicao.isManterViva()) {
                    socket.setKeepAlive(true);
                    socket.setSoTimeout(requisicao.getTempoLimite());
                } else {
                    //se nao seta um valor menor suficiente para uma requisicao
                    socket.setSoTimeout(300);
                }

                System.out.println(requisicao.getRecurso());

                RespostaHTTP resposta;
                //se o caminho foi igual a / entao deve pegar o index
                if (requisicao.getRecurso().equals("/")) {
                    //retorna a pagina com os banco do bus que podem ser reservados
                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 200, "OK");

                    resposta.setConteudoResposta(new Html().getHTML().getBytes("UTF-8"));
                } else if(requisicao.getRecurso().contains("/login")){

                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 200, "OK");
                } else if (requisicao.getRecurso().contains("/reservar")) {
                    String[] dadosForm = requisicao.getRecurso().split("[?,=,&]");//split que deixa apenas o nome do input e os valores dele
                    // recebe os dados (nome e o numero do banco) do usuario que vai reservar


                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 200, "OK");
                } else if (requisicao.getRecurso().contains("/acessar")) {
                    String[] dadosForm = requisicao.getRecurso().split("[?,=,&]");//split que deixa apenas o nome do input e os valores dele
                    // recebe os dados (nome e o numero do banco) do usuario que vai reservar


                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 200, "OK");
                }
                else if (requisicao.getRecurso().contains("/reservados")) {
                    // vai retornar os bancos do onibus

                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 200, "OK");
                }
                else {

                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 404, "Not Found");
                    //retornar a classe de erro
                }

                //converte o formato para o GMT espeficicado pelo protocolo HTTP
                String dataFormatada = Util.formatarDataGMT(new Date());

                //cabeçalho padrão da resposta HTTP/1.1
                resposta.setCabecalho("Location", "http://localhost:8000/");
                resposta.setCabecalho("Date", dataFormatada);
                resposta.setCabecalho("Server", "MeuServidor/1.0");
                resposta.setCabecalho("Content-Type", "text/html");
                resposta.setCabecalho("Content-Length", resposta.getTamanhoResposta());

                //cria o canal de resposta utilizando o outputStream
                resposta.setSaida(socket.getOutputStream());
                resposta.enviar();

            } catch (IOException ex) {
                //quando o tempo limite terminar encerra a thread
                if (ex instanceof SocketTimeoutException) {
                    try {
                        conectado = false;
                        socket.close();
                    } catch (IOException ex1) {
                        Logger.getLogger(ThreadConexao.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }

        }
    }


}
