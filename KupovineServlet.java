package ba.smoki.kikiriki.three;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class KupovineServlet extends HttpServlet {
    @Override
    protected
    void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Dobijanje podataka o korisniku iz forme
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String kartica = request.getParameter("kartica");
        // Simulacija uspješne kupovine - obavještavanje korisnika
        response.setContentType("text/html");
        response.getWriter().println("Kupovina uspješna ,hvala što ste kupili!");

        // Brisanje korpe (uklanjanje iz HttpSession objekta)
        HttpSession session = request.getSession();
        session.removeAttribute("korpa");
    }

        }

