package org.example.project1.home;

import java.security.Principal;

import org.example.project1.answer.Answer;
import org.example.project1.answer.AnswerForm;
import org.example.project1.question.Question;
import org.example.project1.user.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/main")
	public String main_home() {
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			return "redirect:/";
		}
		return "home";
	}
}
