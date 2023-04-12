<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WEB APPLICATION</title>
</head>
<body>
<a href ="index.jsp"> add user</a>

<form action = "condition"  method = "post">
Gender :<input type ="radio" name = "r" value= "Male"/>Male
       <input type = "radio" name ="r"  value ="Female"/>Female <br/>
Employee Department:<select name ="dept"  >
              <option>null<option>HR<option>Manager<option>Sales<option>Developer</option></select><br/>
Employee Experience:<select name ="experience"  >
               <option>0<option>1<option>2<option>2.5<option>3<option>3.5<option>4<option>4.5<option>5<option>5.5<option>6<option>6<option>7<option>8<option>9<option>10</select><br/>
<input type = "submit" value = "search"/>

<table border ="1">
<thead>
<tr>
<td>ID</td>
<td>EmpName</td>
<td>EmpEmail</td>
<td>EmpGender</td>
<td>EmpDept</td>
<td>EmpExp</td>
</tr>
</thead>

<tbody>
<c:forEach items="${retrieve}"  var = "user">
<tr>
<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.email}</td>
<td>${user.gender}</td>
<td>${user.dept}</td>
<td>${user.exp}</td>
</tr>
</c:forEach>

</tbody>
</table>


</form>

</body>
</html>