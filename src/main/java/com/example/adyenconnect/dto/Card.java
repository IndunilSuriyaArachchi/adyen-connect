package com.example.adyenconnect.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class Card {
	
	private String number;
	private String expiryMonth;
	private String expiryYear;
	private String cvc;
	private String holderName;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	@Override
	public String toString() {
		return "Card [number=" + number + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", cvc=" + cvc
				+ ", holderName=" + holderName + "]";
	}
	
	


}
