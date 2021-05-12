package servlet.customer;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.Customer;
import service.CustomerService;
import util.DateUtil;

/**
 * Servlet implementation class ExportToFileServlet
 */
@WebServlet("/ExportToFileServlet")
public class ExportToFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportToFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {					
					
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet();
			Date now = new Date();
			String current = DateUtil.dateToString(now);
			String fileName = "customer_csv_" + current;
			List<Customer> customers = new CustomerService().findAll();			
				int rowNumber = 0;
			Row row = sheet.createRow(rowNumber++);	
				int cellNumber = 0;
				Cell cell = row.createCell(cellNumber++);
				
				cell.setCellValue("Customer Name");
				 cell = row.createCell(cellNumber++);
				
				cell.setCellValue("User Name");
				 cell = row.createCell(cellNumber++);
				
				cell.setCellValue("Email");
				 cell = row.createCell(cellNumber++);
				cell.setCellValue("Address");
				 cell = row.createCell(cellNumber++);
				cell.setCellValue("Phone Number");
				 cell = row.createCell(cellNumber++);
				cell.setCellValue("Date Of Birth");
				for(int i = 0; i < 6; i++) {
					sheet.autoSizeColumn(i);
				}
				for(Customer cus: customers) {			
				cellNumber = 0;
				row = sheet.createRow(rowNumber++);
				cell = row.createCell(cellNumber++);
				cell.setCellValue(cus.getName());
				
				cell = row.createCell(cellNumber++);
				cell.setCellValue(cus.getUsername());
				
				cell = row.createCell(cellNumber++);
				cell.setCellValue(cus.getEmail());
				
				cell = row.createCell(cellNumber++);
				cell.setCellValue(cus.getAddress());
				
				cell = row.createCell(cellNumber++);
				cell.setCellValue(cus.getPhoneNumber());
				
				cell = row.createCell(cellNumber++);
				cell.setCellValue(cus.getDob());
				}	
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".xls");			
				wb.write(response.getOutputStream());
			
			
		} catch(Exception e) {
			e.printStackTrace();
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
