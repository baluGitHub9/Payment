package com.payment.dao;

public class PaymentDao {

	private Long cardNumber;
	private String expiryDate;
	private String expiryYear;
	private String cardHolderName; 
	private String cardType;
	private int lastFoureDigits;
	private String cardPriority;
	private int amontLimit;
	private String cradholderNickname;
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getLastFoureDigits() {
		return lastFoureDigits;
	}
	public void setLastFoureDigits(int lastFoureDigits) {
		this.lastFoureDigits = lastFoureDigits;
	}
	
	
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getCardPriority() {
		return cardPriority;
	}
	public void setCardPriority(String cardPriority) {
		this.cardPriority = cardPriority;
	}
	public int getAmontLimit() {
		return amontLimit;
	}
	public void setAmontLimit(int amontLimit) {
		this.amontLimit = amontLimit;
	}
	public String getCradholderNickname() {
		return cradholderNickname;
	}
	public void setCradholderNickname(String cradholderNickname) {
		this.cradholderNickname = cradholderNickname;
	}
	@Override
	public String toString() {
		return "PaymentDao [cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", expiryYear=" + expiryYear
				+ ", cardHolderName=" + cardHolderName + ", cardType=" + cardType + ", lastFoureDigits="
				+ lastFoureDigits + ", cardPriority=" + cardPriority + ", amontLimit=" + amontLimit
				+ ", cradholderNickname=" + cradholderNickname + "]";
	}
	
	
	

}
