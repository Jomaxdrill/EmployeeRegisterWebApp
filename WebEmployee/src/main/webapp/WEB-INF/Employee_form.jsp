<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Register Form</title>
<style type="text/css">
h1{
font-family: "Lucida Console", "Courier New", monospace;
}

</style>
</head>

<body>
<h1 align="center">Registro de Empleados</h1>
<div align="center">

<form action="<%=request.getContextPath() %>/register" method="post">
  <label for="fname">Nombres:</label>
  <input type="text" id="name" name="name"><br><br>
  <label for="lname">Apellidos:</label>
  <input type="text" id="surname" name="surname"><br><br>'
  <label for="document_type">Documento:</label>
   <select name="document_type" id="document_type">
    <option value="CC">CC</option>
    <option value="CE">CE</option>
    <option value="Pasaporte">Pasaporte</option>
    <option value="Otro">Otro</option>
  </select>
  <br><br>
  <label for="doc_number">Número de Documento:</label>
  <input type="text" id="doc_number" name="doc_number"><br><br>
  <label for="date_of_birth">Fecha de Nacimiento:</label>
  <input type="date" id="date_of_birth" name="date_of_birth"><br><br>
   <label for="date_company_work">Fecha de Vinculación a la Compañía :</label>
  <input type="date" id="date_company_work" name="date_company_work"><br><br>
  <label for="position">Cargo:</label>
  <input type="text" id="position" name="position"><br><br>
  <label for="salary">Salario:</label>
  <input type="number" id="salary" name="salary"><br><br>
  <input type="submit" value="Submit">
</form>
</div>



</body>
</html>
