package com.example.adyenconnect.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class AuthoriseRequest {
	
	private Card card;
	private Amount amount;
	private String reference;
	private String  merchantAccount;
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
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
