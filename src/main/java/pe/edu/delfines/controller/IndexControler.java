package pe.edu.delfines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControler {

	@GetMapping
	public String index() {
		return "index";
	}
	
}
