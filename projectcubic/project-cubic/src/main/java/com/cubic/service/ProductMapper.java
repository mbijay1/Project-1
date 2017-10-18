package com.cubic.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.ProductEntity;
import com.cubic.vo.ProductVO;

@Component
public class ProductMapper {
	public ProductEntity mapToProductEntity(final ProductVO vo, final ProductEntity entity) {

		entity.setCreatedDate(vo.getCreatedDate());

		if (vo.getPk() == null) {
			LocalDateTime now = LocalDateTime.now();
			entity.setCreatedDate(new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth()));

		} else {
			entity.setCreatedDate(vo.getCreatedDate());
		}

		if (vo.getActiveState().equals("true")) {
			if (vo.getActiveDate() == null) {
				LocalDateTime now = LocalDateTime.now();
				entity.setActiveDate(new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth()));
			} else {
				entity.setActiveDate(vo.getActiveDate());
			}
			entity.setInactiveDate(null);
		} else {
			if (vo.getInactiveDate() == null) {
				// give current date
				LocalDateTime now = LocalDateTime.now();
				entity.setInactiveDate(new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth()));

			} else {
				entity.setInactiveDate(vo.getInactiveDate());
			}
			entity.setActiveDate(null);
		}

		entity.setCategory(vo.getCategory());
		entity.setManufacturer(vo.getManufacturer());
		entity.setPk(vo.getPk());
		entity.setPrice(vo.getPrice());
		entity.setProductName(vo.getProductName());
		entity.setProductNumber(vo.getProductNumber());
		entity.setUpc(vo.getUpc());
		entity.setVersion(vo.getVersion());
		entity.setDescription(vo.getDescription());

		if (vo.getActiveState().equals("true")) {
			entity.setThresholdQuantity(vo.getThresholdQuantity());
			entity.setOrderedQuantity(vo.getOrderedQuantity());
			if (vo.getCurrentQuantity() > vo.getThresholdQuantity() + vo.getOrderedQuantity()) {
				entity.setCurrentQuantity(vo.getCurrentQuantity());
			} else {
				while (!(vo.getCurrentQuantity() > vo.getThresholdQuantity() + vo.getOrderedQuantity())) {
					vo.setCurrentQuantity(vo.getCurrentQuantity() + vo.getThresholdQuantity());
				}
				entity.setCurrentQuantity(vo.getCurrentQuantity());
			}
		} else {
			entity.setThresholdQuantity(vo.getThresholdQuantity());
			entity.setOrderedQuantity(vo.getOrderedQuantity());
			entity.setCurrentQuantity(vo.getCurrentQuantity());
		}

		return entity;

	}

	public ProductEntity mapToProductEntity(final ProductVO vo) {
		return mapToProductEntity(vo, new ProductEntity());

	}

	public ProductVO mapToProductVO(final ProductEntity entity) {
		ProductVO vo = new ProductVO();
		vo.setActiveDate(entity.getActiveDate());
		vo.setCreatedDate(entity.getCreatedDate());
		vo.setInactiveDate(entity.getInactiveDate());
		if (entity.getActiveDate() == null) {
			// vo.setActiveStatus(false);
			vo.setActiveState("false");
		} else {
			// vo.setActiveStatus(true);
			vo.setActiveState("true");
		}
		vo.setCategory(entity.getCategory());

		vo.setManufacturer(entity.getManufacturer());

		vo.setPk(entity.getPk());
		vo.setPrice(entity.getPrice());
		vo.setProductName(entity.getProductName());
		vo.setProductNumber(entity.getProductNumber());

		vo.setUpc(entity.getUpc());
		vo.setVersion(entity.getVersion());
		vo.setDescription(entity.getDescription());

		vo.setThresholdQuantity(entity.getThresholdQuantity());
		vo.setOrderedQuantity(entity.getOrderedQuantity());
		vo.setCurrentQuantity(entity.getCurrentQuantity());

		return vo;
	}

	public List<ProductVO> mapToProductVOList(List<ProductEntity> entities) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		for (ProductEntity entity : entities) {
			list.add(mapToProductVO(entity));
		}
		return list;

	}

}
