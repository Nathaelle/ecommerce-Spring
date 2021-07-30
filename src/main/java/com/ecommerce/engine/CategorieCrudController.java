package com.ecommerce.engine;

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
public class CategorieCrudController {
	
	@Autowired
	private CategoryRepository repo;
	
	@PostMapping("/category")
	public @ResponseBody String add(@ModelAttribute Category category, RedirectAttributes redatt) {
		
		repo.save(category);
		
		redatt.addAttribute("id", category.getId());
		
		return "redirect:/category-{id}";
	}

}
