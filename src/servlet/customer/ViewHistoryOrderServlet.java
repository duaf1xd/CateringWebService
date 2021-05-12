package servlet.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class ViewHistoryOrderServlet
 */
@WebServlet("/ViewHistoryOrderServlet")
public class ViewHistoryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewHistoryOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = (int) request.getSession(false).getAttribute("id");
		
		List<Request> requests = new OrderService().findByCustomerId(1);
		List<Item> totalList = new ArrayList<>();
		List<Request> impendingRequests = null;
		if(requests != null) {
			impendingRequests = RequestUtil.getRequestMap(requests).get(1);
		} else {
			request.setAttribute("error", "You have no order history!");
		}
		if(!impendingRequests.isEmpty()) {
			for(Request req : impendingRequests) {
				List<Item> items = req.getItems();
				for(Item item : items) {
					try {			
						String image = ImageUtil.blobToString(item.getImage());
						item.setImageBase(image);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				totalList.addAll(items);
			}
			request.setAttribute("items", totalList);
		}
		request.getRequestDispatcher("/order_history.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
