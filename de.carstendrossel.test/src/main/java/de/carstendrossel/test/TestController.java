package de.carstendrossel.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {

	@Autowired
	UpperCaser upperCaser;

	@RequestMapping(value = "/")
	public String home() {
		return "test";
	}

	@RequestMapping(value = "/upper", method = RequestMethod.GET)
	public String upper(@RequestParam("input") String input, Model model) {

		String output = upperCaser.toUpperCase(input);

		model.addAttribute("output", output);
		return "upper";
	}
}