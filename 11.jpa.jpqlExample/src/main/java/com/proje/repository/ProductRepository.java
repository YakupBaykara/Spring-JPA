package com.proje.repository;

import java.util.List;

import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.ProductDetails;

public interface ProductRepository {

	Product saveProduct(Product product);
	
	Brand saveBrand (Brand brand);
	
	Category saveCategory(Category category);
	
	List<Product> findProducts();
	
	List<Product> findProductEntities(int firstResult, int maxResult);
	
	Product findProductById(int id);
	
	List<ProductDetails> findProductDetails();
	
	ProductDetails findProductDetailsById(int id);
	
	List<String> findProductNames();
	
	List<Object[]> findProductNameAndPrice();
	
	List<Product> findGreatPrice(Double unitPrice);
	
	List<Product> findGreatAndLessPrice(Double minUnitPrice, Double maxUnitPrice);
	
	List<Product> findBetweenPrice(Double minUnitPrice, Double maxUnitPrice);
	
	List<Product> findLikeProductName(String productName);
	
	List<Product> findInCategoryName(String categoryName1, String categoryName2);
	
	// VERİLEN KATEGORİNİN VERİLEN DEĞERDEN BÜYÜK OLANINI GETİR
	
	List<Product> findAllProducts(int categoryId);
	
	List<Object[]> findFunctionsPrice();
	
	List<Object[]> findGroupByCategory();
	
	List<Object[]> findGroupByHavingCategory(Double unitPrice);
	
	List<Product> findOrderByPrice();
	
}
