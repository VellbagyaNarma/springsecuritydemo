package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FoodService {
	@Autowired
	private FoodRepository repo;
	
	public List<Food> listall()
	{
		System.out.println("service");
		
		return repo.findAll();
	}
	public void save(Food food)
	{
		repo.save(food);
	}
	public Food get(Long id)
	{
		return repo.findById(id).get();
	}
	public void delete(Long id)
	{
		repo.deleteById(id);
	}


}
