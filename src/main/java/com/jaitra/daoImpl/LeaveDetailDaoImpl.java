package com.jaitra.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jaitra.dao.LeaveDeatilDao;
import com.jaitra.model.LeaveDetail;
import com.jaitra.model.Status;
import com.jaitra.utils.BeanCopy;
import com.jaitra.utils.DBUtil;

public class LeaveDetailDaoImpl implements LeaveDeatilDao {
	
	
	public LeaveDetail createLeaveDetail(LeaveDetail leaveDetail) {
		Session session = DBUtil.getSession();
		Status status = new Status();
		Transaction transaction = null;
		Integer leaveDetailid = null;

		try {
			transaction = session.beginTransaction();

			leaveDetailid = (Integer) session.save(leaveDetail);

			leaveDetail.setLeaveDetailId(leaveDetailid);
			status.setCode(0);
			status.setMessage("Successfully created");
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.closeSession(session);

		}
		leaveDetail.setStatus(status);

		return leaveDetail;
	}
	
	@Override
	public LeaveDetail updateLeaveDetail(LeaveDetail leaveDetail) {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();
		Status status = new Status();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			LeaveDetail leaveDetailId = (LeaveDetail) session.get(LeaveDetail.class, leaveDetail.getLeaveDetailId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(leaveDetailId, leaveDetail);
			session.update(leaveDetailId);
			status.setCode(0);
			status.setMessage("Successfully updated");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());		
		} finally {
			DBUtil.closeSession(session);
		}
		leaveDetail.setStatus(status);

		return leaveDetail;
	}
	
	
	@Override
	public LeaveDetail readLeaveDetail(LeaveDetail leaveDetail) {
		// TODO Auto-generated method stub
		
		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();
		
		try {
			transaction = session.beginTransaction();
			LeaveDetail leaveDetailId = (LeaveDetail) session.get(LeaveDetail.class, leaveDetail.getLeaveDetailId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(leaveDetail, leaveDetailId);
			status.setCode(0);
			status.setMessage("Successfully read");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}
		leaveDetail.setStatus(status);

		return leaveDetail;
	}
	
	@Override
	public LeaveDetail deleteLeaveDetail(LeaveDetail leaveDetail) {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();

		try {
			transaction = session.beginTransaction();
			LeaveDetail deletingLeaveDetail = (LeaveDetail) session.get(LeaveDetail.class, leaveDetail.getLeaveDetailId());
			session.delete(deletingLeaveDetail);
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
		leaveDetail.setStatus(status);

		return leaveDetail;
	}
	
	@Override
	public List<LeaveDetail> readAllDeatils() {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();
		
		Status status = new Status();
		Transaction transaction = null;
		List<LeaveDetail> leaveDetail = null;
		try {
			transaction = session.beginTransaction();

			leaveDetail = session.createQuery("from LeaveDetail").list();
			status.setCode(0);
			status.setMessage("Successfully read");

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}
		return leaveDetail;
	}

	
}



