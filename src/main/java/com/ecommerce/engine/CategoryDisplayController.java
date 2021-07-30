package com.ecommerce.engine;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.engine.entities.Category;
import com.ecommerce.engine.repositories.CategoryRepository;

@Controller
public class CategoryDisplayController {
	
	@Autowired 
	private CategoryRepository repo;
	
	@GetMapping("/category-{id}")
	public String showCategory(Model model, @PathVariable int id) {
		
		List<Category> cats = repo.findAll();
		model.addAttribute("categories", cats);
		
		Category category = (repo.existsById(id))? repo.getById(id) : null;
		model.addAttribute("category", category);
		
		return "bycat";
		
	}

}
