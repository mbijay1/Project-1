package com.cubic.dao;

import java.util.List;

import com.cubic.entity.ProductEntity;

public interface ProductDao {
	ProductEntity save(final ProductEntity entity);

	void remove(final Long pk);

	ProductEntity searchById(final Long pk);

	List<ProductEntity> searchByName(final String productName);

	List<ProductEntity> searchByNumber(final String productNumber);

	List<ProductEntity> searchByUpc(final String upc);

	List<ProductEntity> searchAllProducts();

	Long countByName(String name);

	Long countByName(String name, Long pk);

	Long countByNumber(String name);

	Long countByNumber(String name, Long pk);

	Long countByUPC(String name);

	Long countByUPC(String name, Long pk);

}
