

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	
	public void init() {
		String jdbcURL =("jdbc:mysql://localhost:3306/books_db");
		String jdbcUsername = ("root");
		String jdbcPassword = ("");
		
		bookDAO = new BookDAO (jdbcURL,jdbcUsername,jdbcPassword);

	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getServletPath();

		try {
		switch (action){
		case"/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertBook(request, response);
			break;
		case "/delete":
		deleteBook(request, response);
		    break;
		 case "/edit":
             showEditForm(request, response);
             break;
         case "/update":
             updateBook(request, response);
             break;
		default:
            ListBook(request, response);
            break;
		}
		}
		catch(SQLException ex) {
            throw new ServletException(ex);
        }

	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		}
			
	private void ListBook (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		List<Book> listBook = bookDAO.list_all_book();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookEntry.jsp");
        dispatcher.forward(request, response);
        
    }
	private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));
 
        Book newBook = new Book(title, author, price);
        newBook.toString();
        bookDAO.insert_book(newBook);
        response.sendRedirect("list");
    }
 
	 private void deleteBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Book book = new Book(id);
	        bookDAO.delete_book(book);
	        response.sendRedirect("list");
	 
	    }
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Book existingBook = bookDAO.get_book(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookEdit.jsp");
	        request.setAttribute("book", existingBook);
	        dispatcher.forward(request, response);
	 
	    }
	 private void updateBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));
	 
	        Book book = new Book(id, title, author, price);
	        bookDAO.update_book(book);
	        response.sendRedirect("list");
	    }
	 

}

