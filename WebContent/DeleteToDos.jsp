<%@page import="ToDoListJDBC.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
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
      <li><a href="DeleteToDos.jsp">Delete a ToDo</a></li>
    </ul>
  </nav>
  
  <article>
    <h2>Delete a To Do:</h2>

<!--  script below was found on Stack Overflow. It uses error checking to make sure
      the servlet is responding before sending the request for the servlet to build
      the list of ToDos, which is returned as object "data" -->
<script>
	var asyncRequest;    
function start(){
    try
    {
        asyncRequest = new XMLHttpRequest();
        asyncRequest.addEventListener("readystatechange", stateChange, false);
        asyncRequest.open('GET', 'DeleteToDoServlet', true);    //   /Test is url to Servlet!
        asyncRequest.send(null);
    }
    catch(exception)
   {
    alert("Request failed");
   }
}

function stateChange(){
if(asyncRequest.readyState == 4 && asyncRequest.status == 200)
    {
    var data = document.getElementById("data");   
     
    data.innerHTML = asyncRequest.responseText;        
    }
}
window.addEventListener("load", start(), false);
</script>

<!-- This establishes the returned dynamically generated table as a form
	 Note: the above script and this form use the same servlet. The script calls the "GET"
	 method, while the form calls the "POST" method -->
<form action="DeleteToDoServlet" method="POST">

<!-- Dynamically generated table of ToDos so user can use radio button to select the ToDo to be deleted. -->
<div id="data"></div>

</form>
</article>
</section>

<footer>
  <p>Copyright 2019 Michael Forman</p>
</footer>

</body>

</html>