<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action = "insert" method = "post">
Employee Name :<input type = "text" name = "name"/><br/>
Employee Email :<input type = "text" name = "email"/><br/>
Gender :<input type ="radio" name = "r" value= "Male"/>Male
       <input type = "radio" name ="r"  value ="Female"/>Female <br/>
Employee Department:<select name ="dept"  >
              <option>HR<option>Manager<option>Sales<option>Developer</option></select><br/>
Employee Experience:<select name ="exp"  >
               <option>1<option>2<option>2.5<option>3<option>3.5<option>4<option>4.5<option>5<option>5.5<option>6<option>6<option>7<option>8<option>9<option>10</select><br/>
<input type = "submit" value = "submit"/>

<a href ="userretrieval"> view details</a>
</form>


</body>
</html>