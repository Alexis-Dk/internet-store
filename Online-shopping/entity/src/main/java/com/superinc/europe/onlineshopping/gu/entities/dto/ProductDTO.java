package com.superinc.europe.onlineshopping.gu.entities.dto;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -751155082317142262L;
    
    @Range(min=1, max=1000, message="Price has to has between 1 and 1000")
//    @Pattern(regexp = "^[1-9]{3,10}$", message="Login has to has between 3 and 10 symbols")
    private int price;
    
    @NotNull
    private DepartmentVO department;
    
    @Range(min=1, max=1000, message="Count has to has between 1 and 1000")
    private int count;
    
    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Description has to has between 3 and 50 symbols")
    private String description;
    
//    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Color has to has between 3 and 50 symbols")
//	private String characteristic1;
    
    @NotNull
    private CharacteristicOneVO characteristic1;
	
//    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Socket has to has between 3 and 50 symbols")
//	private String characteristic2;
	
    @NotNull
    private CharacteristicTwoVO characteristic2;
    
//    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Smart has to has between 3 and 50 symbols")
    @NotNull
    private CharacteristicThreeVO characteristic3;
	
//    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Screen resolution has to has between 3 and 50 symbols")
    @NotNull
    private CharacteristicFourVO characteristic4;
	
//  @Pattern(regexp = "^[1-9a-zA-Z\\w]{3,50}$", message="Stock availability has to has between 3 and 50 symbols")
  @NotNull
  private CharacteristicFiveVO characteristic5;
    
//    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Aspect ratio has to has between 3 and 50 symbols")
    @NotNull
    private CharacteristicSixVO characteristic6;
	
//	@Pattern(regexp = "^[1-9a-zA-Z]{3,10}$", message="Login has to has between 3 and 10 symbols")
    @NotNull
    private CharacteristicSevenVO characteristic7;
    
    public ProductDTO() {
    }

	public ProductDTO(CharacteristicSevenVO characteristic7, int price, int count,
			String description, CharacteristicOneVO characteristic1, CharacteristicTwoVO characteristic2,
			CharacteristicThreeVO characteristic3, CharacteristicFourVO characteristic4,
			CharacteristicSixVO characteristic6, CharacteristicFiveVO characteristic5) {
		this.price = price;
		this.count = count;
		this.description = description;
		this.characteristic1 = characteristic1;
		this.characteristic2 = characteristic2;
		this.characteristic3 = characteristic3;
		this.characteristic4 = characteristic4;
		this.characteristic5 = characteristic5;
		this.characteristic6 = characteristic6;
		this.characteristic7 = characteristic7;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CharacteristicOneVO getCharacteristic1() {
		return characteristic1;
	}

	public void setCharacteristic1(CharacteristicOneVO characteristic1) {
		this.characteristic1 = characteristic1;
	}

	public CharacteristicTwoVO getCharacteristic2() {
		return characteristic2;
	}

	public void setCharacteristic2(CharacteristicTwoVO characteristic2) {
		this.characteristic2 = characteristic2;
	}

	public CharacteristicThreeVO getCharacteristic3() {
		return characteristic3;
	}

	public void setCharacteristic3(CharacteristicThreeVO characteristic3) {
		this.characteristic3 = characteristic3;
	}

	public CharacteristicFourVO getCharacteristic4() {
		return characteristic4;
	}

	public void setCharacteristic4(CharacteristicFourVO characteristic4) {
		this.characteristic4 = characteristic4;
	}

	public CharacteristicSixVO getCharacteristic6() {
		return characteristic6;
	}

	public void setCharacteristic6(CharacteristicSixVO characteristic6) {
		this.characteristic6 = characteristic6;
	}

	public CharacteristicSevenVO getCharacteristic7() {
		return characteristic7;
	}

	public void setCharacteristic7(CharacteristicSevenVO characteristic7) {
		this.characteristic7 = characteristic7;
	}
	
//	public CharacteristicSevenVO getName() {
//		return characteristic7;
//	}
//
//	public void setName(CharacteristicSevenVO name) {
//		this.characteristic7 = name;
//	}
	
	public CharacteristicFiveVO getCharacteristic5() {
		return characteristic5;
	}

	public void setCharacteristic5(CharacteristicFiveVO characteristic5) {
		this.characteristic5 = characteristic5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductDTO [characteristic7=" + characteristic7 + ", price="
				+ price + ", department=" + department + ", count=" + count
				+ ", description=" + description + ", characteristic1="
				+ characteristic1 + ", characteristic2=" + characteristic2
				+ ", characteristic3=" + characteristic3 + ", characteristic4="
				+ characteristic4 + ", characteristic6=" + characteristic6
				+ ", characteristic5=" + characteristic5 + "]";
	}

}