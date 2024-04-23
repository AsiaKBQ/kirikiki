import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (isValidUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }

    private boolean isValidUser(String username, String password) {
        // Ovdje se proverava da li korisnik postoji u datoteci korisnici.txt
        // i da li je uneta ispravna lozinka.
        // Implementacija ove metode zavisi od vaših zahteva.
        // Ovo je samo primer:
        try (Scanner scanner = new Scanner(new File("korisnici.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}

public class BuyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            // Korisnik je prijavljen, omogućite kupovinu.
            // Implementirajte logiku za kupovinu.
            response.sendRedirect("buy.jsp");
        } else {
            // Korisnik nije prijavljen, preusmjerite ga na stranicu za prijavu.
            response.sendRedirect("login.jsp");
        }
    }
}
