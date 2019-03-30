package ToDoListJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet to take ToDo from the form on index.jsp and insert it into the database
 * Servlet implementation class ToDoServlet
 * @author Michael Forman
 */
@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoServlet() {
        super();
        // Not used.
    }

	/**
	 * @param  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//method used only for responding with a refreshed index.jsp after POST stores ToDo.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		response.setHeader("Refresh", "0; URL=index.jsp");
		
	}

	/** POST takes ToDo and sends it to the back end which puts it into the database.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LocalDate createDate = LocalDate.now();
		DateTimeFormatter fd =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dueDate= LocalDate.parse(request.getParameter("theToDoDue"), fd);
		
		ToDos theToDo = new ToDos(createDate, request.getParameter("theToDoTitle"), 
				request.getParameter("theToDoDesc"), dueDate);
		//ToDoList.saveBadToDos("'"+createDate.toString()+"'", "'"+request.getParameter("theToDoTitle")+"'", request.getParameter("theToDoDesc"), "'"+dueDate.toString()+"'");

		
	doGet(request, response);
	}

}
