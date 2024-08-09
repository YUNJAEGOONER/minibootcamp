package org.example.project1.home;

import org.example.project1.question.Question;
import org.example.project1.question.QuestionService;
import org.example.project1.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
	private final UserService userService;
	private final QuestionService questionService;

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/main")
	public String main_home(Model model) {
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			return "redirect:/";
		}
		Page<Question> hotList = questionService.getTop5HotList();
		model.addAttribute("questions", hotList);
		return "calendar";
	}
}
