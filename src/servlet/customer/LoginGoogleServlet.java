package servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.GoogleEntity;
import util.GoogleUtil;

/**
 * Servlet implementation class LoginGoogleServlet
 */
@WebServlet("/LoginGoogleServlet")
public class LoginGoogleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginGoogleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String code = request.getParameter("code");
			if(code == null || code.isEmpty()) {
				request.getRequestDispatcher("/login_customer.jsp").forward(request, response);
				
			} else {
				String token = GoogleUtil.getGoogleToken(code);
				GoogleEntity google = GoogleUtil.getUserInfor(token);
				request.setAttribute("id", google.getId());
				request.setAttribute("name", google.getName());;
				request.setAttribute("email", google.getEmail());;
				request.getRequestDispatcher("/homepage.jsp").forward(request, response);
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
