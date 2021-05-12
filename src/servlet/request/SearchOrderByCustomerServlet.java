package servlet.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Customer;
import entity.Request;
import service.CustomerService;
import service.OrderService;

/**
 * Servlet implementation class SearchOrderByCustomerServlet
 */
@WebServlet("/SearchOrderByCustomerServlet")
public class SearchOrderByCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderByCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		CustomerService service = new CustomerService();
		Customer cus = service.findCustomerByName(name);
		List<Request> requests = new OrderService().findByCustomerId(cus.getId());
		if(requests.isEmpty()) {
			request.setAttribute("error", "No Order Found!");
		} else {
			request.setAttribute("requests", requests);
		}
		response.sendRedirect("AdminViewRequestServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
