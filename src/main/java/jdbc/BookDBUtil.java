
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Book;

import model.Book;

public class BookDBUtil {

	private DataSource dataSource;

	public BookDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Book> getBooks() throws Exception {
		List<Book> books = new ArrayList<>();
		Connection myConn = null;
		Statement myState = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "select * from Book";
			myState = myConn.createStatement();

			myRs = myState.executeQuery(sql);

			while (myRs.next()) {
				int id = myRs.getInt("id");
				String bookName = myRs.getString("BookName");
				String NXB = myRs.getString("NXB");
				Float price = myRs.getFloat("price");
				
				Book book = new Book(id, bookName, NXB, price);
				books.add(book);
			}
			return books;
		} finally {
			close(myConn, myState, myRs);
		}
	}
	
	

	public void addBook(Book Book) throws SQLException {
		Connection myConn = null;
		PreparedStatement myState = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "insert into Book " + "(bookName,NXB,price)" + " values (?, ?, ?)";
			myState = myConn.prepareStatement(sql);
			myState.setString(1, Book.getBookName());
			myState.setString(2, Book.getNXB());
			myState.setFloat(3, Book.getPrice());

			myState.execute();
		} finally {
			close(myConn, myState, null);
		}
	}

	public void updateBook(Book Book) throws SQLException {
		Connection myConn = null;
		PreparedStatement myState = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "update Book " + "set bookName = ?, NXB = ?, price = ?" + " where id = ?";
			myState = myConn.prepareStatement(sql);
			myState.setString(1, Book.getBookName());
			myState.setString(2, Book.getNXB());
			myState.setFloat(3, Book.getPrice());
			myState.setInt(4, Book.getId());

			myState.execute();
		} finally {
			close(myConn, myState, null);
		}
	}

	public void deleteBook(String BookId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myState = null;

		try {

			int theBookId = Integer.parseInt(BookId);
			myConn = dataSource.getConnection();

			String sql = "delete from Book where id = ?";
			myState = myConn.prepareStatement(sql);
			myState.setInt(1, theBookId);

			myState.execute();
		} finally {
			close(myConn, myState, null);
		}
	}

	public Book getBook(String BookId) throws Exception {
		Connection myConn = null;
		PreparedStatement myState = null;
		ResultSet myRs = null;
		Book Book = null;

		try {

			int theBookId = Integer.parseInt(BookId);
			myConn = dataSource.getConnection();
			String sql = "select *  from Book where id = ?";
			myState = myConn.prepareStatement(sql);
			myState.setInt(1, theBookId);

			myRs = myState.executeQuery();
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String bookName = myRs.getString("BookName");
				String NXB = myRs.getString("NXB");
				Float price = myRs.getFloat("price");
				Book = new Book(id,bookName,NXB,price);

			} else {
				throw new Exception("Could not find Book id - " + theBookId);
			}
			return Book;
		} finally {
			close(myConn, myState, null);
		}
	}

	private void close(Connection myConn, Statement myState, ResultSet myRs) {
		try {
			if (myConn != null) {
				myConn.close();
			}
			if (myState != null) {
				myState.close();
			}
			if (myRs != null) {
				myRs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}