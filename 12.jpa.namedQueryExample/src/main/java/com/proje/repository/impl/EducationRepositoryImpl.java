package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Education;
import com.proje.repository.EducationRepository;

public class EducationRepositoryImpl implements EducationRepository{
	
	private EntityManager manager = factory.getEntityManager();
	private EntityTransaction transaction = manager.getTransaction();
	
	@Override
	public boolean save(final Education education) {
		
		try {
			this.transaction.begin();
			this.manager.persist(education);
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
	public boolean update(final Education education) {
		
		try {
			this.transaction.begin();
			this.manager.merge(education);
			this.manager.flush();
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
	public boolean remove(final Education education) {
		
		try {
			if(this.manager.contains(education)) {
				this.manager.remove(education);
			}else {
				Education deleteEducation = this.findById(education.getId());
				this.manager.remove(deleteEducation);
			}
			
		} catch (RuntimeException e) {
			System.out.println("Hata : " +e);
		}
		return true;
	}

	@Override
	public Education findById(final Integer id) {
		
		Education education = null;
		try {
			TypedQuery<Education> query = this.manager.createNamedQuery("Education.finById", Education.class);
			query.setParameter("id", id);
			education = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		
		return education;
	}

	@Override
	public List<Education> findAll() {
		
		List<Education> educations = null;
		try {
			TypedQuery<Education> query = this.manager.createNamedQuery("Education.findEducations", Education.class);
			educations = query.getResultList();
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return educations;
	}

	@Override
	public Education findWithAdvertisementById(final Integer id) {
		
		Education education = null;
		try {
			TypedQuery<Education> query = this.manager.createNamedQuery("Education.findWithAdvertisementById", Education.class);
			education = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return education;
	}

}
