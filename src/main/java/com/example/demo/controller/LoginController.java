package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.LoginForm.LoginForm;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;

@Controller

public class LoginController {

	private static final String LOGIN_ID = "user";
	private static final String PASSWORD = "pwd";

	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model, LoginForm form) {
		var isCorrectUserAuth = form.getLoginId().equals(LOGIN_ID) && form.getPassWord().equals(PASSWORD);
		if (isCorrectUserAuth) {
			return "redirect:/menu";
		} else {
			model.addAttribute("errMsg", "ログイン情報が違います");
			return "login";
		}

	}
}
