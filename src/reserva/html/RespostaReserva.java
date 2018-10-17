package reserva.html;

import reserva.log.Log;
import reserva.model.Assento;
import java.util.ArrayList;


/**
 * Created by Glenio on 11/10/2018.
 */
public class RespostaReserva {

    String mensagem="";

    public String mensagem(ArrayList<Assento> assentos , int idBanco, String nomeUsuario){
        String log="";

        if (assentos.get(idBanco).getPassageiro().getNome().equals(nomeUsuario)){

            log= "NOME: " + assentos.get(idBanco).getPassageiro().getNome()+ "\n"
                    + "IP: " + assentos.get(idBanco).getPassageiro().getIpRequisicao() +
                        "\n" + "STATUS: CONSEGUIU RESERVAR";
            Log.addLog(log);

            mensagem="<div class=\"container\">\n" +
                        "<div class=\"row\">"+
                            "<div class=\"col-md-12\">"+
                                "<div class=\"alert alert-success text-center\">" +
                                    "<strong>Reservado com sucesso.</strong> "+
                                    "<h4>Reservado para: <b class='text-info'>"+assentos.get(idBanco).getPassageiro().getNome()+"</b></h4>"+
                                    "<h4>Ip: <b class='text-info'>"+assentos.get(idBanco).getPassageiro().getIpRequisicao()+"</b></h4> "+
                                    "<h4>Hora/data Reserva: <b class='text-info'>"+assentos.get(idBanco).getPassageiro().getDataAtual()+"</b></h4>"+

                                    "<form action='/poltronas'>"+
                                        "<button class='alert alert-outline-success' type='submit'>voltar para home</button>"
                                    +"</form>"+
                            "</div>"+
                        "</div>"+
                    "</div>";

        }else{

            log= "NOME: " + assentos.get(idBanco).getPassageiro().getNome()+ "\n"
                    + "IP: " + assentos.get(idBanco).getPassageiro().getIpRequisicao() +
                    "\n" + "STATUS: NÃO CONSEGUIU RESERVAR";
            Log.addLog(log);

            mensagem="<div class=\"container\">\n" +
                        "<div class=\"row\">"+
                            "<div class=\"col-md-12\">"+
                                "<div class=\"alert alert-warning text-center\">" +
                                    "<strong>Esta poltrona ja esta reservada, tente outra poltrona.</strong> "+

                                    "<form action='/poltronas'>"+
                                        "<button class='alert alert-warning' type='submit'>voltar para home</button>"
                                    +"</form>"+
                            "</div>"+
                        "</div>"+
                    "</div>";
        }

        return Html.CABECALHO + mensagem + Html.RODA_PE;
    }
}
