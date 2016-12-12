package com.jaitra.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaitra.dao.LeaveSummaryDao;
import com.jaitra.daoImpl.LeaveSummaryDaoImpl;
import com.jaitra.model.LeaveSummary;

@Path("leavesummary")

public class LeaveSummaryProvider {
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveSummary createLeaveSummary(LeaveSummary leaveSummary) {
		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
		LeaveSummary returnLeaveSummary = leaveSummaryDao.createLeaveSummary(leaveSummary);
		return returnLeaveSummary;
	}

	@POST
	@Path("read")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveSummary readLeaveSummary(LeaveSummary leaveSummary) {
		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
		LeaveSummary returnLeaveSummary = leaveSummaryDao.readLeaveSummary(leaveSummary);
		return returnLeaveSummary;
	}

	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveSummary updateLeaveSummary(LeaveSummary leaveSummary) {
		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
		LeaveSummary returnLeaveSummary = leaveSummaryDao.updateLeaveSummary(leaveSummary);
		return returnLeaveSummary;
	}

	@POST
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveSummary deleteLeaveSummary(LeaveSummary leaveSummary) {
		LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
		LeaveSummary returnLeaveSummary = leaveSummaryDao.deleteLeaveSummary(leaveSummary);
		return returnLeaveSummary;
	}
}
