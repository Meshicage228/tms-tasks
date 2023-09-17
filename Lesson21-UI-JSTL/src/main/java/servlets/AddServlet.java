
package servlets;

import config.CustomDB;
import domain.Product;

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

        Product product = new Product();

        product.setTitle(title);
        product.setHeight(height);
        product.setWeight(weight);

        customDB.create(product);

        req.getRequestDispatcher("/home").forward(req, resp);
    }
}