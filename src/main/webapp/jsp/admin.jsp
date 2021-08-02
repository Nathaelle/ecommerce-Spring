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
	
	<hr class="my-2">
	
	<div class="container-md mt-4">
		<h2>Ajouter une catégorie</h2>
		<form:form servletRelativeAction="/category" modelAttribute="category"
	acceptCharset="utf-8">
			<div class="mb-3">
		    	<label for="name" class="form-label">Nom</label>
		    	<form:input class="form-control" path="name"/>
		  	</div>
		  	<div class="mb-3">
		    	<label for="shortText" class="form-label">Description</label>
		    	<form:input class="form-control" path="shortText"/>
		  	</div>
		  	<button type="submit" class="btn btn-primary">Envoyer</button>
		</form:form>
	</div>
	
	<hr class="my-2">
	
	<div class="container-md mt-4">
	<h2>Ajouter un article</h2>
		<form:form servletRelativeAction="/item" modelAttribute="item"
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
			<button type="submit" class="btn btn-primary">Envoyer</button>
		</form:form>
	</div>
	
</body>
</html>