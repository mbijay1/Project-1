package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import com.cubic.vo.ProductVO;

public interface ProductService {
	ProductVO add(final ProductVO vo);

	void remove(final Long pk);

	ProductVO searchById(final Long pk);

	List<ProductVO> searchByName(final String productName);

	List<ProductVO> searchByNumber(final String productNumber);

	List<ProductVO> searchByUpc(final String upc);

	List<ProductVO> searchAll();

	ArrayList<String> getEnumCategory();

	ArrayList<String> getEnumManufacture();

}
