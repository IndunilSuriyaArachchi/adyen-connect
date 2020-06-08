package com.example.adyenconnect.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class AdyenDirectAuthoriseRequest {
	
	private AdyenDirectCard card;
	private AdyenDirectAmount amount;
	private String reference;
	private String  merchantAccount;
	public AdyenDirectCard getCard() {
		return card;
	}
	public void setCard(AdyenDirectCard card) {
		this.card = card;
	}
	public AdyenDirectAmount getAmount() {
		return amount;
	}
	public void setAmount(AdyenDirectAmount amount) {
		this.amount = amount;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getMerchantAccount() {
		return merchantAccount;
	}
	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}
	@Override
	public String toString() {
		return "AuthoriseRequest [card=" + card + ", amount=" + amount + ", reference=" + reference
				+ ", merchantAccount=" + merchantAccount + "]";
	}
	
	

}
