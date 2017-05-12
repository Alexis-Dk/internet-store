package com.superinc.europe.onlineshopping.gu.entities.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -751155082317142262L;
    
//    @Range(min=1, max=1000, message="Price has to has between 1 and 1000")
////    @Pattern(regexp = "^[1-9]{3,10}$", message="Login has to has between 3 and 10 symbols")
//    private int price;
//    
//
//    @Range(min=1, max=1000, message="Count has to has between 1 and 1000")
//    private int count;
 
    @NotNull
    private DepartmentVO department;    
    
    @Pattern(regexp = "^[-0-9a-zA-Zà-ÿÀ-ß]{3,50}$", message="Description has to has between 3 and 50 symbols")
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
    
    @Range(min=1, max=1000000, message="intCharacteristic1 has to has between 1 and 1000000")
    private int intCharacteristic1;
    
    @Range(min=1, max=1000000, message="intCharacteristic2 has to has between 1 and 1000000")
    private int intCharacteristic2;
    
    @Range(min=1, max=1000000, message="intCharacteristic3 has to has between 1 and 1000000")
    private int intCharacteristic3;
    
    @Range(min=1, max=1000000, message="intCharacteristic4 has to has between 1 and 1000000")
    private int intCharacteristic4;
    
    @Range(min=1, max=1000000, message="intCharacteristic5 has to has between 1 and 1000000")
    private int intCharacteristic5;
    
    @NotNull
	private String boolCharacteristic1;
	
    @NotNull
	private String boolCharacteristic2;
	
    @NotNull
	private String boolCharacteristic3;
	
    @NotNull
	private String boolCharacteristic4;
	
    @NotNull
	private String boolCharacteristic5;
    
    public ProductDTO() {
    }

	public ProductDTO(CharacteristicSevenVO characteristic7, int price, int count,
			String description, CharacteristicOneVO characteristic1, CharacteristicTwoVO characteristic2,
			CharacteristicThreeVO characteristic3, CharacteristicFourVO characteristic4,
			CharacteristicSixVO characteristic6, CharacteristicFiveVO characteristic5) {
//		this.price = price;
//		this.count = count;
		this.description = description;
		this.characteristic1 = characteristic1;
		this.characteristic2 = characteristic2;
		this.characteristic3 = characteristic3;
		this.characteristic4 = characteristic4;
		this.characteristic5 = characteristic5;
		this.characteristic6 = characteristic6;
		this.characteristic7 = characteristic7;
	}
	
	public ProductDTO(String description, int intCharacteristic1,
			int intCharacteristic2, int intCharacteristic3,
			int intCharacteristic4, int intCharacteristic5,
			CharacteristicOneVO characteristic1,
			CharacteristicTwoVO characteristic2,
			CharacteristicThreeVO characteristic3,
			CharacteristicFourVO characteristic4,
			CharacteristicFiveVO characteristic5,
			CharacteristicSixVO characteristic6,
			CharacteristicSevenVO characteristic7) {
		this.description = description;
		this.intCharacteristic1 = intCharacteristic1;
		this.intCharacteristic2 = intCharacteristic2;
		this.intCharacteristic3 = intCharacteristic3;
		this.intCharacteristic4 = intCharacteristic4;
		this.intCharacteristic5 = intCharacteristic5;
		this.characteristic1 = characteristic1;
		this.characteristic2 = characteristic2;
		this.characteristic3 = characteristic3;
		this.characteristic4 = characteristic4;
		this.characteristic5 = characteristic5;
		this.characteristic6 = characteristic6;
		this.characteristic7 = characteristic7;
	}

//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

//	public int getCount() {
//		return count;
//	}
//
//	public void setCount(int count) {
//		this.count = count;
//	}

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

	public CharacteristicFiveVO getCharacteristic5() {
		return characteristic5;
	}

	public void setCharacteristic5(CharacteristicFiveVO characteristic5) {
		this.characteristic5 = characteristic5;
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
	public int getIntCharacteristic1() {
		return intCharacteristic1;
	}

	public void setIntCharacteristic1(int intCharacteristic1) {
		this.intCharacteristic1 = intCharacteristic1;
	}

	public int getIntCharacteristic2() {
		return intCharacteristic2;
	}

	public void setIntCharacteristic2(int intCharacteristic2) {
		this.intCharacteristic2 = intCharacteristic2;
	}
	
	public int getIntCharacteristic3() {
		return intCharacteristic3;
	}

	public void setIntCharacteristic3(int intCharacteristic3) {
		this.intCharacteristic3 = intCharacteristic3;
	}

	public int getIntCharacteristic4() {
		return intCharacteristic4;
	}

	public void setIntCharacteristic4(int intCharacteristic4) {
		this.intCharacteristic4 = intCharacteristic4;
	}

	public int getIntCharacteristic5() {
		return intCharacteristic5;
	}

	public void setIntCharacteristic5(int intCharacteristic5) {
		this.intCharacteristic5 = intCharacteristic5;
	}

	public String getBoolCharacteristic1() {
		return boolCharacteristic1;
	}

	public void setBoolCharacteristic1(String boolCharacteristic1) {
		this.boolCharacteristic1 = boolCharacteristic1;
	}

	public String getBoolCharacteristic2() {
		return boolCharacteristic2;
	}

	public void setBoolCharacteristic2(String boolCharacteristic2) {
		this.boolCharacteristic2 = boolCharacteristic2;
	}

	public String getBoolCharacteristic3() {
		return boolCharacteristic3;
	}

	public void setBoolCharacteristic3(String boolCharacteristic3) {
		this.boolCharacteristic3 = boolCharacteristic3;
	}

	public String getBoolCharacteristic4() {
		return boolCharacteristic4;
	}

	public void setBoolCharacteristic4(String boolCharacteristic4) {
		this.boolCharacteristic4 = boolCharacteristic4;
	}

	public String getBoolCharacteristic5() {
		return boolCharacteristic5;
	}

	public void setBoolCharacteristic5(String boolCharacteristic5) {
		this.boolCharacteristic5 = boolCharacteristic5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductDTO [department=" + department + ", description="
				+ description + ", characteristic1=" + characteristic1
				+ ", characteristic2=" + characteristic2 + ", characteristic3="
				+ characteristic3 + ", characteristic4=" + characteristic4
				+ ", characteristic5=" + characteristic5 + ", characteristic6="
				+ characteristic6 + ", characteristic7=" + characteristic7
				+ ", intCharacteristic1=" + intCharacteristic1
				+ ", intCharacteristic2=" + intCharacteristic2
				+ ", intCharacteristic3=" + intCharacteristic3
				+ ", intCharacteristic4=" + intCharacteristic4
				+ ", intCharacteristic5=" + intCharacteristic5
				+ ", boolCharacteristic1=" + boolCharacteristic1
				+ ", boolCharacteristic2=" + boolCharacteristic2
				+ ", boolCharacteristic3=" + boolCharacteristic3
				+ ", boolCharacteristic4=" + boolCharacteristic4
				+ ", boolCharacteristic5=" + boolCharacteristic5 + "]";
	}

}