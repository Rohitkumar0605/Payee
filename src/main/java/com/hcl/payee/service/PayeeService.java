package com.hcl.payee.service;

import com.hcl.payee.entity.Payee;

//@Service
public interface PayeeService {
	public String validateOtp(long id, long otp);

	public void addPayee(Payee payee);

	public String validatePayee(long otp, long payeeId);

	public String delete(long payeeId);

}
