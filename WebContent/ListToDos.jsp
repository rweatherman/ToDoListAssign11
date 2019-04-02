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
    <!--   <li><a href="SearchToDos.jsp">Search ToDos</a></li> -->
      <li><a href="DeleteToDos.jsp">Delete a ToDo</a></li>
    </ul>
  </nav>
 
  <article>
    <h2>List of ToDos:</h2>

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
        asyncRequest.open('GET', 'ListToDoServlet', true);    //   /Test is url to Servlet!
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
    var data = document.getElementById("data");         //  text is an id of a 
    data.innerHTML = asyncRequest.responseText;         //  div in HTML document
    }
}

window.addEventListener("load", start(), false);
</script>

<!--  This div accepts the table from the script and outputs it in the right section of the page -->
<div id="data"></div>
	
</article>
</section>

<footer>
  <p>Copyright 2019 Michael Forman</p>
</footer>

</body>

</html>