package servlet.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Request;
import service.OrderService;

/**
 * Servlet implementation class SortByStatusServlet
 */
@WebServlet("/SortByStatusServlet")
public class SortByStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortByStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderBy = request.getParameter("orderBy");
	
		List<Request> requests = new OrderService().sortByAscStatus(orderBy);
		request.setAttribute("requests", requests);
		request.getRequestDispatcher("/admin_manage_order.jsp").forward(request, response);
	}

}
