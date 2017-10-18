package com.cubic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.ProductEntity;
import com.cubic.exception.NoFieldFoundException;
import com.cubic.util.QueryConstants;

@Service
@Transactional
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	private EntityManager em;

	public ProductEntity save(ProductEntity entity) {
		em.persist(entity);
		return entity;
	}

	public void remove(Long pk) {
		ProductEntity entity = em.find(ProductEntity.class, pk);
		em.remove(entity);
	}

	public ProductEntity searchById(Long pk) {
		ProductEntity entity = em.find(ProductEntity.class, pk);
		if (entity == null) {
			throw new NoFieldFoundException("No Field is found matching searching criteria");
		}
		return entity;
	}

	public List<ProductEntity> searchByName(String productName) {
		String queryParam = productName.trim() + "%";
		TypedQuery<ProductEntity> query = (TypedQuery<ProductEntity>) em
				.createNamedQuery("QueryConstants.PRODUCT_SEARCH_BY_NAME", ProductEntity.class);
		query.setParameter("p1", queryParam);
		List<ProductEntity> entities = query.getResultList();
		return entities;
	}

	public List<ProductEntity> searchByUpc(String upc) {
		String queryParam = upc.toString().trim() + "%";
		TypedQuery<ProductEntity> query = (TypedQuery<ProductEntity>) em
				.createNamedQuery("QueryConstants.PRODUCT_SEARCH_BY_UPC", ProductEntity.class);
		query.setParameter("p3", queryParam);
		List<ProductEntity> entities = query.getResultList();
		return entities;
	}

	public Long countByName(String name) {
		String queryParam = "Select count(c) from ProductEntity c where productName = " + name;
		TypedQuery<Long> query = em.createQuery(queryParam, Long.class);
		Long result = query.getSingleResult();
		return result;

	}

	public Long countByName(String name, Long pk) {
		String queryParam = "Select count(c) from ProductEntity c where productName = " + name + " AND pk != " + pk;
		TypedQuery<Long> query = em.createQuery(queryParam, Long.class);
		Long result = query.getSingleResult();
		return result;

	}

	public List<ProductEntity> searchByNumber(String productNumber) {
		String queryParam = productNumber.trim() + "%";

		TypedQuery<ProductEntity> query = (TypedQuery<ProductEntity>) em
				.createNamedQuery("QueryConstants.PRODUCT_SEARCH_BY_NUMBER", ProductEntity.class);
		query.setParameter("p2", queryParam);
		List<ProductEntity> entities = query.getResultList();
		return entities;
	}

	public List<ProductEntity> searchAllProducts() {
		System.out.println(QueryConstants.PRODUCT_SELECT_ALL);

		TypedQuery<ProductEntity> query = (TypedQuery<ProductEntity>) em.createQuery(QueryConstants.PRODUCT_SELECT_ALL,
				ProductEntity.class);
		List<ProductEntity> entities = query.getResultList();
		return entities;

	}

	public Long countByNumber(String number) {
		String queryParam = "Select count(c) from ProductEntity c where productNumber = " + number;
		TypedQuery<Long> query = em.createQuery(queryParam, Long.class);
		Long result = query.getSingleResult();

		return result;
	}

	public Long countByNumber(String number, Long pk) {
		String queryParam = "Select count(c) from ProductEntity c where productNumber = " + number + " AND pk != " + pk;
		TypedQuery<Long> query = em.createQuery(queryParam, Long.class);
		Long result = query.getSingleResult();

		return result;
	}

	public Long countByUPC(String upc) {
		String queryParam = "Select count(c) from ProductEntity c where upc = '" + upc + "'";
		TypedQuery<Long> query = em.createQuery(queryParam, Long.class);
		Long result = query.getSingleResult();

		return result;
	}

	public Long countByUPC(String upc, Long pk) {
		System.out.println(upc);
		String queryParam = "Select count(c) from ProductEntity c where upc = '" + upc + "' AND pk != " + pk;
		TypedQuery<Long> query = em.createQuery(queryParam, Long.class);
		Long result = query.getSingleResult();

		return result;
	}

}
