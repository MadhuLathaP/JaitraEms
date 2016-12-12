package com.jaitra.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaitra.dao.LeaveDeatilDao;
import com.jaitra.daoImpl.LeaveDetailDaoImpl;
import com.jaitra.model.LeaveDetail;

@Path("leavedetail")
public class LeaveDetailProvider {

	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetail createLeaveDetail(LeaveDetail leaveDetail) {
		LeaveDeatilDao leaveDeatilDao = new LeaveDetailDaoImpl();
		LeaveDetail returnLeaveDetail = leaveDeatilDao.createLeaveDetail(leaveDetail);
		System.out.println("Employee create");
		return returnLeaveDetail;
	}

	@POST
	@Path("read")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetail readLeaveDetail(LeaveDetail leaveDetail) {
		LeaveDeatilDao leaveDetailDao = new LeaveDetailDaoImpl();
		LeaveDetail returnLeaveDetail = leaveDetailDao.readLeaveDetail(leaveDetail);
		System.out.println("Employee read");
		return returnLeaveDetail;
	}

	@GET
	@Path("readAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LeaveDetail> readAllLeaveDetail() {
		LeaveDeatilDao leaveDetailDao = new LeaveDetailDaoImpl();
		List<LeaveDetail> returnLeaveDetail = leaveDetailDao.readAllDeatils();
		System.out.println("Employee Read All");
		return returnLeaveDetail;
	}

	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetail updateLeaveDetail(LeaveDetail leaveDetail) {
		LeaveDeatilDao leaveDetailDao = new LeaveDetailDaoImpl();
		LeaveDetail returnLeaveDetail = leaveDetailDao.updateLeaveDetail(leaveDetail);
		System.out.println("Employee update");
		return returnLeaveDetail;
	}

	@POST
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetail deleteLeaveDetail(LeaveDetail leaveDetail) {
		LeaveDeatilDao leaveDetailDao = new LeaveDetailDaoImpl();
		LeaveDetail returnLeaveDetail = leaveDetailDao.deleteLeaveDetail(leaveDetail);
		System.out.println("Employee delete");
		return returnLeaveDetail;
	}

}
