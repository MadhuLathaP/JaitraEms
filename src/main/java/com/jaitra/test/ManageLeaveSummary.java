package com.jaitra.test;

import java.util.HashSet;
import java.util.Set;

import com.jaitra.dao.LeaveSummaryDao;
import com.jaitra.daoImpl.LeaveSummaryDaoImpl;
import com.jaitra.model.LeaveDetail;
import com.jaitra.model.LeaveSummary;

public class ManageLeaveSummary {

	public static void main(String[] args) {
	
		ManageLeaveSummary manageLeaveSummary = new ManageLeaveSummary();
		
		manageLeaveSummary.createLeaveSummary();
		//manageLeaveSummary.updateLeaveSummary();
		//manageLeaveSummary.readLeaveSummary();
		//manageLeaveSummary.deleteLeaveSummary();

	}



	private void createLeaveSummary() {
		// TODO Auto-generated method stub
		
		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
	
		Set<LeaveDetail> leaveSet = new HashSet<LeaveDetail>(); 
		
		LeaveSummary leaveSummary = new LeaveSummary();
		
		LeaveDetail leaveDetail = new LeaveDetail();
		
		leaveDetail.setLeaveType("Sick");
		leaveDetail.setFromDate("06-10-2016");
		leaveDetail.setToDate("09-10-2016");
		
		LeaveDetail leaveDetail1 = new LeaveDetail();

		leaveDetail1.setLeaveType("Casual");
		leaveDetail1.setFromDate("10-10-2016");
		leaveDetail1.setToDate("01-11-2016");	
		
		leaveSet.add(leaveDetail);
		leaveSet.add(leaveDetail1);

		
		leaveSummary.setCasualLeave(12);
		leaveSummary.setSickLeave(4);
		leaveSummary.setCasualLeaveUsed(3);
		leaveSummary.setSickLeaveUsed(1);
		leaveSummary.setTotalLeaveUsed(4);
		leaveSummary.setTotalLeave(15);
		leaveSummary.setLeaveDetail(leaveSet);
		
		leaveSummaryDao.createLeaveSummary(leaveSummary);
	}

	private void updateLeaveSummary() {
		// TODO Auto-generated method stub
		
		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
	
		LeaveSummary leaveSummary = new LeaveSummary();
				
		leaveSummary.setCasualLeave(8);
		leaveSummary.setSickLeave(4);
		leaveSummary.setCasualLeaveUsed(2);
		leaveSummary.setSickLeaveUsed(1);
		leaveSummary.setTotalLeaveUsed(3);
		leaveSummary.setTotalLeave(12);
		
		leaveSummary.setId(1);
		
		leaveSummaryDao.updateLeaveSummary(leaveSummary);
	}
	
	private void readLeaveSummary() {
		// TODO Auto-generated method stub

		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();

		LeaveSummary leaveSummary = new LeaveSummary();
		leaveSummary.setId(1);
		
		leaveSummary = leaveSummaryDao.readLeaveSummary(leaveSummary);
        System.out.println("Employee Id: " + leaveSummary.getEmpId()); 
        System.out.println("Casual Leave: " + leaveSummary.getCasualLeave()); 
        System.out.println("Sick Leave: " + leaveSummary.getSickLeave()); 
        System.out.println("Last CasualLeaveUsed: " + leaveSummary.getCasualLeaveUsed()); 
        System.out.println("SickLeaveUsed: " + leaveSummary.getSickLeaveUsed()); 
        System.out.println("TotalLeaveUsed: " + leaveSummary.getTotalLeaveUsed()); 
        System.out.println("TotalLeave: " + leaveSummary.getTotalLeave()); 
	}
	
	
	private void deleteLeaveSummary() {
		// TODO Auto-generated method stub

		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();

		LeaveSummary leaveSummary = new LeaveSummary();
		leaveSummary.setId(1);
		leaveSummaryDao.deleteLeaveSummary(leaveSummary);
	}
}
