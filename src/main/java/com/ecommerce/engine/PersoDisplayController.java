package com.ecommerce.engine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersoDisplayController {
	
	@GetMapping("/perso")
	public String showPerso() {
		
		return "perso";
	}

}
