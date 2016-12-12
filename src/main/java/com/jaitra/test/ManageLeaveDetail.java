package com.jaitra.test;

import java.util.List;

import com.jaitra.dao.LeaveDeatilDao;
import com.jaitra.daoImpl.LeaveDetailDaoImpl;
import com.jaitra.model.LeaveDetail;
import com.jaitra.utils.DBUtil;

public class ManageLeaveDetail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManageLeaveDetail manageLeaveDetail = new ManageLeaveDetail();

		//manageLeaveDetail.createLeaveDetail();
		//manageLeaveDetail.updateLeaveDetail();
		//manageLeaveDetail.readLeaveDetail();
		// manageLeaveDetail.deleteLeaveDetail();
		manageLeaveDetail.readAllLeaveDetail();
		DBUtil.getFactory().close(); 

	}

	public void createLeaveDetail() {
		// TODO Auto-generated method stub

		LeaveDeatilDao leaveDeatilDao = new LeaveDetailDaoImpl();

		LeaveDetail leaveDetail = new LeaveDetail();

		leaveDetail.setLeaveType("Sick");
		leaveDetail.setFromDate("02-10-2016");
		leaveDetail.setToDate("04-10-2016");
		leaveDetail.setNumberOfDays(2);
		leaveDetail.setReason("dsfdc");
		
		leaveDeatilDao.createLeaveDetail(leaveDetail);
	}

	public void updateLeaveDetail() {
		// TODO Auto-generated method stub

		LeaveDeatilDao leaveDeatilDao = new LeaveDetailDaoImpl();

		LeaveDetail leaveDetail = new LeaveDetail();

		leaveDetail.setLeaveType("casual");
		leaveDetail.setFromDate("02-11-2016");
		leaveDetail.setToDate("06-11-2016");

		leaveDetail.setLeaveDetailId(2);

		leaveDeatilDao.updateLeaveDetail(leaveDetail);
	}

	public void readLeaveDetail() {
		// TODO Auto-generated method stub

		LeaveDeatilDao leaveDeatilDao = new LeaveDetailDaoImpl();

		LeaveDetail leaveDetail = new LeaveDetail();

		leaveDetail.setLeaveDetailId(1);

		leaveDetail = leaveDeatilDao.readLeaveDetail(leaveDetail);

		System.out.println("Leave Type: " + leaveDetail.getLeaveType());
		System.out.println("From Date: " + leaveDetail.getFromDate());
		System.out.println("To Date: " + leaveDetail.getToDate());
	}

	public void readAllLeaveDetail() {
		// TODO Auto-generated method stub

		LeaveDeatilDao leaveDeatilDao = new LeaveDetailDaoImpl();


		List<LeaveDetail> dL = leaveDeatilDao.readAllDeatils();
		System.out.println(dL);

		for (LeaveDetail e:dL) {
			System.out.println("Leave Type: " + e.getLeaveType());
			System.out.println("From Date: " + e.getFromDate());
			System.out.println("To Date: " + e.getToDate());
		}
	}

	public void deleteLeaveDetail() {
		// TODO Auto-generated method stub

		LeaveDeatilDao leaveDeatilDao = new LeaveDetailDaoImpl();

		LeaveDetail leaveDetail = new LeaveDetail();

		leaveDetail.setLeaveDetailId(1);

		leaveDeatilDao.deleteLeaveDetail(leaveDetail);
	}

}
