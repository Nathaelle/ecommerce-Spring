<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<hr class="my-2">
	
	<div class="container-md mt-4">
		
		<h2>${ category.id != 0 ? "Modifier la" : "Ajouter une" } catégorie</h2>
		<form:form servletRelativeAction="/category/save" modelAttribute="category"
	acceptCharset="utf-8">
			<div class="mb-3">
		    	<label for="name" class="form-label">Nom</label>
		    	<form:input class="form-control" path="name"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="shortText" class="form-label">Description</label>
		    	<form:input class="form-control" path="shortText"/>
		  	</div>
		  	<c:if test="${ category.id != 0 }">
		  		<form:input type="hidden" path="id"/>
		  	</c:if>
		  	<button type="submit" class="btn btn-primary">${ category.id != 0 ? "Modifier" : "Ajouter" }</button>
		</form:form>
		
		
	</div>
	
	<div class="container-md mt-4">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Nom</th>
		      <th scope="col">Description</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:if test="${ category.id != 0 }">
				<tr>
			      <td colspan=3><a class="btn btn-outline-primary" href="admin">Ajouter une nouvelle catégorie</a></td>
			    </tr>
		  	</c:if>
		  <c:forEach items="${ categories }" var="cat">
		    <tr>
		      <td>${ cat.name }</td>
		      <td>${ cat.shortText }</td>
		      <td><a href="admin-cat-${ cat.id }">Modifier</a></td>
		    </tr>
		  </c:forEach>
		  </tbody>
		</table>
	</div>
	
	<hr class="my-2">
	
	<div class="container-md mt-4">
	<h2>Ajouter un article</h2>
		<form:form servletRelativeAction="/item/add" modelAttribute="item"
	acceptCharset="utf-8">
			<div class="mb-3">
		    	<label for="reference" class="form-label">Référence</label>
		    	<form:input class="form-control" path="reference"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="name" class="form-label">Nom de l'article</label>
		    	<form:input class="form-control" path="name"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="description" class="form-label">Nom</label>
		    	<form:input class="form-control" path="description"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="image" class="form-label">Image</label>
		    	<form:input class="form-control" path="image"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="price" class="form-label">Prix</label>
		    	<form:input class="form-control" path="price"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="ingredients" class="form-label">Ingrédients</label>
		    	<form:input class="form-control" path="ingredients"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="quantity" class="form-label">Quantité en stock</label>
		    	<form:input type="number" class="form-control" path="quantity"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="category" class="form-label">Catégorie</label>
		    	<form:select class="form-select" path="category">
				   <form:option value="NONE" label="--- Selectionner une catégorie ---"/>
				   <form:options items="${categories}" itemLabel="name" />
				</form:select>
		  	</div>
		  	<c:if test="${ category.id != 0}">
		  		<form:input type="hidden" path="id"/>
		  	</c:if>
			<button type="submit" class="btn btn-primary">${ category.id != 0 ? "Modifier" : "Ajouter" }</button>
		</form:form>
	</div>
	
</body>
</html>