import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@WebServlet("/a1")
public class ServletTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("username");
            String option = req.getParameter("option");
            String info = req.getParameter("Text");
            String secret = req.getParameter("secretMessage");

            StringJoiner stringJoiner = new StringJoiner(" ");
            stringJoiner.add(username);
            stringJoiner.add(option);
            stringJoiner.add(info);
            stringJoiner.add(secret);
            resp.getWriter().println("Info : " + stringJoiner);
        }
    }
