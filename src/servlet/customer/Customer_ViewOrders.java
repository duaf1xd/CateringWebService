package servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.OrderDAOI;
import entity.Request;

/**
 * Servlet implementation class Customer_ViewOrders
 */
@WebServlet("/customer_order_status")
public class Customer_ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_ViewOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess= request.getSession();
		
		boolean loginStatus= sess.getAttribute("username")==null? false : true;
		
		if(!loginStatus) {
			response.sendRedirect("login_customer.jsp");
		}
		else {
			OrderDAOI odi= new OrderDAOI();
			List<Request> orderList= odi.findByCustomerId((Integer)sess.getAttribute("id"));
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("/customer_vieworders.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
