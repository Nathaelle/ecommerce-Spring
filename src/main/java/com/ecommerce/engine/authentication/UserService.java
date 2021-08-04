package com.ecommerce.engine.authentication;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.engine.entities.User;
import com.ecommerce.engine.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private final PasswordEncoder encoder = new BCryptPasswordEncoder();
	
    private final UserRepository userRepository;
    
//    @Autowired
//    private PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        return user;
    }
    
    public boolean checkPassword(String rawPassword, String hash) {
		
    	return encoder.matches(rawPassword, hash);
    }

}
