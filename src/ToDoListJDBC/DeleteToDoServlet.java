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

/** @author Michael Forman
 * Servlet implementation class DeleteToDoServlet to list records to be deleted and delete chosen record.
 */
@WebServlet(value = "/DeleteToDoServlet")
public class DeleteToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteToDoServlet() {
        super();
        // Not used in this app. 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ToDos> theToDos = new ArrayList<>();
		DateTimeFormatter fd =  DateTimeFormatter.ofPattern("MM-dd-yyyy");
		response.setContentType("text/html");
		String dueDate;
		String buttonString;
		PrintWriter out = response.getWriter();

		//generate the styles for the table since it won't pull from css for some reason.
		out.append("<table>");
		out.append("<style>\r\n" + 
				"table {\r\n" + 
				"  font-family: arial, sans-serif;\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"  width: 100%;\r\n" + 
				"  background-color: #7ebbfe;\r\n" +
				"}\r\n" + 
				"\r\n" + 
				"input[type=submit] {\r\n" +
				"  background-color: #0080ff;\r\n" +
				"  color: white;\r\n" +
				"  padding: 12px 20px;\r\n" +
				"  border: none;\r\n" +
				"  border-radius: 4px;\r\n" +
				"  cursor: pointer;\r\n" +
				"  float: right;\r\n" +
				"}\r\n" +
				"\r\n" +
				"input[type=submit]:hover {\r\n" +
				"  background-color: #0000ff;\r\n" +
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
		
		//call the list from the database into an ArrayList for processing using method from 
		//original ToDoList back end.
		theToDos = ToDoList.listToDos(); 
		
		//create the table header
		out.append("<tr><th>To Delete</th><th>To Do Title</th><th>To Do Description</th>"
				+ "<th>To Do Due Date</th></tr>");
		//loop through the todo list generating the table rows with the buttons, which have the appropriate 
		//record ID to be deleted if clicked.
		for (ToDos eachToDo : theToDos) {
			String idNumber = String.valueOf(eachToDo.getToDoId());
			buttonString = "<input type=" + "\"radio\"" + " name=" + "\"toDelete\"" + " value="  + idNumber  + ">";
			dueDate = fd.format(eachToDo.getToDoDue());
			out.println("<tr><td style=" + "\"text-align:center\"" + ">" + buttonString + "</td><td>" + eachToDo.getToDoTitle() 
			+ "</td><td>" + eachToDo.getToDoDes() + "</td><td>" + dueDate + "</td></tr>");
			}
		out.append("<tr><td style=" + "\"text-align:center\"" + "><input type=" + "\"submit\"" + "value=" + "\"Delete the Selected To Do\"" + "></td></tr>");
		out.append("</table>");
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//when a record is selected and sumbitted from form above, the action calls this
		//method with the record ID. The record ID is deleted with the method from original 
		//program back end. Returns the delete page url.
		int recordID = Integer.parseInt(request.getParameter("toDelete"));
		ToDoList.deleteToDo(recordID);
		response.setHeader("Refresh", "0; URL=DeleteToDos.jsp");
		
	}

}
