package com.proje.queries;

public class ProductQueries {
	
	public static final String findProducts = "SELECT p FROM product p"; // "SELECT * FROM Product" ile aynı
	
	public static final String findProductById = "SELECT p FROM Product p WHERE p.id = :productId"; // :productId bizim göndereceğimiz değer
	
	public static final String findProductDetails = "SELECT new com.proje.model.ProductDetails(p.name, p.unitPrice, p.available, p.brand.name, p.category.name) FROM Product p";												
													
	public static final String findProductDetailById = "SELECT new com.proje.model.ProductDetails(p.name, p.unitPrice, p.available, p.brand.name, p.category.name) FROM Product p  WHERE p.id = :productId";
	
	public static final String findProductNames = "SELECT p.name FROM Product p";
	
	public static final String findProductNameAndPrice = "SELECT p.name, p.unitPrice FROM Product p";
	
	public static final String findProductGreatPrice = "SELECT p FROM Product p WHERE p.unitPrice > :unitPrice";
	
	public static final String findProductGreatAndLessPrice = "SELECT p FROM Product p WHERE p.unitPrice > :minUnitPrice AND p.unitPrice < :maxUnitPrice";
	
	public static final String findBetweenPrice = "SELECT p FROM Product p WHERE p.unitPrice BETWEEN :minUnitPrice AND :maxUnitPrice";
	
	public static final String findLikeProductName = "SELECT p FROM Product p WHERE p.name LIKE :productName";
	
	public static final String findInCategoryName = "SELECT p FROM Product p LEFT JOIN p.category c WHERE c.name IN (:categoryName1, :categoryName2)";

	public static final String findAllProducts = "SELECT p FROM Product p WHERE p.unitPrice > ALL(SELECT p2.unitPrice FROM Product p2 WHERE p2.category.id = :categoryId)";
	
	public static final String findFunctionsPrice = "SELECT AVG(p.unitPrice), SUM(p.unitPrice), MAX(p.unitPrice), MIN(p.unitPrice), COUNT(p) FROM Product p";
	
	public static final String findGroupByCategory = "SELECT p.category.name, AVG(p.unitPrice) FROM Product p GROUP BY p.category.name";
	
	public static final String findGroupByHavingCategory = "SELECT p.category.name, AVG(p.unitPrice) FROM Product p GROUP BY p.category.name HAVİNG AVG(p.unitPrice) > :unitPrice";
	
	public static final String findOrderByPrice = "SELECT p FROM Product p ORDER BY p.unitPrice DESC";
}
