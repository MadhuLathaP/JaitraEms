package com.jaitra.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jaitra.dao.LeaveSummaryDao;
import com.jaitra.model.LeaveSummary;
import com.jaitra.model.Status;
import com.jaitra.utils.BeanCopy;
import com.jaitra.utils.DBUtil;

public class LeaveSummaryDaoImpl implements LeaveSummaryDao {

	public LeaveSummary createLeaveSummary(LeaveSummary leaveSummary) {
		Session session = DBUtil.getSession();

		Status status = new Status();

		Transaction transaction = null;
		Integer id = null;

		try {
			transaction = session.beginTransaction();

			id = (Integer) session.save(leaveSummary);

			leaveSummary.setId(id);
			status.setCode(0);
			status.setMessage("Successfully created");
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);

		}
		leaveSummary.setStatus(status);

		return leaveSummary;
	}

	@Override
	public LeaveSummary updateLeaveSummary(LeaveSummary leaveSummary) {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();
		Status status = new Status();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			LeaveSummary leaveSummaryId = (LeaveSummary) session.get(LeaveSummary.class,
					leaveSummary.getId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(leaveSummaryId, leaveSummary);
			session.update(leaveSummaryId);
			status.setCode(0);
			status.setMessage("Successfully updated");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}

		leaveSummary.setStatus(status);

		return leaveSummary;
	}

	@Override
	public LeaveSummary readLeaveSummary(LeaveSummary leaveSummary) {
		// TODO Auto-generated method stub

		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();

		try {
			transaction = session.beginTransaction();
			LeaveSummary leaveSummaryId = (LeaveSummary) session.get(LeaveSummary.class,
					leaveSummary.getId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(leaveSummary, leaveSummaryId);
			status.setCode(0);
			status.setMessage("Successfully read");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}
		leaveSummary.setStatus(status);

		return leaveSummary;
	}

	@Override
	public LeaveSummary deleteLeaveSummary(LeaveSummary leaveSummary) {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();
		Status status = new Status();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			LeaveSummary deletingLeaveSummary = (LeaveSummary) session.get(LeaveSummary.class, leaveSummary.getEmpId());
			session.delete(deletingLeaveSummary);
			status.setCode(0);
			status.setMessage("Successfully deleted");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}
		leaveSummary.setStatus(status);

		return leaveSummary;
	}

}
