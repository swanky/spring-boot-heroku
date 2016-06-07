package io.github.swanky;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	private ProductRepository repository;

	public HomeController(ProductRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		List<Product> products = repository.findAll();
		model.addAttribute("products", products);
		model.addAttribute("insertProduct", new Product());
		return "home";
	}

	@RequestMapping(path = "/home", method = RequestMethod.POST)
	public String insertData(ModelMap model, @ModelAttribute("insertProduct") @Valid Product product,
			BindingResult result) {
		if (!result.hasErrors()) {
			repository.save(product);
		}
		return home(model);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}

}
