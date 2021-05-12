package servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Customer;
import service.CustomerService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer cus = new CustomerService().checkLogin(username, password);
		if(cus == null) {
			request.setAttribute("error", "Username or password is incorrect!\nPlease enter again");
			request.getRequestDispatcher("/login_customer.jsp").include(request, response);
		} else {
			request.getSession().setAttribute("username", cus.getUsername());
			request.getSession().setAttribute("id", cus.getId());
			request.getRequestDispatcher("/").forward(request, response);
		}
	}

}
