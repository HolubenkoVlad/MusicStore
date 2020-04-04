package sk.musicstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sk.musicstore.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ItemController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String catalog(Model model) {
		model.addAttribute("product", productService.findAll());
        return "catalog";
    }
}
