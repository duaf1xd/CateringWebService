package servlet.coupon;

import java.util.List;
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
 * Servlet implementation class AdminManageCoupon
 */
@WebServlet("/AdminManageCouponServlet")
public class AdminManageCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManageCouponServlet() {
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
			List<Coupon> couponList = new CouponService().findAll();
			for (Coupon c : couponList) {
				System.out.println(c.getCode());
			}
			if(couponList.isEmpty()) {
				request.setAttribute("error", "EMPTY TABLE");
			} else {
				request.setAttribute("coupons", couponList);
			}
			request.getRequestDispatcher("/admin_manage_coupon.jsp").forward(request, response);
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
