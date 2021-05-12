package servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ItemDAOI;
import entity.Item;


/**
 * Servlet implementation class Customer_MenuServlet
 */
@WebServlet("/customer_menu")
public class Customer_MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ItemDAOI idi= new ItemDAOI();
		
		List<Item> itemList= idi.findAllAvailable();
		if(itemList.size()==0) {
			System.out.println("THIS IS EMPTY!!!");
		}
		for(int i=0; i<itemList.size(); ++i) {
			System.out.println(itemList.get(i).toString());
		}
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/customer_menu.jsp").forward(request, response);
	}
	
//	private void selectAll(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException   {
//        List<Vietnam> listVietnam = userDAO.selectAllProvinces();
//        request.setAttribute("listVietnam", listVietnam);
//        
//        List<World> listWorld = userDAO.selectAllCountries();
//        request.setAttribute("listWorld", listWorld);
//        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//        dispatcher.forward(request, response);
//    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
