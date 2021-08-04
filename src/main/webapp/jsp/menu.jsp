<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
	    	<a class="navbar-brand" href="#">Navbar</a>
	    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	        	<span class="navbar-toggler-icon"></span>
	    	</button>
    		<div class="collapse navbar-collapse" id="navbarSupportedContent">
      			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
        			<li class="nav-item">
          				<a class="nav-link active" aria-current="page" href="#">Accueil</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="#">Tous les produits</a>
        			</li>
        			<li class="nav-item dropdown">
          				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            				Catégories de produits
          				</a>
          				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
          					<c:forEach items="${ categories }" var="cat">
            					<li><a class="dropdown-item" href='category-${ cat.id }'>${ cat.name }</a></li>
            				</c:forEach>
            			</ul>
        			</li>
        			<sec:authorize access="isAuthenticated()">
  						<li class="nav-item">
          					<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Mes commandes</a>
        				</li>
					</sec:authorize>
        			
      			</ul>
      			
      			
      			<sec:authorize access="!isAuthenticated()">
  					<a class="btn btn-outline-success" href="login">Connexion</a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				<form action="logout" method="POST">
					<sec:csrfInput />
					<button type="submit" class="btn btn-outline-success">Déconnexion</button>
				</form>
				</sec:authorize>
      			
      			
      			<p class="nav-item mt-3">
     				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           				Voir le panier
         			</a>
        			
           		</p>
        			
      			
    		</div>
  		</div>
	</nav>