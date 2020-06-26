package test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import test.NotFoundException;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class indexController {
	
	@GetMapping("/")
	public String index() {
		int i = 9/0;
		return "index";
	}
	
	@GetMapping("/blog")
	public String blog() {

		return "blog";
	}
}
