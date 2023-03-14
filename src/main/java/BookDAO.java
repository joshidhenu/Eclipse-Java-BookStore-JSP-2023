import java.sql.*;
import java.util.*;

public class BookDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
	public void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
	
	
	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
		}
	}

	
	   

	public boolean insert_book(Book book1) throws SQLException {
		String sql = "insert into book1 (title,author,price) VALUES (?,?,?)";
		connect();
		
		PreparedStatement statement=jdbcConnection.prepareStatement(sql);
		statement.setString(1, book1.getTitle());
		statement.setString(2, book1.getAuthor());
		statement.setFloat(3, book1.getPrice());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Book> list_all_book() throws SQLException {
		List<Book> listBook = new ArrayList<>();
		String sql = "select * from book1";
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
             
            Book book = new Book(id, title, author, price);
            listBook.add(book);
		}
		resultSet.close();
        statement.close();
         
        disconnect();
         
        return listBook;
    
	}
	public boolean delete_book(Book book) throws SQLException {
		String sql = "DELETE FROM book1 where id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1,book.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}
	public boolean update_book(Book book1) throws SQLException {
		String sql = "UPDATE book1 SET title = ?, author = ?, price = ?";
        sql += " WHERE id = ?";
        connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book1.getTitle());
        statement.setString(2, book1.getAuthor());
        statement.setFloat(3, book1.getPrice());
        statement.setInt(4, book1.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
	}
	public Book get_book(int id) throws SQLException {
		Book book1 = null;
		String sql = "select * from book1 where id = ?";
		connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
             
            book1 = new Book(id, title, author, price);
        }
         
        resultSet.close();
        statement.close();
         
        return book1;
	}
}
