<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/addquestion">Add Question</a> 

  <table>
  <thead>
  	<tr>
  	<td>
  		Questions
  	</td>
  	
  	<td>
  		Actions
  	</td>
  	  
  	</tr>
  </thead>
  <tbody>
  	<c:forEach var = "questions" items="${Questions}">
  	<tr>
  	<td>
  		${questions.question}
  	</td>
  	
  	<td>
  		<a href="UpdateQuestionServlet/?id=${questions.questionId}">Update</a> |
  		<a href="DeleteQuestionServlet/?id=${questions.questionId}">Delete</a>
  	</td>
  	  
  	</tr>
  	
  	</c:forEach>
  	
  
  </tbody>
  </table>
</body>
</html>