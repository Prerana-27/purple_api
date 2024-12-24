package org.jsp.purple_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.jsp.purple_api.dto.Purple;
import org.jsp.purple_api.repository.PurpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PurpleService {
	
	
	@Autowired
	PurpleRepository repository;

	public ResponseEntity<Object> savePurple(Purple purple) {
		repository.save(purple);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "item Added Success");
		map.put("data", purple);

		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> savePurples(List<Purple> purples) {
		repository.saveAll(purples);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", purples);

		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Object> fetchAllPurples() {
		List<Purple> list = repository.findAll();
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found");

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "items Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	
	public ResponseEntity<Object> fetchById(int id) {
		Optional<Purple> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No itemss Found with Id: "+id);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "itemss Found");
			map.put("data", optional.get());

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<Object> fetchByName(String name) {
		List<Purple> list = repository.findByName(name);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No itemss Found with Name :"+name);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "items Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<Object> fetchByPriceGreater(double price) {
		List<Purple> list = repository.findByPriceGreaterThanEqual(price);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No itemss Found Price Greater Than: "+price);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "itemss Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByStockBetween(int min, int max) {
		List<Purple> list = repository.findByStockBetween(min,max);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Pitems Found Stock Between: "+min+" and "+max);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "items Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	    
	
	
	
public ResponseEntity<Object> fetchByYearGreater(long year) {
		List<Purple> list = repository.findByYearGreaterThanEqual(year);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No itemss Found year manufactured after: "+year);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "itemss Found manufacured after :"+year);
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	

	
	

	
	
	
	public ResponseEntity<Object> deleteById(int id) {
		Optional<Purple> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No item Found with Id: "+id);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			repository.deleteById(id);
			map.put("message", " Delete Success");

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> updatePurple(Purple purple) {
		repository.save(purple);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", " Update Success");

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> updatePurple(int id, Purple purple) {
		Optional<Purple> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Product Found with Id: "+id);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			
			Purple existingPurple = optional.get();
			if(purple.getName()!=null)
				existingPurple.setName(purple.getName());
			if(purple.getDetail()!=null)
				existingPurple.setDetail(purple.getDetail());
			if(purple.getPrice()!=0)
				existingPurple.setPrice(purple.getPrice());
			if(purple.getStock()!=0)
				existingPurple.setStock(purple.getStock());
			
			repository.save(existingPurple);
			
			
			map.put("message", "Product Updated Success");

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	
	
	
}
