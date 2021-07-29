package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {		
		System.out.println(">>> authenticate: inicio ");
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			System.out.println(">>> authenticate: no try  " + username);
			
			return userRepository.findByEmail(username);
		}
		catch(Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
	public void validadeSelfOrAdmin(Long userId) {
		System.out.println(">>> validadeSelfOrAdmin, userId:" + userId);
		User user = authenticated();
		System.out.println("<<< authenticated");
		if(!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")) {
			System.out.println(">>> validadeSelfOrAdmin: " + user.getId() );
			throw new ForbiddenException("Access denied");	
		}
	}
	
}
