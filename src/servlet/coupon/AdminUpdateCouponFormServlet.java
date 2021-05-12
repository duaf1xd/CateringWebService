package servlet.coupon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Coupon;
import service.CouponService;

/**
 * Servlet implementation class AdminUpdateCouponFormServlet
 */
@WebServlet("/AdminUpdateCouponFormServlet")
public class AdminUpdateCouponFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateCouponFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		if (username == null) {
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			Coupon coupon = new CouponService().findById(id);		
			request.setAttribute("coupon", coupon);
			request.getRequestDispatcher("admin_update_coupon_form.jsp").forward(request, response);
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
