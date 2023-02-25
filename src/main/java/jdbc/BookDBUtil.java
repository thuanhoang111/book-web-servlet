
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