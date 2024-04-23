package ba.smoki.kikiriki.three;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class PvoidotvrdaKupovineServlet extends HttpServlet{
    @Override
    protected  void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html");
     response.getWriter().println("<form action='/kupovina' method='post'"
             +"Ime:<input type='text' name='ime'><br>"
             +"Prezime:<input type='text' name='prezime'><br>"
             +"Broj kreditne kartice: <input type='text' name='kartica'><br> "
             + "<input type='submit' value='KUPI'></form");
    }

}




