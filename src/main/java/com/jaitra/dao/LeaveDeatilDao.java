package com.jaitra.dao;

import java.util.List;

import com.jaitra.model.LeaveDetail;

public interface LeaveDeatilDao {

	public LeaveDetail createLeaveDetail(LeaveDetail leaveDetail);
	public LeaveDetail updateLeaveDetail(LeaveDetail leaveDetail);
	public LeaveDetail readLeaveDetail(LeaveDetail leaveDetail);
	public LeaveDetail deleteLeaveDetail(LeaveDetail leaveDetail);
	public List<LeaveDetail> readAllDeatils();
}
