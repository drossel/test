package de.carstendrossel.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@ModelAttribute("nameBean")
	public NameBean createNamesBean() {
		return new NameBean();
	}

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

	@RequestMapping(value = "/names", method = RequestMethod.GET)
	public void names(Model model) {
		model.addAttribute("names", NameDB.getNames());
	}

	@RequestMapping(value = "/names", method = RequestMethod.POST)
	public String processSubmit(NameBean nameBean, Model model) {
		NameDB.addName(nameBean.getNewName());
		return "redirect:/names";
	}

}