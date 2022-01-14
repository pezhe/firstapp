// Пустой PR, т. к. весь код заехал в мастер с initial commit. Можно посмотреть код проекта

package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ProductListServlet", urlPatterns = "/products")
public class ProductListServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        req.setAttribute("ProductList", getProducts());
        getServletContext().getRequestDispatcher("/products.jsp").forward(req, resp);
    }

    private List<Product> getProducts() {
        return Arrays.asList(
                new Product(1, "Milk", 30.0),
                new Product(2, "Meat", 100.0),
                new Product(3, "Potato", 10.0),
                new Product(4, "Gum", 5.0),
                new Product(5, "Cheese", 80.0),
                new Product(6, "Sausage", 50.0),
                new Product(7, "Juice", 40.0),
                new Product(8, "Chocolate", 20.0),
                new Product(9, "Bread", 30.0),
                new Product(10, "Spaghetti", 40.0)
        );
    }

}
