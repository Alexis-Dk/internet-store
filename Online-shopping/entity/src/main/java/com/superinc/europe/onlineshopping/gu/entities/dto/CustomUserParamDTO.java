package com.superinc.europe.onlineshopping.gu.entities.dto;

import java.io.Serializable;

public class CustomUserParamDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String priceMin = "";
	private String priceMax = "";
	private String characteristics1;
	private String selectedCharacteristics1;
	private String characteristics2;
	private String selectedCharacteristics2;
	private String characteristics3;
	private String selectedCharacteristics3;
	private String characteristics4;
	private String selectedCharacteristics4;
	private String characteristics5;
	private String selectedCharacteristics5;
	private String characteristics6;
	private String selectedCharacteristics6;
	private String characteristics7;
	private String selectedCharacteristics7;

	public CustomUserParamDTO() {
	}
	
	public CustomUserParamDTO(String priceMin, String priceMax,
			String characteristics1, String selectedCharacteristics1,
			String characteristics2, String selectedCharacteristics2,
			String characteristics3, String selectedCharacteristics3,
			String characteristics4, String selectedCharacteristics4,
			String characteristics5, String selectedCharacteristics5,
			String characteristics6, String selectedCharacteristics6,
			String characteristics7, String selectedCharacteristics7) {
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.characteristics1 = characteristics1;
		this.selectedCharacteristics1 = selectedCharacteristics1;
		this.characteristics2 = characteristics2;
		this.selectedCharacteristics2 = selectedCharacteristics2;
		this.characteristics3 = characteristics3;
		this.selectedCharacteristics3 = selectedCharacteristics3;
		this.characteristics4 = characteristics4;
		this.selectedCharacteristics4 = selectedCharacteristics4;
		this.characteristics5 = characteristics5;
		this.selectedCharacteristics5 = selectedCharacteristics5;
		this.characteristics6 = characteristics6;
		this.selectedCharacteristics6 = selectedCharacteristics6;
		this.characteristics7 = characteristics7;
		this.selectedCharacteristics7 = selectedCharacteristics7;
	}

	public String getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}

	public String getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}

	public String getCharacteristics1() {
		return characteristics1;
	}

	public void setCharacteristics1(String characteristics1) {
		this.characteristics1 = characteristics1;
	}

	public String getSelectedCharacteristics1() {
		return selectedCharacteristics1;
	}

	public void setSelectedCharacteristics1(String selectedCharacteristics1) {
		this.selectedCharacteristics1 = selectedCharacteristics1;
	}

	public String getCharacteristics2() {
		return characteristics2;
	}

	public void setCharacteristics2(String characteristics2) {
		this.characteristics2 = characteristics2;
	}

	public String getSelectedCharacteristics2() {
		return selectedCharacteristics2;
	}

	public void setSelectedCharacteristics2(String selectedCharacteristics2) {
		this.selectedCharacteristics2 = selectedCharacteristics2;
	}

	public String getCharacteristics3() {
		return characteristics3;
	}

	public void setCharacteristics3(String characteristics3) {
		this.characteristics3 = characteristics3;
	}

	public String getSelectedCharacteristics3() {
		return selectedCharacteristics3;
	}

	public void setSelectedCharacteristics3(String selectedCharacteristics3) {
		this.selectedCharacteristics3 = selectedCharacteristics3;
	}

	public String getCharacteristics4() {
		return characteristics4;
	}

	public void setCharacteristics4(String characteristics4) {
		this.characteristics4 = characteristics4;
	}

	public String getSelectedCharacteristics4() {
		return selectedCharacteristics4;
	}

	public void setSelectedCharacteristics4(String selectedCharacteristics4) {
		this.selectedCharacteristics4 = selectedCharacteristics4;
	}

	public String getCharacteristics5() {
		return characteristics5;
	}

	public void setCharacteristics5(String characteristics5) {
		this.characteristics5 = characteristics5;
	}

	public String getSelectedCharacteristics5() {
		return selectedCharacteristics5;
	}

	public void setSelectedCharacteristics5(String selectedCharacteristics5) {
		this.selectedCharacteristics5 = selectedCharacteristics5;
	}

	public String getCharacteristics6() {
		return characteristics6;
	}

	public void setCharacteristics6(String characteristics6) {
		this.characteristics6 = characteristics6;
	}

	public String getSelectedCharacteristics6() {
		return selectedCharacteristics6;
	}

	public void setSelectedCharacteristics6(String selectedCharacteristics6) {
		this.selectedCharacteristics6 = selectedCharacteristics6;
	}

	public String getCharacteristics7() {
		return characteristics7;
	}

	public void setCharacteristics7(String characteristics7) {
		this.characteristics7 = characteristics7;
	}

	public String getSelectedCharacteristics7() {
		return selectedCharacteristics7;
	}

	public void setSelectedCharacteristics7(String selectedCharacteristics7) {
		this.selectedCharacteristics7 = selectedCharacteristics7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomUserParamDTO [priceMin=" + priceMin + ", priceMax="
				+ priceMax + ", characteristics1=" + characteristics1
				+ ", selectedCharacteristics1=" + selectedCharacteristics1
				+ ", characteristics2=" + characteristics2
				+ ", selectedCharacteristics2=" + selectedCharacteristics2
				+ ", characteristics3=" + characteristics3
				+ ", selectedCharacteristics3=" + selectedCharacteristics3
				+ ", characteristics4=" + characteristics4
				+ ", selectedCharacteristics4=" + selectedCharacteristics4
				+ ", characteristics5=" + characteristics5
				+ ", selectedCharacteristics5=" + selectedCharacteristics5
				+ ", characteristics6=" + characteristics6
				+ ", selectedCharacteristics6=" + selectedCharacteristics6
				+ ", characteristics7=" + characteristics7
				+ ", selectedCharacteristics7=" + selectedCharacteristics7
				+ "]";
	}
	
}