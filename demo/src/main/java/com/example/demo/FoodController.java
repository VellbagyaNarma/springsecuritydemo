package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class FoodController {
	@Autowired
	private FoodService service;
	

	@Autowired
	private FoodRepository repo;

	@RequestMapping("/")
	public String viewAll(Model model)
	{
		System.out.println("hai");
		List<Food> listfood=service.listall();
		for(Food listfood1:listfood)
		{
		
		System.out.println(listfood1.getFoodcolor());
		
		System.out.println(listfood1.getFoodname());
		}
		model.addAttribute("listfood",listfood);
		return "index";
	}
	@RequestMapping("/new")
	public String shownewproduct(Model model)
	{
		Food Food=new Food();
		model.addAttribute("Food",Food);
		return "new_product";
		
	}
	@PostMapping("/save")
	
	public  String saveproduct(@ModelAttribute("Food")Food Food,Model model)
	{
		service.save(Food); 
		System.out.println("saveproduct");
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
	public ModelAndView editproduct(@PathVariable("id") Long id)
	{
		System.out.println("edit controller");
		Food product =service.get(id);
		ModelAndView mav=new ModelAndView("edit_product");
		Food food=service.get(id);
		mav.addObject("product", product);
		return mav;
		
		
		
	}
	@GetMapping("/delete/{id}")
	public String deleteproduct(@PathVariable("id") Long id)
	{
		System.out.println("delete controller");
		service.delete(id);
		return "redirect:/";
	}
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "redirect:/login";
	}
		

}
