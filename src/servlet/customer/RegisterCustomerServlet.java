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
import util.PasswordUtil;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/RegisterCustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		StringBuilder builder = new StringBuilder();
		if(!password.equals(repassword)) {
			builder.append("Re-password and password are not the same!");
			
		}
		String strDob = request.getParameter("dob");
		
		Date dob = DateUtil.stringToDate(strDob);
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setIsBanned(0);
		customer.setName(name);
		customer.setPhoneNumber(phoneNumber);
		customer.setUsername(username);
		customer.setDob(dob);
		String pass = PasswordUtil.encrytpPassword(password);
		customer.setPassword(pass);
		int id = new CustomerService().save(customer);
		if(id <= 0) {
			builder.append("Registered failed!");
		}
	
		if(builder.length() > 0) {
			request.setAttribute("error", builder.toString());
			request.getRequestDispatcher("/register.jsp").include(request, response);
		} else {
			request.setAttribute("success", "Customer Registered Successfully!");
			request.getRequestDispatcher("/login_customer.jsp").forward(request, response);
		}
	}

}
