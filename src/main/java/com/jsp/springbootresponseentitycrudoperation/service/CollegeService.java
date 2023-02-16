package com.jsp.springbootresponseentitycrudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.springbootresponseentitycrudoperation.dao.CollegeDao;
import com.jsp.springbootresponseentitycrudoperation.dto.College;
import com.jsp.springbootresponseentitycrudoperation.dto.ResponseStructure;
import com.jsp.springbootresponseentitycrudoperation.exception.IdNotFoundException;

@Service
public class CollegeService {

	@Autowired
	CollegeDao collegeDao;

	@Autowired
	ResponseStructure<College> responseStructure;

	// insertMethod For College
	public ResponseStructure<College> saveCollege(College college) {

		College college2 = collegeDao.saveCollege(college);

		if (college2 != null) {

			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Successfully Data is inserted");
			responseStructure.setData(college2);
		}

		return responseStructure;
	}

	// getById for College
	public ResponseStructure<College> getById(int id) throws IdNotFoundException {

		College college = collegeDao.getById(id);

		if (college != null) {

			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Data is present");
			responseStructure.setData(college);
			return responseStructure;

		} else {

			throw new IdNotFoundException("id is not present");

		}
	}

	// getById NativeQuery
	public College getByIdNative(int id) {

		return collegeDao.getByIdNative(id);
	}

	// getByNameQuery
	public College getByCollegeName(String name) {

		return collegeDao.getByCollegeName(name);

	}

	// getByPinCode
	public College getByCollegePinCode(int id) {
		return collegeDao.getByCollegePinCode(id);
	}

	// getByPinCode
	public List<College> getByCollegeAllPinCode(int id) {

		return collegeDao.getByCollegeAllPinCode(id);
	}

	// getAllData
	public List<College> getAllCollege() {

		return collegeDao.getAllCollege();
	}

	// getCollegeDataWithSorting
	public List<College> getAllCollegeDataSort(String collegePinCode) {
		return collegeDao.getAllCollegeDataSort(collegePinCode);
	}

	// how to paginate the record
	public Page<College> findCollegeWithPagination(int offset, int pageSize) {

		Page<College> college = collegeDao.findCollegeWithPagination(offset, pageSize);

		return college;
	}

	// how to paginate the record and sort it
	public Page<College> findCollegeWithPaginationWithSort(int offset, int pageSize, String field) {

		Page<College> colleges = collegeDao.findCollegeWithPaginationWithSort(offset,pageSize,field);

		return colleges;
	}

}
