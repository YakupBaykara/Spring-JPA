package com.proje.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Advertisement;
import com.proje.repository.AdvertisementRepository;

public class AdvertisementRepositoryImpl implements AdvertisementRepository{
	
	private EntityManager manager = jpaFactory.getEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	@Override
	public boolean save(final Advertisement advertisement) {

		try {
			this.transaction.begin();
			this.manager.persist(advertisement);
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
	public boolean update(final Advertisement advertisement) {
		
		try {
			this.transaction.begin();
			this.manager.merge(advertisement);
			this.manager.flush();  // Commit edilince tablo güncellenmiş olur.
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
	public boolean remove(final Advertisement advertisement) {
		
		try {
			if(this.manager.contains(advertisement)) {
				this.manager.remove(advertisement);
			}else {
				Advertisement deleteAdvertisement = this.finById(advertisement.getId());
				this.manager.remove(deleteAdvertisement);
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
	public Advertisement finById(final Integer id) {

		Advertisement advertisement = null;
		try {
			TypedQuery<Advertisement> query = this.manager.createNamedQuery("Advertisement.findById", Advertisement.class);
			query.setParameter("id", id);
			advertisement = query.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return advertisement;
	}

	@Override
	public List<Advertisement> findByUsername(final String username) {

		List<Advertisement> advertisements = null;
		try {
			TypedQuery<Advertisement> query = this.manager.createNamedQuery("Advertisement.findByUsername", Advertisement.class);
			query.setParameter("username", username);
			advertisements = query.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return advertisements;
	}

	@Override
	public List<Advertisement> findAll() {

		List<Advertisement> advertisements = null;
		try {
			TypedQuery<Advertisement> query = this.manager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
			advertisements = query.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return advertisements;
	}

	@Override
	public List<Advertisement> findSpecificRange(int fistResult, int maxResult) {

		List<Advertisement> advertisements = null;
		try {
			TypedQuery<Advertisement> query = this.manager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
			query.setParameter("fistResult", fistResult);
			query.setParameter("maxResult", maxResult);
			advertisements = query.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("Hata : " +e);
		}
		return advertisements;
	}

}
