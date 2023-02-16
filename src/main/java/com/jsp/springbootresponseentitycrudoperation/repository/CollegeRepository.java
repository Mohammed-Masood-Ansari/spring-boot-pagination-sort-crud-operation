package com.jsp.springbootresponseentitycrudoperation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springbootresponseentitycrudoperation.dto.College;

public interface CollegeRepository extends JpaRepository<College, Integer> {

	public College getById(int id);
	public College getByCollegeName(String name);
	
	College getByCollegePinCode(int id);
	
	List<College> getByCollegeAllPinCode(int id);
	
	@Query(value = "Select * From college",nativeQuery = true)
	public List<College> getAllCollege();
}
