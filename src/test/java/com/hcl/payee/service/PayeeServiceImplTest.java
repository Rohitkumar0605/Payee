package com.hcl.payee.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.payee.pojo.DeletePayeeRequest;
import com.hcl.payee.repository.PayeeRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class PayeeServiceImplTest {

	@Mock
	PayeeRepository payeeRepository;

	@InjectMocks
	PayeeServiceImpl payeeServiceImpl;

	static String s1 = "Successfully deleted Payee";
	static DeletePayeeRequest deletePayeeRequest = null;

	@BeforeClass
	public static void setUp() {
		deletePayeeRequest = new DeletePayeeRequest();
		deletePayeeRequest.setId(1L);
		deletePayeeRequest.setOtp(123456);

	}

	@Test
	public void testvalidateOtp() {
		String actval = payeeServiceImpl.validateOtp(1L, 123456);
		Assert.assertEquals(s1, actval);

	}

}
