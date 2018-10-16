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
            "                    <li><i class=\"fa fa-github mr-2\"></i><a href=\"https://github.com/GlenioDescovi\">Glenio Descovi</a></li>\n" +
            "                    \n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 copyright mt-3\">\n" +
            "    \n" +
            "                <p class=\"text-right text-muted\">created by <a href=\"https://www.facebook.com/camargo.maico\"><strong>Maico Camargo</strong></a> | <a href=\"https://www.facebook.com/glenio.descovi\"><strong>Glenio Descovi</strong></a></p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</footer>";

    public static final String LU="<div class=\"container mb-4\">\n" +
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
            "                            <th scope=\"col\" class=\"text-right\">Valor(moeda local)</th>\n" +
            "                            <th> </th>\n" +
            "                        </tr>\n" +
            "                    </thead>\n" +
            "                    <tbody>\n";

    public static final String RES="                        </tr>\n" +
            "                        </tr>\n" +
            "                        <tr>\n" +
            "                            <td></td>\n" +
            "                            <td></td>\n" +
            "                            <td></td>\n" +
            "                            <td></td>\n" +
            "                            <td><strong>Total</strong></td>\n" +
            "                            <td class=\"text-right\"><strong>346,90 pila</strong></td>\n" +
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

    /**
     * de acordo com o estado do assento o input muda na tela, caso reservado exibe o nome do usuario que reservou, caso
     * não reservado exibe o input que permite reservar o banco
      * @param assento obj usado para determinar qual input aparece na tela
     * @return input que deve aparecer na tela
     */
    public String inputStyle(Assento assento){
        if (assento.isReserved()){
            //return "<input class=\"form-control\" value='"+assento.getPassageiro().getNome()+"' type=\"hidden\" name=\"idAssento\" disabled />" ;
            //return "<input class=\"form-control text-danger\" value='maico' type=\"text\" name=\"nome\" />";
            //return assento.getPassageiro().getNome();
            return "<input class='form-control' value="+assento.getPassageiro().getNome()+" type='text' name='nome' disabled />";
        } else{
            return "<input class=\"form-control\" type=\"text\" name=\"nome\" />";
        }
    }

    /**
     * desabilita o botão caso o assento ja estiver reservado
     * @param assento
     * @return
     */
    public String buttonStyle(Assento assento){
        if (assento.isReserved()){
            return "<button type='submit' class='btn btn-sm btn-success' disabled ><i class='fa fa-check'></i></button>";
        }else{
            return "<button type='submit' class='btn btn-sm btn-primary'><i class='fa fa-plus'></i></button>";
        }
    }

    /**
     * cria o html com os dados atuais do onibus
     * @param bus
     * @return
     */
    public String printarOnibus(Bus bus){

        String ga="";

        for (int i=0; i<bus.getAssentos().size(); i++){
            ga +="<tr>" +
                    "<form action='/reservar'>"+
                        "<td><img src=\"https://dummyimage.com/50x50/55595c/fff\" /> </td> " +
                        "<td>" +bus.getAssentos().get(i).getIdAssento()+"</td> " +
                        "<td>"+bus.getAssentos().get(i).isReserved()+"</td> " +
                        "<td>" +
                            inputStyle(bus.getAssentos().get(i)) +
                            "<input class=\"form-control\" value="+bus.getAssentos().get(i).getIdAssento()+" type=\"hidden\" name=\"idAssento\" />" +
                        "</td> " +
                        "<td class=\"text-right\">500 pila </td> " +
                        "<td class=\"text-right \">"+
                                buttonStyle(bus.getAssentos().get(i)) +
                        "</td>" +
                    "</form>"+
                 "</tr>\n";
        }

        String lugares= LU+ga+RES;
        return  CABECALHO +lugares+ RODA_PE;
    }


}
