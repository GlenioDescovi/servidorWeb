package reserva.html;

import reserva.model.Assento;
import java.util.ArrayList;


/**
 * Created by Glenio on 11/10/2018.
 */
public class RespostaReserva {

    String mensagem="";//mensagem de erro ou de sucesso no reservar poltrona

    public String mensagem(ArrayList<Assento> assentos , int idBanco, String nomeUsuario){

        if (assentos.get(idBanco).getPassageiro().getNome().equals(nomeUsuario)){

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
