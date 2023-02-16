package com.jsp.springbootresponseentitycrudoperation.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jsp.springbootresponseentitycrudoperation.SpringBootResponseEntityCrudOperationApplication;
import com.jsp.springbootresponseentitycrudoperation.dto.College;
import com.jsp.springbootresponseentitycrudoperation.repository.CollegeRepository;

import jakarta.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SpringBootResponseEntityCrudOperationApplication.class)
public class EmployeeRepositoryTest {

	@Autowired
	CollegeRepository collegeRepository;

	public College getCollege() {

		College college = new College();
		college.setCollegeId(100);
		college.setCollegeName("HKBK");
		college.setCollegePinCode(3456);
		college.setCollegeAddress("Govindpura-Bangalore");
		return college;
	}

	@Test
	public void testSave() {

		College college = getCollege();

		collegeRepository.save(college);
		College college2 = collegeRepository.getById(college.getCollegeId());
		assertEquals(college.getCollegeId(), college2.getCollegeId());
	}

	@Test
	public void testDeleteById() {
		
		College college = getCollege();
		
		collegeRepository.save(college);
		
		collegeRepository.deleteById(college.getCollegeId());
		
		List<College> colleges = new ArrayList<College>();
		
		collegeRepository.findAll().forEach(e->colleges.add(e));
		
		assertEquals(colleges.size(),0);
	}
}
