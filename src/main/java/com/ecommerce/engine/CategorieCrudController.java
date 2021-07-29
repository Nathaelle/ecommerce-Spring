package com.ecommerce.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.engine.entities.Category;
import com.ecommerce.engine.repositories.CategoryRepository;

@Controller
public class CategorieCrudController {
	
	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/category")
	public String showForm(@ModelAttribute Category category) {
		
		return "cat";
	}
	
	@PostMapping("/category")
	public @ResponseBody String add(@ModelAttribute Category category) {
		
		System.out.println(category);
		repo.save(category);
		System.out.println(category);
		
		return "La catégorie a été insérée";
	}

}
