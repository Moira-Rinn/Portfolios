package com.sacha.resourceNetwork.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.resourceNetwork.models.User;
import com.sacha.resourceNetwork.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepository;
	
//Register User / Hash Password
	public User registerUser(User user) {
		String hashedPass=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPass);
		return userRepository.save(user);
	}
//Find By ID
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
//Find By Email
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
//Authenticate User
    public boolean authenticateUser(String email, String password) {
        // Verify Email
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return false;
        } else {
            // Verify Password
            if(BCrypt.checkpw(password, user.getPassword())) return true;  
            else return false;
        }
    }
}
