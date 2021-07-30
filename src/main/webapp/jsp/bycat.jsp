<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>${ cat }</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css">
</head>
<body>

	<%@ include file="menu.jsp" %>
	
	<c:choose>
		<c:when test="${category != null}">
		<div class="p-5 mb-4 bg-light rounded-3 jumbotron">
	      	<div class="container-fluid py-5">
		        <h1 class="display-5 fw-bold">${ category.name }</h1>
		        <p class="col-md-8 fs-4">${ category.shortText }</p>
		     </div>
	    </div>
	
		<div class="p-4 container-fluid mt-4 m-y-4">
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="home">Home</a></li>
			    <li class="breadcrumb-item active" aria-current="page">${ fn:toUpperCase(fn:substring(category.name, 0, 1)) }${ fn:toLowerCase(fn:substring(category.name, 1, fn:length(category.name))) }</li>
			  </ol> 
			</nav>
			
			<div class="row">
				<c:forEach items="${ cat.items }" var="item">
				<div class="col-4">
					<div class="card">
						<img class="card-img-top" src="${ pageContext.request.contextPath }/img/${ item.image }" alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${ item.name }</h5>
							<p class="card-text">${ item.description }</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
					</div>
				</div>
				</c:forEach>
				
			</div>
		</div>
		</c:when>
		<c:otherwise>
			<div class="p-5 mb-4 bg-light rounded-3 jumbotron">
		      	<div class="container-fluid py-5">
			        <h1 class="display-5 fw-bold">404 - Not found</h1>
			        <p class="col-md-8 fs-4">La catégorie demandée n'a pas été trouvée.</p>
			     </div>
		    </div>
			
		</c:otherwise>
	</c:choose>

	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	
</body>
</html>