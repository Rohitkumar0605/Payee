package com.hcl.payee.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.payee.entity.Payee;
import com.hcl.payee.repository.PayeeRepository;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	Long otp1;

	@Override
	public String validateOtp(long id, long otp) {
		payeeRepository.deleteById(id);
		return "Successfully deleted Payee";

	}

	@Override
	public String delete(long payeeId) {
		Payee payee = payeeRepository.findById(payeeId).get();
		if (payee != null) {
			String otp = random(6);
			Long otp1 = Long.parseLong(otp);

			/*
			 * try { PayeeServiceImpl payeeServiceImpl = new PayeeServiceImpl();
			 * //payeeServiceImpl.sendMail();
			 * 
			 * return "OTP genarated and sent to your email id sucessfully"; } catch
			 * (Exception e) {
			 * 
			 * return "internalpblm";
			 * 
			 * }
			 */
		} else {
			return "can you please send proper payeeId";
		}

		return "success";
	}

	public String random(int size) {

		StringBuilder generatedToken = new StringBuilder();
		try {
			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
			// Generate 20 integers 0..20
			for (int i = 0; i < size; i++) {
				generatedToken.append(number.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedToken.toString();
	}

	/*
	 * private void sendMail() throws Exception { >>>>>>> development
	 * SimpleMailMessage message = new SimpleMailMessage();
	 * message.setTo("haricg8@gmail.com"); message.setSubject("This is subject");
	 * message.setText("otp1"); try { // System.out.println("emailSender ======>> "
	 * + emailSender); // emailSender.send(message);
	 * System.out.println("Email sent..."); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * <<<<<<< HEAD } ======= }
	 */

	@Override
	public void addPayee(Payee payee) {
		String str = random(6);
		Long i = new Long(str);
		System.out.println("otp" + i);
		payee.setOtp(i);
		String str1 = random(6);
		long otp = Long.parseLong(str1);
		System.out.println("otp" + otp);
		payee.setOtp(otp);
		payee.setFlag(false);

		payeeRepository.save(payee);

	}

	@Override
	public String validatePayee(long otp, long payeeId) {
		Payee payee = payeeRepository.getOne(payeeId);
		if (payee.getOtp() == otp) {
			payee.setFlag(true);
			payeeRepository.save(payee);

			return "Payee is registered successfully";
		}
		return "Payee is registered successfully";
	}

}
