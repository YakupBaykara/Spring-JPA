package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import com.proje.model.User;
import com.proje.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{
	
	private EntityManager manager = factory.getEntityManager();
	private EntityTransaction transaction = manager.getTransaction();
	
	@Override
	public boolean save(final User user) {
	
		try {
			this.transaction.begin();
			this.manager.persist(user);
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			System.out.println("Hata : " +e);
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
	public boolean update(final User user) {
		
		try {
			this.transaction.begin();
			this.manager.merge(user);
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			System.out.println("Hata : " +e);
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
	public boolean remove(final User user) {
		
		try {
			if(this.manager.contains(user))
				this.manager.remove(user);
			else {
				User deleteUser = this.findById(user.getId());
				this.manager.remove(deleteUser);				
			//	this.manager.remove(this.findById(user.getId()));
			}
			
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
	public User findById(final Integer id) {
		
		User user = null;
		try {
			TypedQuery<User> query = this.manager.createNamedQuery("User.findById", User.class);
			query.setParameter("id", id);
			user = query.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return user;
	}

	@Override
	public User findByUsername(final String username) {
		
		User user = null;
		try {
			TypedQuery<User> query = this.manager.createNamedQuery("User.findByUsername", User.class);
			query.setParameter("username", username);
			user = query.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return user;
	}

	@Override
	public User findWithUserDetailByUsername(final String username) {
		
		User user = null;
		try {
			TypedQuery<User> query = this.manager.createNamedQuery("User.findWithUserDetailByUsername", User.class);
			query.setParameter("username", username);
			user = query.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		
		List<User> users = null;
		try {
			TypedQuery<User> query = this.manager.createNamedQuery("User.findAllUsers", User.class);
			users = query.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return users;
	}

	@Override
	public int findCount() {
		
		Integer count = null;
		try {
			TypedQuery<Integer> query = this.manager.createNamedQuery("User.findCount", Integer.class);
			count = query.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return count.intValue();
	}

	@Override
	public User findWithUserInfoByUsername(final String username) {
		
		User user = null;
		try {
			TypedQuery<User> query = this.manager.createNamedQuery("User.findWithUserInfoByUsername", User.class);
			query.setParameter("username", username);
			user = query.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return user;
	}

}
