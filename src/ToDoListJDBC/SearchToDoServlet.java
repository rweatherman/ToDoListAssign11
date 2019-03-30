package ToDoListJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet to get and return the list of ToDos from the database
 * Servlet implementation class ListToDoServlet
 * @author Michael Forman
 */
@WebServlet("/SearchToDoServlet")
public class SearchToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchToDoServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<ToDos> theToDos = new ArrayList<>();
		DateTimeFormatter fd =  DateTimeFormatter.ofPattern("MM-dd-yyyy");
		response.setContentType("text/html");
		String dueDate;
		String createdDate;
		PrintWriter out = response.getWriter();
		out.append("<table>");
		
		//establish the styles (wouldn't pull from css for some reason).
		out.append("<style>\r\n" + 
				"table {\r\n" + 
				"  font-family: arial, sans-serif;\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"  width: 100%;\r\n" + 
				"  background-color: #7ebbfe;\r\n" +
				"}\r\n" + 
				"\r\n" + 
				"td, th {\r\n" + 
				"  border: 1px solid #0000ff;\r\n" + 
				"  text-align: left;\r\n" + 
				"  padding: 8px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"tr:nth-child(even) {\r\n" + 
				"  background-color: #b3eeff;\r\n" + 
				"}\r\n" + 
				"</style>");
		
		
		List<ToDos> theToDos = new ArrayList<ToDos>();
		try {
			theToDos = ToDoList.listSearchToDos( request.getParameter("theSearchString"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.append("<tr><th>Created Date</th><th>To Do Title</th><th>To Do Description</th>"
				+ "<th>To Do Due Date</th></tr>");
		for (ToDos eachToDo : theToDos) {
			createdDate = fd.format(eachToDo.getCreatedDate());
			dueDate = fd.format(eachToDo.getToDoDue());
			out.println("<tr><td>" + createdDate + "</td><td>" + eachToDo.getToDoTitle() 
			+ "</td><td>" + eachToDo.getToDoDes() + "</td><td>" + dueDate + "</td></tr>");
			}
		
		out.append("<form action=" + "\"SearchToDoServlet\"" + " method=" + "\"GET\"" +"> " 
       + " <div class=" + "\"row\"" + ">"
		+ "<tr><td><li><a href=" + "\"index.jsp\"" + ">Return Home</a></li></td><td><div class=" + "\"col-25\"" + ">"
      + "<label for=" + "\"theSearchString\"" + ">Search Again:</label>"
     + "</div></td>"
    + "<td><div class=" + "\"col-200\"" +">"
      + "<input type=" + "\"text\"" +  "name=" + "\"theSearchString\"" + "size=" + "\"100\"" +  " placeholder=" + "\"String to search for...\"" + "  />"
    + "</div></td></div><td><div class=" + "\"row\"" + ">"
    + "<input type=" + "\"submit\"" + " value=" + "\"Submit\"" + "/></div></form></td></tr>");
		out.append("</table>");	
	}

	}
