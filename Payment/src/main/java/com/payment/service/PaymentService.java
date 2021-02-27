package com.payment.service;

import java.util.List;

import com.payment.dao.PaymentDao;

public interface PaymentService {
	public List<PaymentDao> getAllRecord();
	public PaymentDao getPaymentRecordByCardNumber(Long cardnumber);
	public String addPaymentRecord(PaymentDao paymentDao);
	public String updatePayment(PaymentDao paymentDao);
	public String deletePaymentRecord(Long cardNumber);
	

}
