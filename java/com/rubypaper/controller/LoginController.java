package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.domain.User;
import com.rubypaper.service.UserService;



@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@GetMapping("/login")
	public String login() {
		return"login";
	}
	@PostMapping("/login")
	public String login(User user,Model model) {
		User findUser = userService.getUser(user);
		
		if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
			model.addAttribute("member", findUser);
			return "forward:getBoardList";
		}
		return "redirect:login";
	}
}
