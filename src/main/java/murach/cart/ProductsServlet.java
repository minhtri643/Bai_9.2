package murach.cart;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import murach.business.Product;

public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Đọc danh sách sản phẩm từ tệp sản phẩm
        String filePath = getServletContext().getRealPath("/WEB-INF/products.txt");
        ArrayList<Product> productList = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String code = parts[0].trim();
                String description = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                productList.add(new Product(code, description, price));
            }
        } catch (FileNotFoundException e) {
            log("File not found: " + e.getMessage());
        } catch (IOException e) {
            log("Error reading file: " + e.getMessage());
        }

        // Lưu danh sách sản phẩm vào phiên
        HttpSession session = request.getSession();
        session.setAttribute("productList", productList);

        // Chuyển hướng đến trang cart.jsp
        String url = "/cart.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
