package com.ecommerce.engine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ecommerce.engine.entities.Category;
import com.ecommerce.engine.entities.Item;

/**
 * Initialisation et affichage du template d'administration
 */
@Controller
public class AdminPanelDisplayController {
	
	/**
	 * Affichage du template d'administration
	 * @param category Binding(liaison) du modèle Category avec le formulaire "catégorie"
	 * @param item Binding(liaison) du modèle Item avec le formulaire "catégorie"
	 * @return Nom de la vue (pour le ViewResolver)
	 */
	@GetMapping("/admin")
	public String showPanel(@ModelAttribute Category category, @ModelAttribute Item item) {
		
		return "admin";
	}

}
