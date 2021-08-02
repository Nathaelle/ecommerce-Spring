package com.ecommerce.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ecommerce.engine.entities.Category;
import com.ecommerce.engine.entities.Item;
import com.ecommerce.engine.repositories.CategoryRepository;

/**
 * Initialisation et affichage du template d'administration
 */
@Controller
public class AdminPanelDisplayController {
	
	@Autowired 
	private CategoryRepository repo;
	
	/**
	 * Affichage du template d'administration
	 * @param category Binding(liaison) du modèle Category avec le formulaire "catégorie"
	 * @param item Binding(liaison) du modèle Item avec le formulaire "catégorie"
	 * @return Nom de la vue (pour le ViewResolver)
	 */
	@GetMapping("/admin")
	public String showPanel(Model model, @ModelAttribute Category category, @ModelAttribute Item item) {
		
		List<Category> cats = repo.findAll();
		model.addAttribute("categories", cats);
		
		return "admin";
	}

}
