package com.ecommerce.engine;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.engine.entities.Category;
import com.ecommerce.engine.repositories.CategoryRepository;

/**
 * Controller CRUD (= Create, Read, Update, Delete)
 * De l'objet de gestion métier (Entité) "Category"
 */
@Controller
public class CategoryCrudController {
	
	@Autowired
	private CategoryRepository repo;
	
	/**
	 * Récupère les données du formulaire dans l'objet category
	 * @param category Binding formulaire, propriétés de l'objet category auto-hydratée
	 * @return La catégorie au format JSON
	 */
	@PostMapping("/category")
	public @ResponseBody Category add(@ModelAttribute Category category) {
		
		repo.save(category);

		return category;
	}

}
