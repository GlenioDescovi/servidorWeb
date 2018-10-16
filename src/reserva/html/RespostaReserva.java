package reserva.html;

import reserva.model.Assento;
import java.util.ArrayList;

/**
 * Created by Glenio on 11/10/2018.
 */
public class RespostaReserva {

    String mensagem="";

    public String mensagem(ArrayList<Assento> assentos , int idBanco){

        mensagem="<div class=\"container\">\n" +
                    "<div class=\"row\">"+
                        "<div class=\"alert alert-success\">" +
                            "<strong>Sucesso!</strong> Reservado com sucesso. "+ assentos.get(idBanco) +
                        "</div>" +
                    "</div>"+
                 "</div>";

        return Html.CABECALHO + mensagem + Html.RODA_PE;
    }
}
