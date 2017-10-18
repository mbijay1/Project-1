package com.cubic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cubic.dao.ProductDao;
import com.cubic.entity.ProductEntity;
import com.cubic.exception.DuplicateValueFoundException;
import com.cubic.exception.EnumVoilationException;
import com.cubic.exception.NullValuesFoundException;
import com.cubic.exception.UpcFormatException;
import com.cubic.util.EnumClass;
import com.cubic.util.EnumClass.Category;
import com.cubic.util.EnumClass.Manufacturer;
import com.cubic.vo.ProductVO;

@Component
public class ProductValidation {
	@Autowired
	private ProductDao dao;

	private boolean upcFormatValidation(final ProductVO vo) {
		String upc = vo.getUpc();
		String[] upcArray = upc.split("-");
		if (upcArray.length != 4) {
			return false;
		}

		for (int i = 0; i < upcArray.length; i++) {
			try {
				Integer.parseInt(upcArray[i]);
			} catch (NumberFormatException nfe) {
				return false;
			}
		}
		if (upcArray[0].length() == 1 && upcArray[1].length() == 5 && upcArray[3].length() == 1
				&& upcArray[2].length() == 5) {
			return true;
		} else {
			return false;
		}
	}

	private boolean nullCategoryValidation(final ProductVO vo) {
		if (vo.getCategory() == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean nullManufacturerValidation(final ProductVO vo) {
		if (vo.getManufacturer() == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean nullProductNameValidation(final ProductVO vo) {
		if (vo.getProductName() == null) {
			return true;
		} else {
			return false;
		}

	}

	private boolean nullProductNumberValidation(final ProductVO vo) {
		if (vo.getProductNumber() == null) {
			return true;
		} else {
			return false;
		}

	}

	private boolean nullUPCValidation(final ProductVO vo) {
		if (vo.getUpc() == null) {
			return true;
		} else {
			return false;
		}

	}

	private boolean enumCategoryValidation(final ProductVO vo) {
		String enumCategory = vo.getCategory().toString();
		for (Category c : EnumClass.Category.values()) {
			if (c.toString().equals(enumCategory)) {
				return true;
			}
		}

		return false;
	}

	private boolean enumManufactureValidation(final ProductVO vo) {
		String enumManufacture = vo.getManufacturer().toString();
		for (Manufacturer m : EnumClass.Manufacturer.values()) {
			if (m.toString().equals(enumManufacture)) {
				return true;
			}
		}

		return false;
	}

	private boolean uniqueNameValidation(final ProductVO vo) {

		if (vo.getPk() == null) {
			Long count = dao.countByName(vo.getProductName());
			System.out.println("Number of name = " + count);
			return count == 0;
		} else {
			Long count = dao.countByName(vo.getProductName(), vo.getPk());
			System.out.println("Number of name = " + count);
			return count == 0;
		}
	}

	private boolean uniqueNumberValidation(final ProductVO vo) {
		if (vo.getPk() == null) {
			Long count = dao.countByNumber(vo.getProductNumber());
			System.out.println("Number of name = " + count);
			return count == 0;
		} else {
			Long count = dao.countByNumber(vo.getProductNumber(), vo.getPk());
			System.out.println("Number of name = " + count);
			return count == 0;
		}
	}

	private boolean uniqueUPCValidation(final ProductVO vo) {
		if (vo.getPk() == null) {
			Long count = dao.countByUPC(vo.getUpc());
			System.out.println("Number of name = " + count);
			return count == 0;
		} else {
			Long count = dao.countByUPC(vo.getUpc(), vo.getPk());
			System.out.println("Number of name = " + count);
			return count == 0;
		}
	}

	public void validateProductVO(final ProductVO vo) {
		if (uniqueNameValidation(vo) == false) {

			throw new DuplicateValueFoundException("Duplicate Product Name: Product Name should be Unique");
		}

		if (uniqueNumberValidation(vo) == false) {

			throw new DuplicateValueFoundException("Duplicate Product Number: Product Number should be Unique");
		}

		if (uniqueUPCValidation(vo) == false) {

			throw new DuplicateValueFoundException("Duplicate Product UPC: Product UPC should be Unique");
		}
		if (nullProductNameValidation(vo) == true) {

			throw new NullValuesFoundException("Product Name cannot be empty");
		}

		if (nullProductNumberValidation(vo) == true) {

			throw new NullValuesFoundException("Product Number cannot be empty");
		}

		if (nullUPCValidation(vo) == true) {

			throw new NullValuesFoundException("Product UPC cannot be empty");
		}

		if (nullCategoryValidation(vo) == true) {

			throw new NullValuesFoundException("Product Category cannot be empty");
		}

		if (nullManufacturerValidation(vo) == true) {

			throw new NullValuesFoundException("Product Manufacture cannot be empty");
		}

		if (enumCategoryValidation(vo) == false) {

			throw new EnumVoilationException("Invalid Category : Category Voilation");
		}

		if (enumManufactureValidation(vo) == false) {

			throw new EnumVoilationException("Invalid Manufacture : Manufacture Voilation");
		}
		if (upcFormatValidation(vo) == false) {

			throw new UpcFormatException("Invalid UPC format: Required Format X-XXXXX-XXXXX-X");
		}
	}

}
