import html.HomeReservas;
import html.Index;
import html.RespostaReserva;

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
    private String res="";
    private boolean achou=false;
    private String nomeUsuario;

    public ThreadConexao(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        conectado = true;

        //imprime na tela o IP do cliente
        System.out.println(socket.getInetAddress());
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

                //se o caminho foi igual a / entao deve pegar o index
                if (requisicao.getRecurso().equals("/")) {

                    //retorna a pagina com os banco do bus que podem ser reservados

                    achou=true;

                } else if(requisicao.getRecurso().contains("/login")){
                    //fazer classe
                    res= new Index().index("Glenio");
                    achou=true;

                } else if (requisicao.getRecurso().contains("/reservar")) {
                    String[] dadosForm = requisicao.getRecurso().split("[?,=,&]");//split que deixa apenas o nome do input e os valores dele
                    // recebe os dados (nome e o numero do banco) do usuario que vai reservar

                    res= new RespostaReserva().mensagem(nomeUsuario);
                    achou=true;
                } else if (requisicao.getRecurso().contains("/acessar")) {
                    String[] dadosForm = requisicao.getRecurso().split("[?,=,&]");//split que deixa apenas o nome do input e os valores dele
                    // recebe os dados (nome e o numero do banco) do usuario que vai reservar
                    nomeUsuario=dadosForm[2];
                    System.out.println("AQUIIIIIIIII");
                    System.out.println(dadosForm[2]);
                    res= new HomeReservas().homeReservas(dadosForm[2]);
                    achou=true;
                }
                else if (requisicao.getRecurso().contains("/reservados")) {
                    // vai retornar os bancos do onibus

                    achou=true;

                }
                //abre o arquivo pelo caminho
                //File arquivo = new File(requisicao.getRecurso().replaceFirst("/", ""));

                RespostaHTTP resposta;

                //se o arquivo existir então criamos a reposta de sucesso, com status 200
                if (achou) {
                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 200, "OK");
                } else {
                    //se o arquivo não existe então criamos a reposta de erro, com status 404
                    resposta = new RespostaHTTP(requisicao.getProtocolo(), 404, "Not Found");
                    //arquivo = new File("4 0 4.html");
                    //retornar a classe de erro
                    res="ERRO 404";
                }

                //lê todo o conteúdo do arquivo para bytes e gera o conteudo de resposta
                resposta.setConteudoResposta(res.getBytes());
                //resposta.setConteudoResposta(Files.readAllBytes(arquivo.toPath()));
                //converte o formato para o GMT espeficicado pelo protocolo HTTP
                String dataFormatada = Util.formatarDataGMT(new Date());
                //cabeçalho padrão da resposta HTTP/1.1
                resposta.setCabecalho("Location", "http://localhost:8000/");
                resposta.setCabecalho("Date", dataFormatada);
                resposta.setCabecalho("Server", "MeuServidor/1.0");
                resposta.setCabecalho("Content-Type", "text/html;charset=ISO-8859-1");
                resposta.setCabecalho("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
                resposta.setCabecalho("Content-Length", resposta.getTamanhoResposta());
                //cria o canal de resposta utilizando o outputStream
                resposta.setSaida(socket.getOutputStream());
                resposta.enviar();

            } catch (IOException ex) {
                //quando o tempo limite terminar encerra a thread
                if (ex instanceof SocketTimeoutException) {
                    try {
                        conectado = false;
                        achou=false;
                        socket.close();
                    } catch (IOException ex1) {
                        Logger.getLogger(ThreadConexao.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }

        }
    }


}
