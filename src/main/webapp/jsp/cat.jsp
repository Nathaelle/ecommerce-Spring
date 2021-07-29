<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Ajouter une catégorie</h1>
	<form:form servletRelativeAction="/category" modelAttribute="category"
acceptCharset="utf-8">
		<p><label for="name">Nom : </label><form:input path="name"/></p>
		<p><label for="shortText">Description : </label><form:input path="shortText"/></p> 
		<button type="submit">Envoyer</button>
	</form:form>

</body>
</html>