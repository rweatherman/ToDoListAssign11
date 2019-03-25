package ToDoListJDBC;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
