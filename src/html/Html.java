package html;

import reserva.model.Assento;
import reserva.model.Bus;

/**
 * Created by Glenio on 11/10/2018.
 */
public class Html {

    public static final String CABECALHO ="<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n" +
            "<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n" +
            "<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
            "<style>\n" +
            "    .bloc_left_price {\n" +
            "    color: #c01508;\n" +
            "    text-align: center;\n" +
            "    font-weight: bold;\n" +
            "    font-size: 150%;\n" +
            "}\n" +
            ".category_block li:hover {\n" +
            "    background-color: #007bff;\n" +
            "}\n" +
            ".category_block li:hover a {\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".category_block li a {\n" +
            "    color: #343a40;\n" +
            "}\n" +
            ".add_to_cart_block .price {\n" +
            "    color: #c01508;\n" +
            "    text-align: center;\n" +
            "    font-weight: bold;\n" +
            "    font-size: 200%;\n" +
            "    margin-bottom: 0;\n" +
            "}\n" +
            ".add_to_cart_block .price_discounted {\n" +
            "    color: #343a40;\n" +
            "    text-align: center;\n" +
            "    text-decoration: line-through;\n" +
            "    font-size: 140%;\n" +
            "}\n" +
            ".product_rassurance {\n" +
            "    padding: 10px;\n" +
            "    margin-top: 15px;\n" +
            "    background: #ffffff;\n" +
            "    border: 1px solid #6c757d;\n" +
            "    color: #6c757d;\n" +
            "}\n" +
            ".product_rassurance .list-inline {\n" +
            "    margin-bottom: 0;\n" +
            "    text-transform: uppercase;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".product_rassurance .list-inline li:hover {\n" +
            "    color: #343a40;\n" +
            "}\n" +
            ".reviews_product .fa-star {\n" +
            "    color: gold;\n" +
            "}\n" +
            ".pagination {\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            "footer {\n" +
            "    background: #343a40;\n" +
            "    padding: 40px;\n" +
            "}\n" +
            "footer a {\n" +
            "    color: #f8f9fa!important\n" +
            "}\n" +
            "    \n" +
            "</style>\n" +
            "\n" +
            "<link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n" +
            "<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
            "    <div class=\"container\">\n" +
            "        <a class=\"navbar-brand\" href=\"index.html\">Reserva Bus.java</a>\n" +
            "    \n" +
            "    </div>\n" +
            "</nav>\n" +
            "<section class=\"jumbotron text-center\">\n" +
            "    <div class=\"container\">\n" +
            "        <h1 class=\"jumbotron-heading\">ESCOLHA SUA POLTRONA --- \"</h1>\n" +
            "     </div>\n" +
            "</section>";


    public static final String RODA_PE="<footer class=\"text-light\">\n" +
            "    <div class=\"container\">\n" +
            "        <div class=\"row\">\n" +
            "            <div class=\"col-md-3 col-lg-4 col-xl-3\">\n" +
            "                <h5>About</h5>\n" +
            "                <hr class=\"bg-white mb-2 mt-0 d-inline-block mx-auto w-25\">\n" +
            "                <p class=\"mb-0\">\n" +
            "                    Sistema/Servidor de reserva de poltronas de onibus desenvolvido em java (<i class=\"fa fa-heart\"></i>) \n" +
            "                </p>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"col-md-4 col-lg-3 col-xl-3\">\n" +
            "                <h5>Contact</h5>\n" +
            "                <hr class=\"bg-white mb-2 mt-0 d-inline-block mx-auto w-25\">\n" +
            "                <ul class=\"list-unstyled\">\n" +
            "                    <li><i class=\"fa fa-home mr-2\"></i><a href=\"https://www.facebook.com/rerumTI/\">Rerum Web</a></li>\n" +
            "                    <li><i class=\"fa fa-envelope mr-2\"> maicocamargo08@hotmail.com</i></li>\n" +
            "                    <li><i class=\"fa fa-envelope mr-2\"> -----</i></li>\n" +
            "                    <li><i class=\"fa fa-github mr-2\"></i><a href=\"https://github.com/MaicoCamargo\">Maico Camargo</a></li>\n" +
            "                    <li><i class=\"fa fa-github mr-2\"></i><a href=\"https://github.com/GlenioDescovi\">Glênio Descovi</a></li>\n" +
            "                    \n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 copyright mt-3\">\n" +
            "    \n" +
            "                <p class=\"text-right text-muted\">created by <a href=\"https://www.facebook.com/camargo.maico\"><strong>Maico Camargo</strong></a> | <a href=\"https://www.facebook.com/glenio.descovi\"><strong>Glênio Descovi</strong></a></p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</footer>";


    public String bancos="";
    public String lugaresReservar ="<div class=\"container mb-4\">\n" +
            "    <div class=\"row\">\n" +
            "        <div class=\"col-12\">\n" +
            "            <div class=\"table-responsive\">\n" +
            "                <table class=\"table table-striped\">\n" +
            "                    <thead>\n" +
            "                        <tr>\n" +
            "                            <th scope=\"col\"> </th>\n" +
            "                            <th scope=\"col\">Poltrona</th>\n" +
            "                            <th scope=\"col\">Reservado</th>\n" +
            "                            <th scope=\"col\" class=\"text-center\">Reservar para</th>\n" +
            "                            <th scope=\"col\" class=\"text-right\">Preço</th>\n" +
            "                            <th> </th>\n" +
            "                        </tr>\n" +
            "                    </thead>\n" +
            "                    <tbody>\n" +
            "                        <tr>\n" +
            "                            <td><img src=\"https://dummyimage.com/50x50/55595c/fff\" /> </td>\n" +
            "                            <td>Product Name Toto</td>\n" +
            "                            <td>In stock</td>\n" +
            "                            <td><input class=\"form-control\" type=\"text\" name=\"nome\" /></td>\n" +
            "                            <td class=\"text-right\">33,90 €</td>\n" +
            "                            <td class=\"text-right\"><button class=\"btn btn-sm btn-danger\"><i class=\"fa fa-times\"></i> </button> </td>\n" +
            "                        </tr>\n" +
            "                        <tr>\n" +
                                                printarOnibus(new Bus())+
            "                        </tr>\n" +
            "                        <tr>\n" +
            "                            <td></td>\n" +
            "                            <td></td>\n" +
            "                            <td></td>\n" +
            "                            <td></td>\n" +
            "                            <td><strong>Total</strong></td>\n" +
            "                            <td class=\"text-right\"><strong>346,90 €</strong></td>\n" +
            "                        </tr>\n" +
            "                    </tbody>\n" +
            "                </table>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col mb-2\">\n" +
            "            <div class=\"row\">\n" +
            "                <div class=\"col-sm-12  col-md-6\">\n" +
            "                    <button class=\"btn btn-block btn-light\">Cancelar</button>\n" +
            "                </div>\n" +
            "                <div class=\"col-sm-12 col-md-6 text-right\">\n" +
            "                    <button class=\"btn btn-lg btn-block btn-success text-uppercase\">Reservar</button>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>";


    public String getHTML(){
        return CABECALHO + lugaresReservar +RODA_PE;
    }

    public String printarOnibus(Bus bus){
        for (int i=0; i<bus.getAssentos().size(); i++){
            bancos = "<td>"+bus.getAssentos().get(i).isReserved()+"</td>\n";
        }
        return  bancos;
    }

    /*public String index(String nome){

        return "<!DOCTYPE html>" +
                "<html>" +
                    "<head>" +
                "    <meta charset=\"ISO-8859-1\">" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html;charset=ISO-8859-1\">" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>" +

                    "<title>| Home</title>" +
                    "</head>" +
                        "<body>" +
                            "<div class=\"container\">" +
                                "<div class=\"row\">" +
                                    "<div class=\"col-sm-6 col-md-4 col-md-offset-4\">" +
                                        "<h1 class=\"text-center login-title\">Sign in to continue to Trade</h1>" +
                                        "<div class=\"account-wall\">" +
                                            "<form action='/acessar' method='get' class=\"form-signin\">" +
                                                "<input type=\"text\" name=\"teste\" class=\"form-control\" placeholder=\"Email\" value=\"" + nome + "\" required autofocus>" +
                                                    "<br>" +
                                                "<input type=\"password\" class=\"form-control\" placeholder=\"Password\" required >" +
                                                    "<br>" +
                                                "<button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">" +
                                                "Sign in</button>" +
                                                "<label class=\"checkbox pull-left\">" +
                                                "<input type=\"checkbox\" value=\"remember-me\">" +
                                                "Remember me" +
                                                "</label>" +
                                                "<a href=\"#\" class=\"pull-right need-help\">Need help? </a><span class=\"clearfix\"></span>" +
                                            "</form>" +
                                        "</div>" +
                                        "<a href=\"#\" class=\"text-center new-account\">Create an account </a>" +
                                    "</div>" +
                                "</div>" +
                            "</div>" +
                            "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>" +
                        "</body>" +
                "</html>";
    }*/

}
