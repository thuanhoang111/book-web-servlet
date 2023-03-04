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

import model.Book;

import jdbc.BookDBUtil;

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
			case "ADD":
				addBook(request, response);
				break;
			case "LOAD":
				loadBook(request, response);
				break;
			case "UPDATE":
				updateBook(request, response);
				break;
			case "DELETE":
				deleteBook(request, response);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-book2.jsp");
		dispatcher.forward(request, response);
	}
	private void loadBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theBookId = request.getParameter("id");
		Book book = bookDBUtil.getBook(theBookId);
		
		request.setAttribute("THE_Book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-sach-form.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String theBookId = request.getParameter("id");

		bookDBUtil.deleteBook(theBookId);

		listBook(request, response);

	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String bookName = request.getParameter("bookName");
		String NXB = request.getParameter("NXB");
		float price = Float.valueOf(request.getParameter("price"));
		
		Book book = new Book(id, bookName, NXB, price);
		
		bookDBUtil.updateBook(book);
		
		listBook(request, response);
	}

	@SuppressWarnings("unused")
	private void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bookName = request.getParameter("bookName");
		String NXB = request.getParameter("NXB");
		float price = Float.valueOf(request.getParameter("price"));

		Book book = new Book(bookName, NXB, price);

		bookDBUtil.addBook(book);

		listBook(request, response);
	}
}
