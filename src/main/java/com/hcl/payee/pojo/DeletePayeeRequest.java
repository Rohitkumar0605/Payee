package com.hcl.payee.pojo;

import java.io.Serializable;

public class DeletePayeeRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private long otp;

	public DeletePayeeRequest() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "DeletePayeeRequest [id=" + id + ", otp=" + otp + "]";
	}

}
