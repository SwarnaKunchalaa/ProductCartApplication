package com.tcs.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String homePage(Model model) {
		List<Product> products = productService.getDetails();
		model.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/new")
	public String addproduct(Model model) {
		model.addAttribute("product", new Product());
		return "new_product";
	}
	
	@RequestMapping("/save")
	public String saveData(Product product) {
		productService.saveProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		
		productService.deletePro(id);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String editProduct(@PathVariable long id, Model model) {
		Product product = productService.editPro(id);
		model.addAttribute("product",product);
		return "edit_form";
	}
	
	

}
