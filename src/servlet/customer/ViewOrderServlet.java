package servlet.customer;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.Item;
import entity.Request;
import service.OrderService;
import util.ImageUtil;
import util.RequestUtil;

/**
 * Servlet implementation class ViewOrderServlet
 */
@WebServlet("/ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = (int) request.getSession(false).getAttribute("id");
		List<Request> requests = new OrderService().findByCustomerId(1);
		Request req = RequestUtil.getRequestMap(requests).get(0).get(0);
		List<Item> items = null;
		double price = 0;			
			items = req.getItems();
			price = req.totalFee();
		if(items != null) {
			for(Item item : items) {
				try {			
					String image = ImageUtil.blobToString(item.getImage());
					item.setImageBase(image);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
				request.setAttribute("items", items);	
				request.setAttribute("total", price);
				
		} else {
			request.setAttribute("error", "Your cart has no items!");
		}
		
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
