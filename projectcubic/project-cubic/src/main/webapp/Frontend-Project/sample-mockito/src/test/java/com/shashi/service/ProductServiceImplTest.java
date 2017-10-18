package com.shashi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.shashi.dao.ProductDAO;
import com.shashi.dao.ProductDetailDAO;
import com.shashi.entity.ProductEntity;
import com.shashi.test.ProductData;
import com.shashi.vo.ProductVO;

@RunWith(MockitoJUnitRunner.class)

public class ProductServiceImplTest {

	@Mock
	private ProductDAO productDao;
	@Mock
	private ProductDetailDAO detailDao;

	private ProductServiceImpl impl = new ProductServiceImpl();
	private ProductVO input;
	private ProductEntity entity;

	@Before
	public void setup() {
		entity = ProductData.createProductEntity();
		input = ProductData.createProductVO();
		impl.setDao(productDao);
		impl.setDetailDao(detailDao);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNull() {

		impl.saveProduct(null);
		fail("Dont reach here");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNullName() {

		input.setProductName(null);
		impl.saveProduct(input);
		fail("Dont reach here");
	}

	@Test
	public void testSaveProducte() throws SQLException {

		when(productDao.createProduct(any(ProductEntity.class))).thenReturn(entity);

		ProductVO result = impl.saveProduct(input);
		assertNotNull(result);
		assertEquals(input.getProductName(), result.getProductName());
		assertEquals(input.getDescription(), result.getDescription());
	}

	@Test
	public void testUpdateProducte() throws SQLException {

		when(productDao.find(any(Long.class))).thenReturn(entity);
		impl.setDao(productDao);
		impl.setDetailDao(detailDao);
		input.setId(new Long(2000));
		input.setProductName("Test Product");
		ProductVO result = impl.saveProduct(input);
		assertNotNull(result);
		assertNotNull(result.getId());

		assertEquals(input.getProductName(), result.getProductName());
		assertEquals(input.getDescription(), result.getDescription());

	}
}
