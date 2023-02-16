package com.jsp.springbootresponseentitycrudoperation.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

//Named...Query...
@NamedQuery(name = "College.getByCollegeAllPinCode",query = "FROM College Where collegePinCode = ?1")
@NamedQuery(name = "College.getByCollegePinCode", query = "From College Where collegePinCode = ?1")
@Entity
public class College {

	@Column(name = "collegeid")
	@Id
	private int collegeId;
	@Column(name = "collegename")
	private String collegeName;
	@Column(name = "collegeaddress")
	private String collegeAddress;
	@Column(name = "collegepincode")
	private int collegePinCode;

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public int getCollegePinCode() {
		return collegePinCode;
	}

	public void setCollegePinCode(int collegePinCode) {
		this.collegePinCode = collegePinCode;
	}
}
