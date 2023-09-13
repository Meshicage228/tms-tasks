import domain.Fridge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private final CustomDB customDB = new CustomDB();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        float height = Float.parseFloat(req.getParameter("height"));
        float weight = Float.parseFloat(req.getParameter("weight"));

        Fridge fridge = new Fridge();

        fridge.setTitle(title);
        fridge.setHeight(height);
        fridge.setWeight(weight);

        customDB.create(fridge);

        req.getRequestDispatcher("/home").forward(req, resp);
    }
}
