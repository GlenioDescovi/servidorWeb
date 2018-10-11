package html;

/**
 * Created by Glenio on 11/10/2018.
 */
public class Index {

    public String index(String nome){

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
                                                "<input type=\"password\" class=\"form-control\" placeholder=\"Password\" required name=\"id\">" +
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
    }

}
