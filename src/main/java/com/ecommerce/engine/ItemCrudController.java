package com.ecommerce.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.engine.entities.Item;
import com.ecommerce.engine.repositories.ItemRepository;

/**
 * Controller CRUD (= Create, Read, Update, Delete)
 * De l'objet de gestion métier (Entité) "Item" (article)
 */
@Controller
public class ItemCrudController {
	
	@Autowired 
	private ItemRepository repo;
	
	
	@PostMapping("/item")
	public String add(@ModelAttribute Item item, RedirectAttributes redatt) {
		
		repo.save(item);
	
		
		return "redirect:/item";
	}

}
