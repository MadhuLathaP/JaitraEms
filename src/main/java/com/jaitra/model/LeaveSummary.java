package com.jaitra.model;

import java.util.Set;

public class LeaveSummary extends JaitraBaseModel {

	private Integer empId;

	private Integer id;

	private Integer casualLeave;

	private Integer sickLeave;

	private Integer sickLeaveUsed;

	private Integer casualLeaveUsed;

	private Integer totalLeaveUsed;

	private Integer totalLeave;

	private Set<LeaveDetail> leaveDetail;



	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCasualLeave() {
		return casualLeave;
	}

	public void setCasualLeave(Integer casualLeave) {
		this.casualLeave = casualLeave;
	}

	public Integer getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Integer sickLeave) {
		this.sickLeave = sickLeave;
	}

	public Integer getSickLeaveUsed() {
		return sickLeaveUsed;
	}

	public void setSickLeaveUsed(Integer sickLeaveUsed) {
		this.sickLeaveUsed = sickLeaveUsed;
	}

	public Integer getCasualLeaveUsed() {
		return casualLeaveUsed;
	}

	public void setCasualLeaveUsed(Integer casualLeaveUsed) {
		this.casualLeaveUsed = casualLeaveUsed;
	}

	public Integer getTotalLeaveUsed() {
		return totalLeaveUsed;
	}

	public void setTotalLeaveUsed(Integer totalLeaveUsed) {
		this.totalLeaveUsed = totalLeaveUsed;
	}

	public Integer getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(Integer totalLeave) {
		this.totalLeave = totalLeave;
	}

	public Set<LeaveDetail> getLeaveDetail() {
		return leaveDetail;
	}

	public void setLeaveDetail(Set<LeaveDetail> leaveDetail) {
		this.leaveDetail = leaveDetail;
	}

	
	
}
