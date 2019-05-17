package com.hcl.payee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.payee.controller.PayeeController;
import com.hcl.payee.entity.Payee;
import com.hcl.payee.repository.PayeeRepository;
import com.hcl.payee.service.PayeeService;

@RunWith(MockitoJUnitRunner.class)
public class PayeeControllerTest {
	private static final String OTP_GENERATED_SUCCESSFULLY = "Successfully OTP generated";
	@InjectMocks
	private PayeeController payeeController;

	@Mock
	private PayeeRepository PayeeRepository;

	@Mock
	private PayeeService payeeService;

	@Test
	public void addPayeeTest() {
		Payee payee = new Payee();
		payee.setAccountNumber(6664554);
		payee.setAccountType("Savings");
		payee.setBranch("EC");
//		Mockito.when(payeeService.addPayee(payee)).thenReturn(SUCCESSFULLY_ADDED_PAYEE);
		String str = payeeController.addPayee(payee);
		assertEquals(str, OTP_GENERATED_SUCCESSFULLY);
//		Mockito.verify(PayeeRepository.save(payee));
	}

}
