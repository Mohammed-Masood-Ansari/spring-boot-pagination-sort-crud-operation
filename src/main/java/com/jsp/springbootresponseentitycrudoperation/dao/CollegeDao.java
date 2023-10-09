package com.jsp.springbootresponseentitycrudoperation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.jsp.springbootresponseentitycrudoperation.dto.College;
import com.jsp.springbootresponseentitycrudoperation.repository.CollegeRepository;

@Repository
public class CollegeDao {

	@Autowired
	CollegeRepository collegeRepository;

	// insertMethod For College
	public College saveCollege(College college) {
		return collegeRepository.save(college);
	}

	// getById for College
	public College getById(int id) {

		Optional<College> optional = collegeRepository.findById(id);

		if (optional.isPresent()) {

			return optional.get();

		}

		return null;
	}

	// getById NativeQuery
	public College getByIdNative(int id) {
		return collegeRepository.getById(id);
	}

	// getByNameQuery
	public College getByCollegeName(String name) {
		return collegeRepository.getByCollegeName(name);
	}

	// getByPinCode
	public College getByCollegePinCode(int id) {

		Optional<College> optional = Optional.ofNullable(collegeRepository.getByCollegePinCode(id));
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	//getCollegeDetailsBy pin
	public List<College> getByCollegeAllPinCode(int id) {

		return collegeRepository.getByCollegeAllPinCode(id);
	}
	
	//getAllData
	public List<College> getAllCollege(){
		return collegeRepository.getAllCollege();
	}
	
	//getCollegeDataWithSorting
	public List<College> getAllCollegeDataSort(String collegePinCode){
		return collegeRepository.findAll(Sort.by(Sort.Direction.ASC,collegePinCode));
	}
	
	//how to paginate the record
	//where offset is pagenumber which start from 0 and pagesize is number of data
	public Page<College>  findCollegeWithPagination(int offset,int pageSize){
		
		Page<College> college=collegeRepository.findAll(PageRequest.of(offset,pageSize));
		
		return college;
	}
	
	//how to paginate the record and sort it
	public Page<College> findCollegeWithPaginationWithSort(int offset,int pageSize,String field){
		
		Page<College> colleges = collegeRepository.findAll(PageRequest.of(pageSize, pageSize).withSort(Sort.by(field)));
		
		return colleges;
	}
	
}
