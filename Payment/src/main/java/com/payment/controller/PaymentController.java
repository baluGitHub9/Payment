package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.payment.dao.PaymentDao;
import com.payment.service.PaymentService;

@Controller("/")
public class PaymentController {

	@Autowired
	PaymentService paymentService ;
	
	@GetMapping("/payment/getAll")
	@ResponseBody
	public List<PaymentDao> getAllPaymentsRecords() {
		 List<PaymentDao> allRecord = paymentService.getAllRecord();
		 return allRecord;
	}
	
	@GetMapping("/payment/getByCardNumber/{cardnumber}")
	@ResponseBody
	public PaymentDao getByCardNumber(@Validated @PathVariable Long cardnumber) {
		PaymentDao payment = paymentService.getPaymentRecordByCardNumber(cardnumber);
		
		return payment;
	}
	
	
	@PostMapping("/payment/save")
	@ResponseBody
	public String save(@Validated @RequestBody PaymentDao paymentdao) {
		String addPaymentRecord = paymentService.addPaymentRecord(paymentdao);
		return addPaymentRecord;
	}
	
	@DeleteMapping("/payment/delete/{cardNumber}")
	@ResponseBody
	public String delete(@Validated @PathVariable Long cardNumber) {
		String deletePaymentRecord = paymentService.deletePaymentRecord(cardNumber);
		return deletePaymentRecord;
	}
	
	@PutMapping("/payment/update")
	public String updatePayment(@Validated @RequestBody PaymentDao paymentDao) {
		String updatePayment = paymentService.updatePayment(paymentDao);
		return "updatePayment";
	}
}
