package com.ecommerce.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.engine.entities.Item;
import com.ecommerce.engine.repositories.ItemRepository;

@Controller
public class ItemCrudController {
	
	@Autowired 
	private ItemRepository repo;
	
	@GetMapping("/item")
	public String showForm(@ModelAttribute Item item) {
		
		
		return "item";
	}
	
	@PostMapping("/item")
	public String add(@ModelAttribute Item item, RedirectAttributes redatt) {
		
		repo.save(item);
	
		
		return "redirect:/item";
	}

}
