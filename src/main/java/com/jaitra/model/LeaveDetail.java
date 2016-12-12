package com.jaitra.model;

public class LeaveDetail extends JaitraBaseModel{

	private int leaveDetailId;
	
	private String leaveType;
	
	private String fromDate;
	
	private String toDate;
	
	private int numberOfDays;
	
	private String reason;
	

	public int getLeaveDetailId() {
		return leaveDetailId;
	}

	public void setLeaveDetailId(int leaveDetailId) {
		this.leaveDetailId = leaveDetailId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
