package reserva.html;

import reserva.model.Bus;

/**
 * Created by Glenio on 11/10/2018.
 */
public class RespostaReserva {

    String mensagem="";

    public String mensagem(Bus bus,int idBanco){

        mensagem="<div class=\"container\">\n" +
                    "<div class=\"row\">"+
                        "<div class=\"alert alert-success\">" +
                            "<strong>Sucesso!</strong> Reservado com sucesso. "+ bus.getAssentos().get(idBanco).getPassageiro().getNome() +
                        "</div>" +
                    "</div>"+
                 "</div>";

        return Html.CABECALHO + mensagem + Html.RODA_PE;
    }
}
