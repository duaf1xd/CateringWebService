package servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import entity.Coupon;
import entity.Manager;
import service.CouponService;
import service.ManagerService;
import util.EmailUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if((String) request.getSession().getAttribute("username") != null) {
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
    	} else {
    		request.getRequestDispatcher("/login.jsp").forward(request, response);
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desPage = "";
		String username = request.getParameter("username");
			String password = request.getParameter("password");
			Manager manager = new ManagerService().checkLogin(username, password);
			if(manager == null) {
				request.setAttribute("error", "Username or password is incorrect!\nPlease enter again");
				desPage = "/login.jsp";
			} else {
				request.getSession().setAttribute("username", manager.getUsername());
				desPage = "/admin_index.jsp";
			}
		
		request.getRequestDispatcher(desPage).forward(request, response);
	}

}
