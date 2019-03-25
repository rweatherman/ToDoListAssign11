package ToDoListJDBC;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for ToDoList
 * Unchanged from previous assignments
 * @author Michael Forman Software Development II Professor Shaban
 */

@Entity
@Table(name = "todo_list")

public class ToDos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int toDoId;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "todo_title")
	private String toDoTitle;

	@Column(name = "todo_des")
	private String toDoDes;

	@Column(name = "due_date")
	private LocalDate toDoDue;

	public ToDos() {

	}

	/**
	 * @param createDate  Date To Do created
	 * @param title       Name of To Do
	 * @param description Description of To Do
	 * @param dueDate     Date to do is to be done
	 */
	public ToDos(LocalDate createDate, String title, String description, LocalDate dueDate) {
		this.setCreatedDate(createDate);
		this.setToDoTitle(title);
		this.setToDoDes(description);
		this.setToDoDue(dueDate);
	}

	/**
	 * Default getters and setters follow.
	 */
	public int getToDoId() {
		return toDoId;
	}

	public void setToDoId(int toDoId) {
		this.toDoId = toDoId;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public String getToDoTitle() {
		return toDoTitle;
	}

	public String getToDoDes() {
		return toDoDes;
	}

	public LocalDate getToDoDue() {
		return toDoDue;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public void setToDoTitle(String toDoTitle) {
		this.toDoTitle = toDoTitle;
	}

	public void setToDoDes(String toDoDes) {
		this.toDoDes = toDoDes;
	}

	public void setToDoDue(LocalDate toDoDue) {
		this.toDoDue = toDoDue;
	}

	@Override
	public String toString() {
		return "<tr><td width=>"+createdDate+"</td><td>" + toDoTitle + "</td><td>" + toDoDes + "</td><td>"
				+ toDoDue + "</td></tr>";
	}

}// end class
