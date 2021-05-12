package servlet.customer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.CouponDAOI;
import controller.CustomerDAOI;
import controller.ItemDAOI;
import controller.OrderDAOI;
import db.HibernateUtil;
import entity.Coupon;
import entity.Customer;
import entity.Request;

/**
 * Servlet implementation class Customer_PersistOrder
 */
@WebServlet("/PersistOrder")
public class Customer_PersistOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_PersistOrder() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content= request.getParameter("per_req");
		String total= request.getParameter("per_total");
		String add= request.getParameter("per_add");
		String coup= request.getParameter("per_coupon");
		String recy= request.getParameter("per_recycle");
		System.out.println(content);
		System.out.println(total);
		
		HttpSession sess= request.getSession();
		CustomerDAOI cdi= new CustomerDAOI();
		int cs_id= (Integer) sess.getAttribute("id");
		Customer cs= cdi.get(cs_id);
		
		Request rq= new Request();
		rq.setDetail(content);
		rq.setRequestTime(new Date());
		rq.setTotalPrice(Double.parseDouble(total));
		rq.setCustomer(cs);
		rq.setStatus(1);
		rq.setDeliverAd(add);
		rq.setRecycle(recy!=null? 1 : 0 );
		
		OrderDAOI odi= new OrderDAOI();
		odi.insert(rq);
		
		if(!coup.equalsIgnoreCase("None") && !coup.equalsIgnoreCase("ERROR")) {
			CouponDAOI cpdi= new CouponDAOI();
			
			
			cpdi.useCoupon(coup);
			
		}
		
		response.sendRedirect("customer_order_status");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
