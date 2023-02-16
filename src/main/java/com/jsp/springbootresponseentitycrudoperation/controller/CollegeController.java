package com.jsp.springbootresponseentitycrudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springbootresponseentitycrudoperation.dto.College;
import com.jsp.springbootresponseentitycrudoperation.dto.ResponseStructure;
import com.jsp.springbootresponseentitycrudoperation.exception.IdNotFoundException;
import com.jsp.springbootresponseentitycrudoperation.service.CollegeService;

import io.swagger.models.Path;

@RestController
public class CollegeController {

	@Autowired
	CollegeService collegeService;

	@PostMapping("/saveCollege")
	// insertMethod For College
	public ResponseStructure<College> saveCollege(@RequestBody College college) {

		return collegeService.saveCollege(college);
	}

	@GetMapping("/getById/{id}")
	// getById for College
	public ResponseStructure<College> getById(@PathVariable int id) throws IdNotFoundException {

		ResponseStructure<College> structure = collegeService.getById(id);

		return structure;
	}

	@GetMapping("getByIdNative/{id}")
	// getById NativeQuery
	public College getByIdNative(@PathVariable int id) {

		return collegeService.getByIdNative(id);
	}

	@GetMapping("/getByName/{name}")
	// getByNameQuery
	public College getByCollegeName(@PathVariable String name) {
		return collegeService.getByCollegeName(name);
	}

	// getByPinCode
	@GetMapping("/getByPinCode/id/{id}")
	public College getByCollegePinCode(@PathVariable("id") int id) {
		return collegeService.getByCollegePinCode(id);
	}

	@GetMapping("/getByCollegeAllPincode/id/{id}")
	// getByPinCode
	public List<College> getByCollegeAllPinCode(@PathVariable int id) {
		return collegeService.getByCollegeAllPinCode(id);
	}

	@GetMapping("/getAllCollegeData")
	// getAllData
	public List<College> getAllCollege() {

		return collegeService.getAllCollege();
	}

	@GetMapping("/getAllCollegeDataSort/{collegePinCode}")
	// getCollegeDataWithSorting
	public List<College> getAllCollegeDataSort(@PathVariable String collegePinCode) {
		return collegeService.getAllCollegeDataSort(collegePinCode);
	}

	@GetMapping("/findCollegeWithPagination/{offset}/{pageSize}")
	// how to paginate the record
	public ResponseStructure<Page<College>> findCollegeWithPagination(@PathVariable int offset,
			@PathVariable int pageSize) {

		ResponseStructure<Page<College>> responseStructure = new ResponseStructure<>();

		Page<College> colleges = collegeService.findCollegeWithPagination(offset, pageSize);

		responseStructure.setMessage("College Data");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(colleges);

		return responseStructure;
	}

	@GetMapping("/findCollegeWithPaginationWithSort/{offset}/{pageSize}/{field}")
	// how to paginate the record and sort it
	public ResponseStructure<Page<College>> findCollegeWithPaginationWithSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {

		ResponseStructure<Page<College>> responseStructure = new ResponseStructure<>();
		
		Page<College> colleges = collegeService.findCollegeWithPaginationWithSort(offset, pageSize, field);

		responseStructure.setMessage("College Data");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(colleges);
		
		return responseStructure;
	}
}
