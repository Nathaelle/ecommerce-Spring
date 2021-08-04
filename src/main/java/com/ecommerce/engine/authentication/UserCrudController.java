package com.ecommerce.engine.authentication;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.engine.authentication.exceptions.UserAlreadyExistException;
import com.ecommerce.engine.entities.User;
import com.ecommerce.engine.repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserCrudController {
	
	@Autowired
    private UserRepository repository;
	
	@Autowired 
	private PasswordEncoder encoder;
    
	@PostMapping("/register")
    public @ResponseBody User register(@ModelAttribute User user) throws UserAlreadyExistException {
        
    	if (emailExists(user.getEmail())) {
            throw new UserAlreadyExistException("Il y a déjà un compte avec l'adresse email suivante: "
             + user.getEmail());
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");

        return repository.save(user);
    }

    private boolean emailExists(String email) {
    	
    	Optional<User> user = repository.findByEmail(email);
        return user.isPresent();
    }

}
