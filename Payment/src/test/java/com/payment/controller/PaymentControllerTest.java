package com.payment.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.payment.dao.PaymentDao;
import com.payment.serviceImpl.PaymentServiceImpl;

@ExtendWith(SpringExtension.class)
public class PaymentControllerTest {

	@InjectMocks
	private PaymentController paymentController;

	@Mock
	private PaymentServiceImpl paymentServiceImpl;

	@Test
	void testGetByCardNumber() {
		PaymentDao paymentDao = new PaymentDao();
		when(paymentServiceImpl.getPaymentRecordByCardNumber(Mockito.anyLong())).thenReturn(paymentDao);
		PaymentDao responce = paymentController.getByCardNumber(1253654785421532L);
		Assertions.assertEquals(paymentDao, responce);

	}

	@Test
	void testGetAllPaymentsRecords() {
		List<PaymentDao> payments = new ArrayList<PaymentDao>();
		when(paymentServiceImpl.getAllRecord()).thenReturn(payments);
		List<PaymentDao> responce = paymentController.getAllPaymentsRecords();
		Assertions.assertEquals(payments, responce);
	}

	@Test
	void testDalete() {
		//PaymentDao paymentDao = new PaymentDao();
		when(paymentServiceImpl.deletePaymentRecord(Mockito.anyLong())).thenReturn("done");
		 String responce = paymentController.delete(1253654785421532L);
		Assertions.assertEquals("done", responce);

	}
	
	@Test
	void testUpdate() {
		PaymentDao paymentDao = new PaymentDao();

		paymentDao.setCardNumber(1253625421l);
		paymentDao.setCardHolderName("Chiru");
		paymentDao.setAmontLimit(525241);
		paymentDao.setCardPriority("rupee");
		paymentDao.setCardType("Rupee");
		paymentDao.setCradholderNickname("Jaffa");
		paymentDao.setExpiryDate("02");
		paymentDao.setExpiryYear("2028");
		paymentDao.setLastFoureDigits(3625);

		when(paymentServiceImpl.updatePayment(Mockito.any())).thenReturn("updatePayment");
		String responce = paymentController.updatePayment(paymentDao);
		Assertions.assertEquals("updatePayment", responce);

	}
	
	@Test
	void testSave() {
		PaymentDao paymentDao = new PaymentDao();

		paymentDao.setCardNumber(1253625421l);
		paymentDao.setCardHolderName("Chiru");
		paymentDao.setAmontLimit(525241);
		paymentDao.setCardPriority("rupee");
		paymentDao.setCardType("Rupee");
		paymentDao.setCradholderNickname("Jaffa");
		paymentDao.setExpiryDate("02");
		paymentDao.setExpiryYear("2028");
		paymentDao.setLastFoureDigits(3625);
		

		when(paymentServiceImpl.addPaymentRecord(Mockito.any())).thenReturn("successfuly added payment redord");
		String responce = paymentController.save(paymentDao);
		Assertions.assertEquals("successfuly added payment redord", responce);
	}

}
