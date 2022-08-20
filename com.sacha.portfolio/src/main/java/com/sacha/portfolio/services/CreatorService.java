//package com.sacha.portfolio.services;
//
//import java.util.Optional;
//
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sacha.portfolio.models.Creator;
//import com.sacha.portfolio.repositories.CreatorRepo;
//
//@Service
//public class CreatorService {
//	@Autowired
//	private CreatorRepo creatorRepository;
//	
////Register User / Hash Password
//	public Creator registerCreator(Creator creator) {
//		String hashedPass=BCrypt.hashpw(creator.getPassword(), BCrypt.gensalt());
//		creator.setPassword(hashedPass);
//		return creatorRepository.save(creator);
//	}
////Find By ID
//	public Optional<Creator> findById(Long id) {
//		return creatorRepository.findById(id);
//	}
////Find By Email
//	public Creator findByEmail(String email) {
//		return creatorRepository.findByEmail(email);
//	}
////Authenticate User
//    public boolean authenticateUser(String email, String password) {
//        // Verify Email
//        Creator creator = creatorRepository.findByEmail(email);
//        if(creator == null) {
//            return false;
//        } else {
//            // Verify Password
//            if(BCrypt.checkpw(password, creator.getPassword())) return true;  
//            else return false;
//        }
//    }
//}
