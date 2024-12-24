package org.jsp.purple_api.controller;

import java.util.List;


import org.jsp.purple_api.dto.Purple;
import org.jsp.purple_api.service.PurpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;



@RestController
public class PurpleController {
	
	@Autowired
	PurpleService service;
	
	
	@Operation(summary = "Saving One Item")
	@PostMapping("/purples")
	public ResponseEntity<Object> savePurple(@RequestBody Purple purple){
		return service.savePurple(purple);
	}
	
	
	@Operation(summary = "Saving Multiple Items")
	@PostMapping("/purples/many")
	public ResponseEntity<Object> savePurples(@RequestBody List<Purple> purples){
		return service.savePurples(purples);
	}
	
	
	@Operation(summary = "Fetch all the items")
		@GetMapping("/purples")
		public ResponseEntity<Object> fetchAllPurples(){
			return service.fetchAllPurples();
		}
		
	@Operation(summary = "Fetch the items by id")
		@GetMapping("/purples/{id}")
		public ResponseEntity<Object> fetchById(@PathVariable int id){
			return service.fetchById(id);
		}
		
		//Fetch Product By Name
	@Operation(summary = "Fetch the items by name")
		@GetMapping("/purples/name/{name}")
		public ResponseEntity<Object> fetchByName(@PathVariable String name){
			return service.fetchByName(name);
		}
		
		//Fetch Products Price Greater Than
	@Operation(summary = "Fetch the items by cost")
		@GetMapping("/purples/price/greater/{price}")
		public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
			return service.fetchByPriceGreater(price);
		}
		
		//Fetch Products By Stock Between
	@Operation(summary = "Fetch the items between the cost")
		@GetMapping("/purples/stock/{min}/{max}")
		public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min,@PathVariable int max){
			return service.fetchByStockBetween(min,max);
		}
		
		//Fetch Products Price Greater Than
	@Operation(summary = "Fetch the items by year")
				@GetMapping("/purples/year/after/{year}")
				public ResponseEntity<Object> fetchByYearGreater(@PathVariable long year){
					return service.fetchByYearGreater(year);
				}
		
	
		
		
	@Operation(summary = "Delete the items by id")
		@DeleteMapping("/purples/{id}")
		public ResponseEntity<Object> deleteById(@PathVariable int id){
			return service.deleteById(id);
		}
		
		
	@Operation(summary = "Update the items  ")
	@PutMapping("/purples")
	public ResponseEntity<Object> updateRecord(@RequestBody Purple purple){
    	return service.updatePurple(purple);
	}

	
	
	@Operation(summary = "Update the items by id")
@PatchMapping("/purples/{id}")
public ResponseEntity<Object> updateRecord(@PathVariable int id,@RequestBody Purple purple){
	return service.updatePurple(id,purple);
	}
}

		

