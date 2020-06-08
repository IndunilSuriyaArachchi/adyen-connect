package com.example.adyenconnect.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class PayMethods {
	
	private String merchantAccount;

	public String getMerchantAccount() {
		return merchantAccount;
	}

	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}
	
	

}
