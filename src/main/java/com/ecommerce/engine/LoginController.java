package com.ecommerce.engine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		
		if(request.getHeader("Referer") != null && !request.getHeader("Referer").matches("/login$")) {
			HttpSession session = request.getSession();
			session.setAttribute("referer", request.getHeader("Referer"));
		}
		
		return "login";
	}
	
	
}
