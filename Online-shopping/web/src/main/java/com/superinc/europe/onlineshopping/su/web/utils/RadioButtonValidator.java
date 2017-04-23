package com.superinc.europe.onlineshopping.su.web.utils;

import com.superinc.europe.onlineshopping.gu.entities.dto.ProductDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RadioButtonValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return ProductDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ProductDTO cust = (ProductDTO)target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boolCharacteristic1", "Please select a 'Yes' or 'No' ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boolCharacteristic2", "Please select a 'Yes' or 'No' ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boolCharacteristic3", "Please select a 'Yes' or 'No' ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boolCharacteristic4", "Please select a 'Yes' or 'No' ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boolCharacteristic5", "Please select a 'Yes' or 'No' ");

	}
}
