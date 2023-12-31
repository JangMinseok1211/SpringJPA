package com.rubypaper.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.User;
import com.rubypaper.persistence.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public User getUser(User user) {
		Optional<User> findUser = userRepository.findById(user.getId());
		if(findUser.isEmpty()) {
			return null;
		}
		return findUser.get();
	}

}
