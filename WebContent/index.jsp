<%@page import="ToDoListJDBC.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="css/todocss.css" />
	<title>To Do List</title>
	</head>
<body>
	<header>
  	<h2>To Do List</h2>
	</header>

<section>
  <nav>
    <ul>
      <li><a href="index.jsp">Enter a ToDo</a></li>
      <li><a href="ListToDos.jsp">List ToDos</a></li>
      <li><a href="SearchToDos.jsp">Search ToDos</a></li>
      <li><a href="DeleteToDos.jsp">Delete a ToDo</a></li>
    </ul>
  </nav>
  
  <article>
    <h2>Enter To Do:</h2>
	<div class="container">
	
<!-- Form to get ToDo from user -->
  <form action="ToDoServlet" method="POST">

  <div class="row">
    <div class="col-25">
      <label for="theToDoTitle">To Do Title:</label>
    </div>
    <div class="col-75">
      <input type="text" name="theToDoTitle"  placeholder="Title of your To Do..." required="required" maxlength="25" />
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="theToDoDesc">To Do Description</label>
    </div>
    <div class="col-75">
      <textarea name="theToDoDesc" placeholder="Description of your ToDo..." style="height:100px" required="required" maxlength="200" >
      </textarea>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="theToDoDue">Due Date</label>
    </div>
    <div class="col-75">
      <input type="date" name="theToDoDue" placeholder="Due date for To Do..." required="required" />
    </div>
  </div>
  <div class="row">
    <input type="submit" value="Submit"/>
  </div>
  </form>
</div>

</article>

</section>

<footer>
  <p>Copyright 2019 Michael Forman</p>
</footer>

</body>

</html>