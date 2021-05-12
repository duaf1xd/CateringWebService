package servlet.coupon;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Coupon;
import service.CouponService;
import util.DateUtil;

/**
 * Servlet implementation class AdminCreateCouponServlet
 */
@WebServlet("/AdminCreateCouponServlet")
public class AdminCreateCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateCouponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		if (username == null) {
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		} else {
			//currentUsageCount will set to 0 when creating new coupon
			String code = request.getParameter("code");
			String description = request.getParameter("description");
			double rate = Double.parseDouble(request.getParameter("rate"));
			double minOrderPrice = Double.parseDouble(request.getParameter("min_order_price"));
			double maxReductionPrice = Double.parseDouble(request.getParameter("max_reduction_price"));
			String expiredDateStr = request.getParameter("expired_date");
			Date expiredDate = DateUtil.stringToDate(expiredDateStr);
			int maxUsageCount = Integer.parseInt(request.getParameter("max_usage_count"));
			Coupon coupon = new Coupon();
			coupon.setCode(code);
			coupon.setDescription(description);
			coupon.setRate(rate);
			coupon.setMinOrderPrice(minOrderPrice);
			coupon.setMaxReductionPrice(maxReductionPrice);
			coupon.setExpiredDate(expiredDate);
			coupon.setCurrentUsageCount(0);
			coupon.setMaxUsageCount(maxUsageCount);
			
			new CouponService().insert(coupon);
			request.setAttribute("success", "Create Coupon Successfully!");
			response.sendRedirect("AdminManageCouponServlet");
		}
	}

}
