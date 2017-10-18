package com.shashi.test;

import com.shashi.entity.ProductEntity;
import com.shashi.vo.ProductVO;

public class ProductData {
public static ProductVO createProductVO(){
	ProductVO result = new ProductVO();
	result.setProductName("Desktop XPS");
	result.setDescription("Pwoerful");
			return result;
}
public static ProductEntity createProductEntity(){
	ProductEntity entity = new ProductEntity();
	entity.setProductName("Iphone");
	entity.setDescription("Most smart");
	entity.setId(new Long(2000));
	return entity;
}
}
