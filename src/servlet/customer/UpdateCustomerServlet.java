package servlet.customer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.Customer;
import service.CustomerService;
import util.DateUtil;

/**
 * Servlet implementation class UpdateCustomerFormServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String strDob = request.getParameter("dob");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		Date date = DateUtil.stringToDate(strDob);
		Customer customer = new Customer();
		customer.setId(id);
		customer.setAddress(address);
		customer.setDob(date);
		customer.setEmail(email);
		customer.setIsBanned(0);
		customer.setName(name);
		customer.setUsername(username);	
		customer.setPhoneNumber(phoneNumber);
		Customer cus = new CustomerService().get(id);
		customer.setPassword(cus.getPassword());
		
		new CustomerService().update(customer);
		request.setAttribute("success", "Update Customer Successfully!");
		response.sendRedirect("CustomerServlet");
	}

}
