package servlet.item;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
 * Servlet implementation class AdminUpdateItemServlet
 */
@WebServlet("/AdminUpdateItemServlet")
@MultipartConfig
public class AdminUpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateItemServlet() {
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
			//cannot change id, imageBase
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			
			Part imagePart = request.getPart("image");
			InputStream fileContent = imagePart.getInputStream();			
			byte[] image = ImageUtil.getBytesFromInputStream(fileContent);
			
			int inStock = Integer.parseInt(request.getParameter("in_stock"));
			String unit = request.getParameter("unit");
			
			Item item = new Item();
			item.setId(id);
			item.setName(name);
			item.setDescription(description);
			item.setPrice(price);
			item.setInStock(inStock);
			item.setUnit(unit);
			System.out.println(item.toString());
			new ItemService().update(item);
			request.setAttribute("success", "Update Item Successfully!");
			response.sendRedirect("AdminManageItemServlet");
		}
	}

}
