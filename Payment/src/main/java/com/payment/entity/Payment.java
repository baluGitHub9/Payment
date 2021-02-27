package com.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Payment")
public class Payment {
	
	@Id
	@Column(name = "CARD_NUMBER")
	@NotNull
	@Size(min = 16,max = 16,message = "we have to pass 16Digitis ")
	private Long cardNumber;
	
	@NotNull
	@Size(min=4,max=50)
	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName; 
	
	@NotNull
	@Size(min = 15)
	@Column(name = "CARD_TYPE")
	private String cardType;
	
	@NotNull
	@Size(min = 4,max = 4)
	@Column(name = "LAST_FOURE_DIGITS")
	private int lastFoureDigits;
	
	@NotNull
	@Column(name = "EXPIRY_MONTH_YEAR")
	private String expiryMonthYear;
	
	@Column(name = "CARD_PRIORITY")
	private String cardPriority;
	
	@NotNull
	@Column(name = "AMONT_LIMIT")
	@Size(max = 6000000)
	private int amontLimit;
	
	@Column(name = "CRADHOLDER_NICKNAME")
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

	public String getExpiryMonthYear() {
		return expiryMonthYear;
	}

	public void setExpiryMonthYear(String expiryMonthYear) {
		this.expiryMonthYear = expiryMonthYear;
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
		return "Payment [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cardType=" + cardType
				+ ", lastFoureDigits=" + lastFoureDigits + ", expiryMonthYear=" + expiryMonthYear + ", cardPriority="
				+ cardPriority + ", amontLimit=" + amontLimit + ", cradholderNickname=" + cradholderNickname + "]";
	}


	
	
}
