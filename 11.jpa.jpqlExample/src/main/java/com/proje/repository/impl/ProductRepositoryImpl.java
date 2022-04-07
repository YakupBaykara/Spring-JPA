package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.proje.jpaFactory.JPAFactory;
import com.proje.jpaFactory.impl.JPAFactoryImpl;
import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.ProductDetails;
import com.proje.queries.ProductQueries;
import com.proje.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

	private JPAFactory jpaFactory =  new JPAFactoryImpl();
	private EntityManager manager = jpaFactory.getEntityManager();
	private EntityTransaction transaction = jpaFactory.getEntityTransaction();
	
	
	@Override
	public Product saveProduct(Product product) {
		
		this.transaction.begin();
		this.manager.persist(product);
		this.transaction.commit();
		return product;
	}

	@Override
	public Brand saveBrand(Brand brand) {
		
		this.transaction.begin();
		this.manager.persist(brand);
		this.transaction.commit();		
		return brand;
	}

	@Override
	public Category saveCategory(Category category) {
		
		this.transaction.begin();
		this.manager.persist(category);
		this.transaction.commit();		
		return category;
	}

	@Override
	public List<Product> findProducts() {

//		Query query = (Query) this.manager.createQuery(ProductQueries.findProducts);
//		List<Product> products = query.getResultList();
		
		TypedQuery<Product> typedQuery = this.manager.createQuery("SELECT p FROM Product p", Product.class);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}

	//	Bşalngıç değeri alır ve sonrasında kaç tane sonuç vereceği değei alır.	
	@Override
	public List<Product> findProductEntities(int firstResult, int maxResult) {

		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findProducts, Product.class);
		typedQuery.setFirstResult(firstResult);
		typedQuery.setMaxResults(maxResult);
		List<Product> products = typedQuery.getResultList();
		return products;
	}

	@Override
	public Product findProductById(int id) {
		
		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findProductById, Product.class);
		typedQuery.setParameter("productId", id); // peoductId SQL sorgusunda yer alan :productId değeri.
		Product product = typedQuery.getSingleResult();
		return product; 
		// 2. Yol: return typedQuery.getSingleResult();
	}

	@Override
	public List<ProductDetails> findProductDetails() {
		
		TypedQuery<ProductDetails> typedQuery = this.manager.createQuery(ProductQueries.findProductDetails, ProductDetails.class);
		List<ProductDetails> productDetails = typedQuery.getResultList();
		return productDetails;
	}

	@Override
	public ProductDetails findProductDetailsById(int id) {
		
		TypedQuery<ProductDetails> typedQuery = this.manager.createQuery(ProductQueries.findProductDetailById, ProductDetails.class);
		typedQuery.setParameter("productId", id);		
		return typedQuery.getSingleResult();
	}

	@Override
	public List<String> findProductNames() {
		
		TypedQuery<String> typedQuery = this.manager.createQuery(ProductQueries.findProductNames, String.class);
		List<String> productNames = typedQuery.getResultList();
		return productNames;
	}

	@Override
	public List<Object[]> findProductNameAndPrice() {

		Query query = this.manager.createQuery(ProductQueries.findProductNameAndPrice);
		@SuppressWarnings("unchecked")
		List<Object[]> productNameAndPrice = query.getResultList();
		return productNameAndPrice;
	}

	@Override
	public List<Product> findGreatPrice(Double unitPrice) {
		
		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findProductGreatPrice, Product.class);
		typedQuery.setParameter("unitPrice", unitPrice);
		
		List<Product> products = typedQuery.getResultList();
		return products;
	}

	@Override
	public List<Product> findGreatAndLessPrice(Double minUnitPrice, Double maxUnitPrice) {
		
		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findProductGreatAndLessPrice, Product.class);
		typedQuery.setParameter("minUnitPrice", minUnitPrice);
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);
		
		List<Product> products = typedQuery.getResultList();
		return products;
	}

	@Override
	public List<Product> findBetweenPrice(Double minUnitPrice, Double maxUnitPrice) {
		
		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findBetweenPrice, Product.class);
		typedQuery.setParameter("minUnitPrice", minUnitPrice);
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);
		
		List<Product> products = typedQuery.getResultList();
		return products;
	}
	
	@Override
	public List<Product> findLikeProductName(String productName) {
		
		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findLikeProductName, Product.class);
		typedQuery.setParameter("productName", "%" + productName + "%");
		
		List<Product> products = typedQuery.getResultList();
		return products;
	}

	@Override
	public List<Product> findInCategoryName(String categoryName1, String categoryName2) {

		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findInCategoryName, Product.class);
		typedQuery.setParameter("categoryName1", categoryName1);
		typedQuery.setParameter("categoryName2", categoryName2);
		
		List<Product> products = typedQuery.getResultList();
		return products;
	}

	@Override
	public List<Product> findAllProducts(int categoryId) {
		
		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findAllProducts, Product.class);
		typedQuery.setParameter("categoryId", categoryId);
		
		List<Product> products = typedQuery.getResultList();
		return products;
	}

	@Override
	public List<Object[]> findFunctionsPrice() {
		
		Query query = this.manager.createQuery(ProductQueries.findFunctionsPrice);
		@SuppressWarnings("unchecked")
		List<Object[]> functionPrice = query.getResultList();
		return functionPrice; 
	}

	@Override
	public List<Object[]> findGroupByCategory() {

		Query query = this.manager.createQuery(ProductQueries.findGroupByCategory);
		@SuppressWarnings("unchecked")
		List<Object[]> groupByCategory = query.getResultList();
		return groupByCategory; 
	}

	@Override
	public List<Object[]> findGroupByHavingCategory(Double unitPrice) {
		
		Query query = this.manager.createQuery(ProductQueries.findGroupByHavingCategory);
		query.setParameter("unitPrice", unitPrice);
		@SuppressWarnings("unchecked")
		List<Object[]> groupByHavingCategory = query.getResultList();
		return groupByHavingCategory; 
	}

	@Override
	public List<Product> findOrderByPrice() {
		
		TypedQuery<Product> typedQuery = this.manager.createQuery(ProductQueries.findOrderByPrice, Product.class);
		List<Product> products = typedQuery.getResultList();
		return products;
	}


}
