package reserva;

import reserva.model.Bus;
import reserva.model.Passageiro;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {

        System.out.println("onibus sendo criado...\n");
        Bus bus = new Bus();
        System.out.println(bus.getAssentos());
        System.out.println("assentos criados... \n");

        System.out.println("assentos do onibux");
        /*new Thread(new ReservaAssento(new Passageiro("Vitoria"), 1,bus)).start();
        new Thread(new ReservaAssento(new Passageiro("Lucas"), 1,bus)).start();*/
        /*new Thread(new ReservaAssento(new Passageiro("Laviny"), 3,bus)).start();
        new Thread(new ReservaAssento(new Passageiro("Alencar"), 2,bus)).start();*/
        new Thread(new AssentosReservados(bus)).start();

        ServerSocket ss = new ServerSocket(8080);
        String nome = "Tony Stark";
        while (true) {
            Socket s = ss.accept();
            byte[] buffer = new byte[1000];
            int nBytes = s.getInputStream().read(buffer);
            String requisicao = new String(buffer, 0, nBytes);
            System.out.println(requisicao);
            String[] linhas = requisicao.split("\n");
            String documento = linhas[0].split(" ")[1];
            System.out.println("REQUISICAO:"+documento);
            if (documento.equals("/")) {
                String resposta = "HTTP/1.1 200 OK\n"+
                        "Content-Type: text/html; charset=UTF-8\n\n"+
                        "<html>"+
                            "<head>" +
                                "<title>Olá</title>"+
                            "</head>"+
                            "<body>" +
                                "<h1>Olá " +nome+"!</h1>" +
                                "<form action='/reservar' method='get'>"+
                                    "<input type='text' name='nome'>"+
                                    "<input type='number' name='id'>"+
                                    "<button type='submit'>salvar</button>"+
                                "</form>"+
                            "</body>"+
                        "</html>";
                s.getOutputStream().write(resposta.getBytes("UTF-8"));
            }else if (documento.contains("/reservar")){
                String[] dadosForm = documento.split("[?,=,&]");//split que deixa apenas o nome do input e os valores dele
                for(String data: dadosForm){
                    System.out.println("->" +data);
                }
                Passageiro passageiro = new Passageiro(dadosForm[2]);
                new Thread(new ReservaAssento(passageiro, Integer.parseInt(dadosForm[4]),bus)).start();
            } else {
                String resposta = "HTTP/1.1 404 NOT FOUND\n"
                        + "Content-Type: text/html; charset=UTF-8\n\n"
                        + "<html><head><title>Erro</title></head>"
                        + "<body><h1>DOCUMENTO NÃO ENCONTRADO!!!</h1></body>"
                        + "</html>";
                //s.getOutputStream().write(resposta.getBytes("UTF-8"));
                s.getOutputStream().write(Integer.parseInt("Reservado"));
            }
            s.getOutputStream().write(bus.toString().getBytes("UTF-8"));

            s.close();
        }
    }
}
