package servlet.customer;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import entity.Coupon;
import service.CouponService;
import util.EmailUtil;

/**
 * Servlet implementation class MakePaymentServlet
 */
@WebServlet("/MakePaymentServlet")
public class MakePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private String host;

      private int sslPort;
      private int tslPort;
      private String gmail;
      private String password;
      private String receiver;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakePaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	ServletContext context = getServletContext();
    	host = context.getInitParameter("host");
   		tslPort = Integer.parseInt(context.getInitParameter("tslport"));
    	sslPort = Integer.parseInt(context.getInitParameter("sslport"));
    	gmail = context.getInitParameter("email");
    	password = context.getInitParameter("password");
    	receiver = context.getInitParameter("receiver");
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Coupon coupon = new CouponService().getAvailableCoupon();
			
			new Thread(new Runnable() {			
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						EmailUtil.sendCouponCode(receiver, coupon.getCode(), host, sslPort, tslPort, gmail, password);
						
					} catch (EmailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();	
			request.getSession().setAttribute("message", "Coupon already sent to your email!");
		response.sendRedirect("ViewOrderServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
