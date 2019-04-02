package ToDoListJDBC;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

/**
 * ToDoList class contains methods to interact with the database to create, list
 * and delete the ToDos
 * 
 * @author Michael Forman CEN2045 - 13200 Professor Shaban 2/6/2019
 */
public class ToDoList {

	static Session session = null;
	static Transaction goToDo = null;

	/** method to save the List object to the database  
	 * @param theToDo the object to be added to the database
	 */
	public static void saveToDos(ToDos theToDo) {
		SessionFactory factory = new Configuration().configure("/resources/hibernate.cfg.xml")
				.addAnnotatedClass(ToDos.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			goToDo = session.beginTransaction();
			session.save(theToDo);
			goToDo.commit();
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close();
		}
	}
	/* method for testing injection
	public static void saveBadToDos(String created_date, String  todo_title, String todo_des, String due_date) {
		SessionFactory factory = new Configuration().configure("/resources/hibernate.cfg.xml")
				.addAnnotatedClass(ToDos.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			goToDo = session.beginTransaction();
			NativeQuery insertQuery= session.createSQLQuery("INSERT into todo_list (created_date, todo_title, due_date, todo_des) VALUES(" + created_date + ", " 
			+ todo_title + ", " +  due_date + ", '" + todo_des + "');");
			insertQuery.executeUpdate();
			goToDo.commit();
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close();
		}
	} */

	/** method to query the list of ToDos from the database
	 * @return list data structure with ToDos
	 */
	public static List<ToDos> listToDos() {
		SessionFactory factory = new Configuration().configure("/resources/hibernate.cfg.xml")
				.addAnnotatedClass(ToDos.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<ToDos> theToDos = session.createQuery("from ToDos").list();
			session.getTransaction().commit();
			System.out.println(theToDos.toString());
			return theToDos;
		} finally {
			factory.close();
		}
	}
	
	/** method to query the list of ToDos from the database
	 * @return list data structure with ToDos
	 */
	public static List<ToDos> listSearchToDos(String searchMe) throws Exception {
		DateTimeFormatter fd =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<ToDos> theToDos = new ArrayList<ToDos>();
		SessionFactory factory = new Configuration().configure("/resources/hibernate.cfg.xml")
				.addAnnotatedClass(ToDos.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			//List<ToDos> theToDos = session.createQuery("from ToDos").list();
			List theResults  = session.createSQLQuery("Select * FROM todo_list WHERE todo_title = '" + searchMe + "'").list();
			session.getTransaction().commit();
			List<Object[]> rows = theResults;
			for (Object[] row : rows) {
				ToDos todoRow = new ToDos();
				todoRow.setToDoId(Integer.parseInt(row[0].toString()));
				todoRow.setCreatedDate(LocalDate.parse(row[1].toString(), fd));
				todoRow.setToDoTitle(row[2].toString());
				todoRow.setToDoDes(row[3].toString());
				todoRow.setToDoDue(LocalDate.parse(row[4].toString(), fd));
				theToDos.add(todoRow);
			}
			System.out.println(theToDos.toString());
			return theToDos;
		} catch (Exception e) { System.out.println(e);
		return theToDos;}
		
		finally {
			factory.close();
		}
	}

	/** method to delete the selected record from the database
	 * @param userChoice is the record number to be deleted
	 */
	public static void deleteToDo(int userChoice) {
		SessionFactory factory = new Configuration().configure("/resources/hibernate.cfg.xml")
				.addAnnotatedClass(ToDos.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.createQuery("delete from ToDos where ID = " + userChoice).executeUpdate();
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
		
	}

}
