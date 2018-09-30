package com.tiburcio.bicycles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiburcio.bicycles.entity.models.Bicycle;
import com.tiburcio.bicycles.entity.services.IBicycleService;

@RestController
public class BicycleController{
	
	@Autowired
	IBicycleService bicycleService;
	
	@GetMapping("/bicycles")
	public List<Bicycle> getAllBicycles(){
		return bicycleService.getAll();
	}
	
	@GetMapping("/bicycle/{id}")
	public Bicycle getOne(@PathVariable(value = "id") long id) {
		return bicycleService.get(id);
	}
	
	@PostMapping("/bicycle")
	public void add(Bicycle bicycle) {
		bicycleService.post(bicycle);
	}
	
	@PutMapping("/bicycle/{id}")
	public void update(Bicycle bicycle, @PathVariable(value = "id") long id) {
		bicycleService.put(bicycle, id);
	}
	
	@DeleteMapping("/bicycle/{id}")
	public void update(@PathVariable(value = "id") long id) {
		bicycleService.delete(id);
	}
}
