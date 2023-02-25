package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import jdbc.BookDBUtil;
import model.Book;

@WebServlet("/BookController")
public class BookController extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	
	@Resource (name = "jdbc/BookData")
	private DataSource dataSource;
	
	private BookDBUtil bookDBUtil ; 
	
	@Override
	public void init() throws ServletException {
		try {
			 bookDBUtil = new BookDBUtil(dataSource);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "LIST";
			}
			switch (theCommand) {
			case "LIST":
				listBook(request, response);
				break;
	
			default:
				listBook(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void listBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Book> books = bookDBUtil.getBooks();
		request.setAttribute("BOOK_LIST", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-student.jsp");
		dispatcher.forward(request, response);
	}

}
