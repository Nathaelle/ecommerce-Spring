package com.ecommerce.engine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.engine.entities.Category;

@Controller
public class CategorieCrudController {
	
	@GetMapping("/category")
	public String showForm(@ModelAttribute Category category) {
		
		return "cat";
	}
	
	@PostMapping("/category")
	public String add(@ModelAttribute Category category) {
		
		return "cat";
	}

}
