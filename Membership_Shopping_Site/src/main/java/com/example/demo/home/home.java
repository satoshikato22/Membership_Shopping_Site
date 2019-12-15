package com.example.demo.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class home {
	@GetMapping("/home")
	public String getHome() {

		return "home/HOME";
	}
	@PostMapping("/home")
	public String PostHome() {

	return "home/HOME";
}

}
