package servlet.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ItemDAOI;
import entity.Item;

/**
 * Servlet implementation class Customer_MakeOrder
 */
@WebServlet("/MakeOrder")
public class Customer_MakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_MakeOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess= request.getSession();
		sess.removeAttribute("cartItems");
		boolean loginStatus= sess.getAttribute("username")==null? false : true;
		
		if(!loginStatus) {
			response.sendRedirect("login_customer.jsp");
		}
		else {
			ItemDAOI idi= new ItemDAOI();
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String[] itemIds= request.getParameterValues("item");
			
//			if(itemIds==null) {
//				request.setAttribute("sdf_error", "Please select at least one item!");
//				request.getRequestDispatcher("/customer_menu.jsp").forward(request, response);
//			}
			
			List<Item> itemList= new ArrayList<Item>();
			for(int i=0; i<itemIds.length; ++i) {
				
				itemList.add(idi.get(Integer.parseInt(itemIds[i])));
			}
			sess.setAttribute("cartItems", itemList);
			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher("/customer_makeorder.jsp").forward(request, response);
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
