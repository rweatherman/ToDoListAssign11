<%@page import="ToDoListJDBC.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/todocss.css">
<title>To Do List</title>

<!--  <script type="text/javascript">
          function sendFormData() {
            var toDoTitleValue = getToDoFromUser.elements['theToDoTitle'].value;
            var toDoDescValue = getToDoFromUser.elements['toDoDesc'].value;
            var dueDateValue = getToDoFromUser.elements['dueDate'].value;
            // Invoke the 'save' method of the 'Account' Java object.
            WebToDo.saveTheToDo(toDoTitleValue, toDoDescValue, dueDateValue);
          }
 </script>
 
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #f1f1f1;
 
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style> -->
</head>
<body>
<header>
  <h2>To Do List</h2>
</header>

<section>
  <nav>
    <ul>
      <li><a href="#">Enter a ToDo</a></li>
      <li><a href="#">List ToDos</a></li>
      <li><a href="#">Delete a ToDo</a></li>
    </ul>
  </nav>
  
  <article>
    <h2>Enter To Do:</h2>

	<div class="container">
	 
	
  <form action="ToDoServlet" method="POST">

  <div class="row">
    <div class="col-25">
      <label for="theToDoTitle">To Do Title:</label>
    </div>
    <div class="col-75">
      <input type="text" name="theToDoTitle" placeholder="Title of your To Do..." />
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="theToDoDesc">To Do Description</label>
    </div>
    <div class="col-75">
      <textarea name="theToDoDesc" placeholder="Description of your ToDo..." style="height:200px" >
      </textarea>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="theToDoDue">Due Date</label>
    </div>
    <div class="col-75">
      <input type="date" name="theToDoDue" placeholder="Due date for To Do..." />
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