package html;

/**
 * Created by Glenio on 11/10/2018.
 */
public class RespostaReserva {

    String html="";

    public String mensagem(String dadosForm){
        return "<!DOCTYPE html> " +
                    "<html lang=\"en\"> " +
                        "<head>" +
                            "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">" +
                            "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>" +
                            "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"+
                            "<meta charset=\"UTF-8\">" +
                                "<title>Title</title>" +
                        "</head>" +
                        "<body>" +
                            "<br><br><br><br>"+
                            "<div class=\"container\">\n" +
                                "<div class=\"row\">"+
                                    "<div class=\"alert alert-success\">" +
                                        "<strong>Sucesso!</strong> Reservado com sucesso. "+
                                    "</div>" +
                                "</div>"+
                            "</div>"+
                        "</body>" +
                    "</html>";

    }
}
