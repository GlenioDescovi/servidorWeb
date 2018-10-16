package reserva.html;

/**
 * Created by Glenio on 11/10/2018.
 */
public class HomeReservas {

    public String homeReservas(String nome){

        return "<!DOCTYPE reserva.html> " +
                "<reserva.html lang=\"en\"> " +
                    "<head>" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">" +
                        "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"+
                        "<meta charset=\"UTF-8\">" +
                        "<title>Home Reservas</title>" +
                    "</head>" +
                    "<body>" +
                        "<br><br><br><br>"+
                        "<div class=\"container\">\n" +
                            "<div class=\"row\">"+
                                "<div class=\"alert alert-success\">" +
                                    "<strong>Seja bem!</strong> " + nome.toUpperCase() +
                                "</div>" +
                                "<table class=\"table table-hover\">"+
                                    "<tr>"+
                                        "<th>"+
                                            "Poltrona"+
                                        "</th>"+
                                        "<th>"+
                                        "Reservado? "+
                                        "</th>"+
                                    "</tr>"+
                                    "<tr>"+
                                        "<th>"+ nome.toUpperCase() +
                                        "</th>"+
                                        "<th>"+ nome.toUpperCase() +
                                        "</th>"+
                                    "</tr>"+
                                "</table>"+
                            "</div>"+
                        "</div>"+
                    "</body>" +
                "</reserva.html>";
    }
}