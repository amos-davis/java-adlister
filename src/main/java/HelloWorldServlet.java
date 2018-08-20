import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("text/html");
    PrintWriter out = null;
    String name = (req.getParameter("name") != null) ? req.getParameter("name") : "World";

    try {
        out = res.getWriter();
    out.println("<h1>Hi, " + name + "</h1>" );
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
