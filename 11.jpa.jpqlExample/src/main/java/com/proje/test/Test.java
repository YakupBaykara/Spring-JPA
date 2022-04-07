package com.proje.test;

import java.util.Date;
import java.util.List;

import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.ProductDetails;
import com.proje.repository.ProductRepository;
import com.proje.repository.impl.ProductRepositoryImpl;

public class Test {

	private static ProductRepository productRepository = new ProductRepositoryImpl();

	public static void main(String[] args) {

//		insertData(); // Persist işlemi yapıldıktan sonra gerek kalmadı.

		
//		SELECT p FROM product p
/*		List<Product> products = productRepository.findProducts();
		for (Product product : products) {
			System.out.println(product);
		}
		// products.forEach(System.out::println); // 2.Yol

	} */

//		SELECT p FROM Product p WHERE p.id = :productId
/*		Product product = productRepository.findProductById(5);
		System.out.println(product); */
		
//		SELECT new com.proje.model.ProductDetails.java(p.name, p.unitPrice, p.available, p.brand.name, p.category.name) FROM Product p				
/*		List<ProductDetails> productDetails = productRepository.findProductDetails();
		productDetails.forEach(System.out::println); */
		
//		SELECT new com.proje.model.ProductDetails.java(p.name, p.unitPrice, p.available, b.name, c.name) FROM Product p WHERE p.id = :productId
/*		ProductDetails productDetails = productRepository.findProductDetailsById(3);
		System.out.println(productDetails); */
		
//		SELECT p.name FROM Product p
/*		List<String> productNames = productRepository.findProductNames();
		productNames.forEach(System.out::println); */
		
//		SELECT p.name p.unitPrice FROM Product p
/*		List<Object[]> list = productRepository.findProductNameAndPrice();
		for(Object[] objects : list) {
			System.out.println(objects[0] + " - " + objects[0]);
		}*/
		
//		SELECT p FROM Product p WHERE p.unitPrice > :unitPrice
/*		List<Product> products = productRepository.findGreatPrice(2700.0);
		products.forEach(System.out::println);*/
		
//		SELECT p FROM Product p WHERE p.unitPrice > :minUnitPrice AND p.unitPrice < :maxUnitPrice
/*		List<Product> products = productRepository.findGreatAndLessPrice(2500.0, 3200.0);
		products.forEach(System.out::println); */
		
//		SELECT p FROM Product p WHERE p.unitPrice BETWEEN :minUnitPrice AND :maxUnitPrice
/*		List<Product> products = productRepository.findBetweenPrice(2500.0, 3200.0);
		products.forEach(System.out::println); */
		
//		SELECT p FROM Product p WHERE p.name LIKE :productName
/*		List<Product> products = productRepository.findLikeProductName("sus");
		products.forEach(System.out::println); */

//		SELECT p FROM Product p LEFT JOIN p.category c WHERE c.name = :categoryName
//		SELECT p FROM Product p LEFT JOIN p.category c WHERE c.name IN (:categoryName1, :categoryName2)
/*		List<Product> products = productRepository.findInCategoryName("Telefon", "Bilgisayar");
		products.forEach(System.out::println); */
		
//		SELECT p FROM Product p WHERE p.unitPrice > ALL(SELECT p2.unitPrice FROM Product p2 WHERE p2.category.id = :categoryId)
// 		categoryId ye göre o kategorideki fiyatlardan daha yüksek (en yükseğinden daha yüksek) olan tüm ürünleri getir.
/*		List<Product> products = productRepository.findAllProducts(2);
		products.forEach(System.out::println); */
		
//		SELECT AVG(p.unitPrice), SUM(p.unitPrice), MAX(p.unitPrice), MIN(p.unitPrice), COUNT(p) FROM Product p
/*		List<Object[]> list = productRepository.findFunctionsPrice();
		Object[] object = list.get(0);
		System.out.println("AVG :" + object[0] + " SUM :" + object[1] + " MAX :" + object[2] + " MIN :" + object[3] + " COUNT :" + object[4]); */
		
//		SELECT p.category.name, AVG(p.unitPrice) FROM Product p GROUP BY p.category.name
/*		List<Object[]> list = productRepository.findGroupByCategory();
		for(Object[] objects : list) {
			System.out.println("CategoryName :" +objects[0]+ " -AVG :" +objects[1]); 
		} */
		
//		SELECT p.category.name, AVG(p.unitPrice) FROM Product p GROUP BY p.category.name HAVİNG AVG(p.unitPrice) > :unitPrice
//		Kategorilere göre ortalama fiyatları parametre olarak verilen değerden büyük olan kategorileri getir.
/*		List<Object[]> list = productRepository.findGroupByHavingCategory(2600.0);
		for(Object[] object : list) {
			System.out.println("CategoryName :" + object[0] + " AVG :" + object[1] );
		} */
		
//		SELECT p FROM Product p ORDER BY DESC
		List<Product> products = productRepository.findOrderByPrice();
		products.forEach(System.out::println );
	} 
	
	public static void insertData() {

		Brand brand1 = new Brand("APPLE");
		Brand brand2 = new Brand("LG");
		Brand brand3 = new Brand("SONY");
		Brand brand4 = new Brand("SAMSUNG");
		Brand brand5 = new Brand("ASUS");

		Category category1 = new Category("Bilgisayar");
		Category category2 = new Category("Tablet");
		Category category3 = new Category("Telefon");

		Product product1 = new Product("İPhone 7", 3500.0, 2, category3, brand1, new Date());
		Product product2 = new Product("LG 3", 2500.0, 1, category3, brand2, new Date());
		Product product3 = new Product("Sony Experia", 2700.0, 1, category3, brand3, new Date());

		Product product4 = new Product("Samsung Z500", 1700.0, 1, category1, brand4, new Date());
		Product product5 = new Product("Mac i5", 4100.0, 1, category1, brand1, new Date());
		Product product6 = new Product("Asus i7", 3100.0, 2, category1, brand5, new Date());

		Product product7 = new Product("Galaxy Tablet", 2300.0, 1, category2, brand4, new Date());
		Product product8 = new Product("İ Pad", 2600.0, 3, category2, brand1, new Date());
		Product product9 = new Product("Sony Tabler", 2400.0, 1, category2, brand3, new Date());

		productRepository.saveBrand(brand1);
		productRepository.saveBrand(brand2);
		productRepository.saveBrand(brand3);
		productRepository.saveBrand(brand4);
		productRepository.saveBrand(brand5);

		productRepository.saveCategory(category1);
		productRepository.saveCategory(category2);
		productRepository.saveCategory(category3);

		productRepository.saveProduct(product1);
		productRepository.saveProduct(product2);
		productRepository.saveProduct(product3);
		productRepository.saveProduct(product4);
		productRepository.saveProduct(product5);
		productRepository.saveProduct(product6);
		productRepository.saveProduct(product7);
		productRepository.saveProduct(product8);
		productRepository.saveProduct(product9);

	}
}
