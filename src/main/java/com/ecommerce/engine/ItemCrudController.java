package com.ecommerce.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.engine.entities.Item;
import com.ecommerce.engine.repositories.ItemRepository;

/**
 * Controller CRUD (= Create, Read, Update, Delete)
 * De l'objet de gestion métier (Entité) "Item" (article)
 */
@Controller
@RequestMapping("/item")
public class ItemCrudController {
	
	
	@Autowired 
	private ItemRepository repo;
	
	/**
	 * Récupère les données du formulaire dans l'objet category
	 * @param category Binding formulaire, propriétés de l'objet category auto-hydratée
	 * @return La catégorie au format JSON
	 */
	@PostMapping("/add")
	public @ResponseBody Item add(@ModelAttribute Item item) {
		
		repo.save(item);
		
		// Pour éviter les erreurs de stringification
		item.setCategory(null);
	
		return item;
	}

}
