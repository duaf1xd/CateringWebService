package servlet.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Request;
import service.OrderService;

/**
 * Servlet implementation class AdminUpdateOrderStatus
 */
@WebServlet("/AdminUpdateOrderStatus")
public class AdminUpdateOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DELIVER_STATUS = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateOrderStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Request req =  new OrderService().findById(id);
		Request req1 = new Request();
		req1.setCustomer(req.getCustomer());
		req1.setDetail(req.getDetail());
		req1.setRequestTime(req.getRequestTime());
		req1.setStatus(DELIVER_STATUS);
		req1.setId(req.getId());
		req1.setRecycle(req.getRecycle());
		req1.setDeliverAd(req.getDeliverAd());
		req1.setTotalPrice(req.getTotalPrice());
		new OrderService().update(req1);
		request.getSession().setAttribute("success", "Update Request Successfully!");
		response.sendRedirect("AdminViewRequestServlet");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
