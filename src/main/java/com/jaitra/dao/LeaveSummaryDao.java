package com.jaitra.dao;

import com.jaitra.model.LeaveSummary;
import com.jaitra.model.Status;

public interface LeaveSummaryDao {

	public LeaveSummary createLeaveSummary(LeaveSummary leaveSummary);
	public LeaveSummary updateLeaveSummary(LeaveSummary leaveSummary);
	public LeaveSummary readLeaveSummary(LeaveSummary leaveSummary);
	public LeaveSummary deleteLeaveSummary(LeaveSummary leaveSummary);
}
