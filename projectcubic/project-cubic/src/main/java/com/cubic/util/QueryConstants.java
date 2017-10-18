package com.cubic.util;

import org.springframework.stereotype.Component;

@Component
public interface QueryConstants {
	// String PRODUCT_SELECT_ALL="PRODUCT_SELECT_ALL";

	String PRODCUCT_SEARCH_BY_NAME = "PRODUCT_SEARCH_BY_NAME";

	String PRODUCT_SEARCH_BY_UPC = "PRODUCT_SEARCH_BY_UPC";

	String PRODUCT_SEARCH_BY_NUMBER = "PRODUCT_SEARCH_BY_NUMBER";

	String PRODUCT_SELECT_ALL = "select p from ProductEntity p";

}
