package servlet.item;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.Item;
import service.ItemService;
import util.ImageUtil;

/**
 * Servlet implementation class AdminCreateItemServlet
 */
@WebServlet("/AdminCreateItemServlet")
@MultipartConfig
public class AdminCreateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    //Directory where uploaded files will be saved, its relative to the web application directory.
	private static final String UPLOAD_DIR = "uploads";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		if (username == null) {
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		} else {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			int inStock = Integer.parseInt(request.getParameter("in_stock"));
			String unit = request.getParameter("unit");
			
			Part imagePart = request.getPart("image");
			InputStream fileContent = imagePart.getInputStream();			
			byte[] image = ImageUtil.getBytesFromInputStream(fileContent);
			
			Item item = new Item();
			item.setName(name);
			item.setDescription(description);
			item.setImage(image);
			item.setPrice(price);
			item.setInStock(inStock);
			item.setUnit(unit);
			
			new ItemService().insert(item);
			request.setAttribute("success", "Create Item Successfully!");
			response.sendRedirect("AdminManageItemServlet");
		}
	}

}
