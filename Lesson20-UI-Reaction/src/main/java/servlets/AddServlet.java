package servlets;

import config.CustomDB;
import domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private final CustomDB customDB = new CustomDB();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        List<String> spaces = parameterMap.entrySet().stream()
                .flatMap(entry -> Arrays.stream(entry.getValue()))
                .filter(String::isEmpty)
                .toList();

        if(spaces.isEmpty()) {

            String title = req.getParameter("title");
            float height = Float.parseFloat(req.getParameter("height"));
            float weight = Float.parseFloat(req.getParameter("weight"));

            Product fridge = new Product();

            fridge.setTitle(title);
            fridge.setHeight(height);
            fridge.setWeight(weight);

            customDB.create(fridge);
        }

        req.getRequestDispatcher("/home").forward(req, resp);
    }
}
