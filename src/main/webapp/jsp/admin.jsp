<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Panneau d'administration</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<%@ include file="menu.jsp" %>

	<h1>Panneau d'administration</h1>

	<h2>Ajouter une catégorie</h2>
	<form:form servletRelativeAction="/category" modelAttribute="category"
acceptCharset="utf-8">
		<p><label for="name">Nom : </label><form:input path="name"/></p>
		<p><label for="shortText">Description : </label><form:input path="shortText"/></p> 
		<button type="submit">Envoyer</button>
	</form:form>
	
	<h2>Ajouter un article</h2>
	<form:form servletRelativeAction="/item" modelAttribute="item"
acceptCharset="utf-8">
		<p><label for="reference">Réference : </label><form:input path="reference"/></p>
		<p><label for="name">Nom de l'article : </label><form:input path="name"/></p> 
		<p><label for="description">Description : </label><form:input path="description"/></p>
		<p><label for="image">Image : </label><form:input path="image"/></p> 
		<p><label for="price">Prix : </label><form:input path="price"/></p>
		<p><label for="ingredients">Ingrédients : </label><form:input path="ingredients"/></p> 
		<p><label for="name">Quantité : </label><form:input path="quantity"/></p>
		<p><label for="category">Catégorie : </label><form:input path="category"/></p> 	
		<button type="submit">Envoyer</button>
	</form:form>
	
</body>
</html>