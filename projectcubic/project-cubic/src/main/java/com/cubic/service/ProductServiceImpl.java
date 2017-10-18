package com.cubic.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.dao.ProductDao;
import com.cubic.entity.ProductEntity;
import com.cubic.util.EnumClass;
import com.cubic.util.EnumClass.Category;
import com.cubic.util.EnumClass.Manufacturer;
import com.cubic.vo.ProductVO;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductValidation validation;
	@Autowired
	private ProductDao dao;
	@Autowired
	private ProductMapper mapper;

	public ProductVO add(ProductVO vo) {

		validation.validateProductVO(vo);

		ProductEntity entity = null;

		if (vo.getPk() == null) {
			entity = mapper.mapToProductEntity(vo);
		} else {
			entity = dao.searchById(vo.getPk());
			entity = mapper.mapToProductEntity(vo, entity);
		}
		dao.save(entity);
		vo.setPk(entity.getPk());
		return vo;
	}

	public void remove(final Long pk) {
		dao.remove(pk);
	}

	public ProductVO searchById(final Long pk) {
		ProductEntity entity = dao.searchById(pk);
		ProductVO vo = mapper.mapToProductVO(entity);
		return vo;
	}

	public List<ProductVO> searchByName(final String productName) {
		List<ProductEntity> entities = dao.searchByName(productName);
		List<ProductVO> list = mapper.mapToProductVOList(entities);
		return list;
	}

	public List<ProductVO> searchAll() {
		List<ProductEntity> entities = dao.searchAllProducts();
		List<ProductVO> list = mapper.mapToProductVOList(entities);
		return list;
	}

	public List<ProductVO> searchByNumber(final String productNumber) {
		List<ProductEntity> entities = dao.searchByNumber(productNumber);
		List<ProductVO> list = mapper.mapToProductVOList(entities);
		return list;
	}

	public List<ProductVO> searchByUpc(final String upc) {
		List<ProductEntity> entities = dao.searchByUpc(upc);
		List<ProductVO> list = mapper.mapToProductVOList(entities);
		return list;
	}

	public ArrayList<String> getEnumCategory() {
		ArrayList<String> ecResults = new ArrayList<String>();
		for (Category c : EnumClass.Category.values()) {
			ecResults.add(c.toString());
		}
		return ecResults;
	}

	public ArrayList<String> getEnumManufacture() {
		ArrayList<String> ecResults = new ArrayList<String>();
		for (Manufacturer c : EnumClass.Manufacturer.values()) {
			ecResults.add(c.toString());
		}
		return ecResults;
	}

}
