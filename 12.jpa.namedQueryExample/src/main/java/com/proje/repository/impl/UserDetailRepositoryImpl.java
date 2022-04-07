package com.proje.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.UserDetail;
import com.proje.repository.UserDetailRepository;

public class UserDetailRepositoryImpl implements UserDetailRepository{
	
	private EntityManager manager = factory.getEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	@Override
	public boolean save(final UserDetail userDetail) {
		
		try {
			this.transaction.begin();
			this.manager.persist(userDetail);
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			System.out.println("Hata : " + e);
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("Hata : " +e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean update(final UserDetail userDetail) {
		
		try {
			this.transaction.begin();
			this.manager.merge(userDetail);
			this.manager.flush();
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			System.out.println("Hata : " + e);
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("Hata : " +e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean removeUser(final UserDetail userDetail) {
		
		try {
			if(this.manager.contains(userDetail)) {
				this.manager.remove(userDetail);
			}else {
				UserDetail deleteUserDetail = this.findById(userDetail.getId());
				this.manager.remove(deleteUserDetail);
			}
				
		} catch (RuntimeException e) {
			 try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("Hata : " +e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public UserDetail findById(final Integer id) {

		UserDetail userDetail = null;
		try {
			TypedQuery<UserDetail> query = this.manager.createNamedQuery("UserDetail.findById", UserDetail.class);
			query.setParameter("id", id);
			userDetail = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return userDetail;
	}

	@Override
	public UserDetail findByUsername(final String username) {
		
		UserDetail userDetail = null;
		try {
			TypedQuery<UserDetail> query = this.manager.createNamedQuery("UserDetail.findByUsername", UserDetail.class);
			query.setParameter("username", username);
			userDetail = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return userDetail;
	}
	
	@Override
	public UserDetail findWithAddressByUsername(final String username) {
		
		UserDetail userDetail = null;
		try {
			TypedQuery<UserDetail> query = this.manager.createNamedQuery("UserDetail.findWithAddressByUsername", UserDetail.class);
			query.setParameter("username", username);
			userDetail = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return userDetail;
	}

	@Override
	public UserDetail findWithAdvertisementsByUsername(String username) {

		UserDetail userDetail = null;
		try {
			TypedQuery<UserDetail> query = this.manager.createNamedQuery("UserDetail.findWithAdvertisementsByUsername", UserDetail.class);
			query.setParameter("username", username);
			userDetail = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return userDetail;
	}

}
