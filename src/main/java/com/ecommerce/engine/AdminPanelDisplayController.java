package com.ecommerce.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.engine.entities.Category;
import com.ecommerce.engine.entities.Item;
import com.ecommerce.engine.entities.User;
import com.ecommerce.engine.repositories.CategoryRepository;
import com.ecommerce.engine.repositories.ItemRepository;

/**
 * Initialisation et affichage du template d'administration
 */
@Controller
public class AdminPanelDisplayController {
	
	@Autowired 
	private CategoryRepository catRepo;
	
	@Autowired 
	private ItemRepository itRepo;
	
	/**
	 * Affichage du template d'administration
	 * @param category Binding(liaison) du modèle Category avec le formulaire "catégorie"
	 * @param item Binding(liaison) du modèle Item avec le formulaire "catégorie"
	 * @return Nom de la vue (pour le ViewResolver)
	 */
	@GetMapping({"/admin", "/admin-cat-{idcat}", "/admin-it-{idit}", "/admin-user-{iduser}"})
	public String showPanel(Model model, @ModelAttribute Category category, @ModelAttribute User user, @ModelAttribute Item item, @PathVariable(required=false) Integer idcat, @PathVariable(required=false) Integer idit) {
		
		List<Category> cats = catRepo.findAll();
		model.addAttribute("categories", cats);
		
		// S'il y a une catégorie sélectionnée, on la récupère pour construire le formulaire à partir de celle-ci
		// J'ajoute également un attribut pour modifier mon template en fonction du formulaire à afficher (ajout ou modification)
		if(idcat != null) {
			Category cat = catRepo.getById(idcat);
			category.setId(cat.getId());
			category.setName(cat.getName());
			category.setShortText(cat.getShortText());
			model.addAttribute("catMod", true);
		}
		
		// S'il y a un item sélectionné, on le récupère pour construire le formulaire à partir de celui-ci
		// J'ajoute là encore un attribut pour modifier mon template en fonction du formulaire à afficher (ajout ou modification)
		if(idit != null) {
			Item it = itRepo.getById(idit);
			item.setId(it.getId());
			item.setReference(it.getReference());
			item.setName(it.getName());
			item.setDescription(it.getDescription());
			item.setImage(it.getImage());
			item.setPrice(it.getPrice());
			item.setIngredients(it.getIngredients());
			item.setQuantity(it.getQuantity());
			item.setCategory(it.getCategory());
			model.addAttribute("itMod", true);
		}
		
		return "admin";
	}

}
