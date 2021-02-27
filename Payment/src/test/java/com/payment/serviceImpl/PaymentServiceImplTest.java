package com.payment.serviceImpl;
import static org.mockito.Mockito.mockitoSession;
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
import com.payment.entity.Payment;
import com.payment.repository.PaymentRepository;

@ExtendWith(SpringExtension.class)
class PaymentServiceImplTest {
	@InjectMocks
	private PaymentServiceImpl paymentServiceImpl;
	
	@Mock
	private PaymentRepository paymentRepository;
	
	
	@Test
	void testGetAllRecord() {
		List<Payment> payments = new ArrayList<Payment>();
		when(paymentRepository.findAll()).thenReturn(payments);
		List<PaymentDao> response = paymentServiceImpl.getAllRecord();
		Assertions.assertEquals(payments, response);
	}

	@Test
	void testAddPaymentRecord() {
		PaymentDao paymentDao = new PaymentDao();
		paymentDao.setCardNumber(1235624253625489L);
		paymentDao.setCardHolderName("virat");
		paymentDao.setAmontLimit(525241);
		paymentDao.setCardPriority("rupee");
		paymentDao.setCardType("Rupee");
		paymentDao.setCradholderNickname("virat");
		paymentDao.setExpiryDate("06");
		paymentDao.setExpiryYear("2030");
		paymentDao.setLastFoureDigits(3628);
		when(paymentRepository.save(Mockito.any())).thenReturn("successfuly added payment redord");
		String addPaymentRecord = paymentServiceImpl.addPaymentRecord(paymentDao);
		Assertions.assertEquals("successfuly added payment redord", addPaymentRecord);
	}
	@Test
	void testUpdatePayment() {
		PaymentDao paymentDao = new PaymentDao();
		paymentDao.setCardNumber(7896532152635412L);
		paymentDao.setCardHolderName("virat");
		paymentDao.setAmontLimit(525241);
		paymentDao.setCardPriority("rupee");
		paymentDao.setCardType("Rupee");
		paymentDao.setCradholderNickname("virat");
		paymentDao.setExpiryDate("06");
		paymentDao.setExpiryYear("2030");
		paymentDao.setLastFoureDigits(3628);
		when(paymentRepository.save(Mockito.any())).thenReturn("done");
		String response = paymentServiceImpl.updatePayment(paymentDao);
		Assertions.assertEquals("done", response);
	}
}
