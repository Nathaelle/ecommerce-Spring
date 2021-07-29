package com.ecommerce.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public @ResponseBody String add(@ModelAttribute Item item) {
		
		repo.save(item);
		System.out.println(item);
	
		
		return "L'article a été inséré avec succès";
	}

}
