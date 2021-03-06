package de.carstendrossel.test;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@Autowired
	private UpperCaser upperCaser;

	@ModelAttribute("upperFormBean")
	public UpperFormBean createUpperFormBean() {
		return new UpperFormBean();
	}

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

	@RequestMapping(value = "/upper-form", method = RequestMethod.GET)
	public void upperForm() {

	}

	@RequestMapping(value = "/upper-form", method = RequestMethod.POST)
	public void processSubmit(@Valid UpperFormBean upperFormBean, Model model) {
		upperFormBean.setUpperText(upperCaser.toUpperCase(upperFormBean
				.getText()));
	}
}