package org.jsp.purple_api.repository;


import java.util.List;

import org.jsp.purple_api.dto.Purple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurpleRepository extends  JpaRepository<Purple, Integer> {

	List<Purple> findByName(String name);

	List<Purple> findByPriceGreaterThanEqual(double price);

	List<Purple> findByStockBetween(int min, int max);

	//List<Purple> findByYearGreaterThanEqual(int year);

	List<Purple> findByYearGreaterThanEqual(long year);



	

}
