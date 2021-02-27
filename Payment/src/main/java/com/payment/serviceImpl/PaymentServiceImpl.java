package com.payment.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.PaymentDao;
import com.payment.entity.Payment;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{
	

	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public List<PaymentDao> getAllRecord() {
		List<Payment> listOfpayments = paymentRepository.findAll();
		List<PaymentDao> payments = new ArrayList<PaymentDao>();
		for (Payment payment : listOfpayments) {
			PaymentDao paymentDao = new PaymentDao();
			paymentDao.setCardNumber(payment.getCardNumber());
			paymentDao.setCardHolderName(payment.getCardHolderName());
			paymentDao.setCardType(payment.getCardType());
			paymentDao.setCardPriority(payment.getCardPriority());
			String expiryMonthYear = payment.getExpiryMonthYear();
			
			String[] splitDate = expiryMonthYear.split("/");
			paymentDao.setExpiryDate(splitDate[0]);
			paymentDao.setExpiryYear(splitDate[1]);
			
			paymentDao.setLastFoureDigits(payment.getLastFoureDigits());
			paymentDao.setCradholderNickname(payment.getCradholderNickname());
			paymentDao.setAmontLimit(payment.getAmontLimit());
			payments.add(paymentDao);
		}

		return payments;
	}

	
	@Override
	public PaymentDao getPaymentRecordByCardNumber(Long cardnumber) {
		Optional<Payment> paymentByCardNumber = paymentRepository.findById(cardnumber);
		PaymentDao paymentDao = new PaymentDao();
		paymentDao.setCardNumber(paymentByCardNumber.get().getCardNumber());
		paymentDao.setCardHolderName(paymentByCardNumber.get().getCardHolderName());
		paymentDao.setCardType(paymentByCardNumber.get().getCardType());
		paymentDao.setCardPriority(paymentByCardNumber.get().getCardPriority());
		String expiryMonthYear = paymentByCardNumber.get().getExpiryMonthYear();
		
		String[] splitDate = expiryMonthYear.split("/");
		paymentDao.setExpiryDate(splitDate[0]);
		paymentDao.setExpiryYear(splitDate[1]);
		
		paymentDao.setLastFoureDigits(paymentByCardNumber.get().getLastFoureDigits());
		paymentDao.setCradholderNickname(paymentByCardNumber.get().getCradholderNickname());
		paymentDao.setAmontLimit(paymentByCardNumber.get().getAmontLimit());

		return paymentDao;
	}

	@Override
	public String addPaymentRecord(PaymentDao paymentDao) {
		Payment payment = new Payment();
		payment.setCardNumber(paymentDao.getCardNumber());
		payment.setCardHolderName(paymentDao.getCardHolderName());
		payment.setCardType(paymentDao.getCardType());
		payment.setCardPriority(paymentDao.getCardPriority());
		payment.setCradholderNickname(paymentDao.getCradholderNickname());
		payment.setLastFoureDigits(paymentDao.getLastFoureDigits());
		String date = paymentDao.getExpiryDate();
		String year = paymentDao.getExpiryYear();
		String expiryDataAndYear=date+"/"+year;
		payment.setExpiryMonthYear(expiryDataAndYear);
		paymentRepository.save(payment);
		
		return "successfuly added payment redord";
		
	}
	
	@Override
	public String deletePaymentRecord(Long cardNumber) {
		paymentRepository.deleteById(cardNumber);
		return "successfuly deleted";
		
	}



	@Override
	public String updatePayment(PaymentDao paymentDao) {
		Payment oldPaymentsObject = this.getById(paymentDao.getCardNumber());
		if(oldPaymentsObject != null) {
			oldPaymentsObject.setCardNumber(paymentDao.getCardNumber());
			oldPaymentsObject.setCardHolderName(paymentDao.getCardHolderName());
			oldPaymentsObject.setCardType(paymentDao.getCardType());
			oldPaymentsObject.setCardPriority(paymentDao.getCardPriority());
			oldPaymentsObject.setCradholderNickname(paymentDao.getCradholderNickname());
			oldPaymentsObject.setLastFoureDigits(paymentDao.getLastFoureDigits());
			oldPaymentsObject.setAmontLimit(paymentDao.getAmontLimit());
			String date = paymentDao.getExpiryDate();
			String year = paymentDao.getExpiryYear();
			String expiryDataAndYear=date+"/"+year;
			oldPaymentsObject.setExpiryMonthYear(expiryDataAndYear);
			paymentRepository.save(oldPaymentsObject);
		}else {
			return "card number doesn't match plese Enter valid card number";
		}
		
		return "successufuly Updated";
	}
	
	public Payment getById(Long cardNumber) {
		Optional<Payment> findById = paymentRepository.findById(cardNumber);
		return findById.get();
	}

	


}
