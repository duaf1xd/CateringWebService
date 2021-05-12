package servlet.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CouponDAOI;
import controller.ItemDAOI;
import entity.Coupon;
import entity.Item;

/**
 * Servlet implementation class Customer_FinalizeOrder
 */
@WebServlet("/FinalizeOrder")
public class Customer_FinalizeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_FinalizeOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess= request.getSession();
		boolean loginStatus= sess.getAttribute("username")==null? false : true;
		
		if(!loginStatus) {
			response.getWriter().append("You are not logged in yet.").append(request.getContextPath());
		}
		else {
		
			String couponCode= request.getParameter("coupon_code").trim().toUpperCase();
			CouponDAOI cdi= new CouponDAOI();
	
//			System.out.println("Coupon entered: "+ couponCode);
//			
			Coupon co= cdi.findCouponByCode(couponCode);
//			System.out.println(co.toString());
			
			
			List<Item> li= (List<Item>) sess.getAttribute("cartItems");
			String[] am= request.getParameterValues("amount");
			String order= "";
			double totalPrice= 0d;
			for(int i=0; i<li.size(); ++i) {
				
				Item it= li.get(i);
				double itemPrice= Double.parseDouble(am[i])*it.getPrice();
				
				order+= am[i] + " ";
				order+= it.getUnit() + " ";
				order+= it.getName() + " at ";
				order+= it.getPrice() + "/"+ it.getUnit();
				order+= ", total is "+ itemPrice;
				order+= "\r\n";
				
				totalPrice+= itemPrice;
			}
			
			
			
			if(co!=null) {
				order+= "\r\n";
				boolean validationPass= true;
				
				//check expiry date
				if(new Date().compareTo(co.getExpiredDate())>0) {
					order+="Coupon "+ couponCode+ " not applicable: "+ " Date expired";
					order+= "\r\n";
					validationPass= false;
					request.setAttribute("coupon", "ERROR");
				}
				//check remaining usage counts
				if(co.getCurrentUsageCount()>=co.getMaxUsageCount()) {
					order+="Coupon "+ couponCode+ " not applicable: "+ " Maximum usage count reached";
					order+= "\r\n";
					validationPass= false;
					request.setAttribute("coupon", "ERROR");
				}
				//check if minimum price is reached
				if(co.getMinOrderPrice()>totalPrice) {
					order+="Coupon "+ couponCode+ " not applicable: "+ " Minimum price not reached ("
							+co.getMinOrderPrice()+ ")";
					order+= "\r\n";
					validationPass= false;
					request.setAttribute("coupon", "ERROR");
				}
				
				if(validationPass) {
					order+="Order Price before reduction: "+ totalPrice;
					order+="\r\n";
					double tempRed= totalPrice/100d*co.getRate();
					if(tempRed> co.getMaxReductionPrice()) tempRed= co.getMaxReductionPrice();
					totalPrice-=tempRed;
					order+="Coupon "+ couponCode+ " applied: "+ tempRed + " discounted ("+ co.getRate()
					+"% reduction, max "+ co.getMaxReductionPrice()+ ")";
					order+= "\r\n";
					request.setAttribute("coupon", couponCode);
					
				}	
			}
			else {
				if(couponCode!=null &&couponCode.length()>0) {
					order+= "\r\n";
					order+="Coupon "+ couponCode+ " not applicable: "+ " Invalid coupon";
					order+= "\r\n";
					request.setAttribute("coupon", "ERROR");
				}
				else {
					request.setAttribute("coupon", "None");
				}
			}
			
			String ad= (String) request.getParameter("address");
			System.out.println("This is ad: "+ad);
			request.setAttribute("content", order);
			request.setAttribute("total", totalPrice);
			request.setAttribute("addr", ad);
			
			
			
			request.getRequestDispatcher("/customer_finalizeorder.jsp").forward(request, response);
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
