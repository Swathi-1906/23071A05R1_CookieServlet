import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Simple hardcoded check (for demo)
        if ("admin".equals(username) && "admin123".equals(password)) {
            // Create 4 cookies
            Cookie c1 = new Cookie("username", username);
            Cookie c2 = new Cookie("role", "admin");
            Cookie c3 = new Cookie("lastLogin", String.valueOf(System.currentTimeMillis()));
            Cookie c4 = new Cookie("theme", "dark");

            // Set expiry - 1 day
            c1.setMaxAge(24*60*60);
            c2.setMaxAge(24*60*60);
            c3.setMaxAge(24*60*60);
            c4.setMaxAge(24*60*60);

            // Add cookies to response
            response.addCookie(c1);
            response.addCookie(c2);
            response.addCookie(c3);
            response.addCookie(c4);

            // Display cookies in table
            out.println("<h2>Login Successful</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Cookie Name</th><th>Value</th></tr>");
            out.println("<tr><td>" + c1.getName() + "</td><td>" + c1.getValue() + "</td></tr>");
            out.println("<tr><td>" + c2.getName() + "</td><td>" + c2.getValue() + "</td></tr>");
            out.println("<tr><td>" + c3.getName() + "</td><td>" + c3.getValue() + "</td></tr>");
            out.println("<tr><td>" + c4.getName() + "</td><td>" + c4.getValue() + "</td></tr>");
            out.println("</table>");

        } else {
            out.println("<h2>Login Failed. Invalid Credentials.</h2>");
            out.println("<a href='index.html'>Try Again</a>");
        }
    }
}
