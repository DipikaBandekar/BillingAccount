package com.capgemini.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.poc.repository.BillingAccountRepositoryDAO;
import com.capgemini.poc.vo.BillingAccountVO;

@Service
public class BillingAccountService {

<<<<<<< HEAD
	
=======
>>>>>>> b1c9eb699512c0d42a4adfa2c1adb9de56cff2bf
	@Autowired
	private BillingAccountRepositoryDAO billingAccountRepository;

	public BillingAccountVO findAccountById(Integer id) {
		return billingAccountRepository.findOne(id);
	}

	public BillingAccountVO saveAccount(BillingAccountVO billingAccount) {
		return billingAccountRepository.save(billingAccount);
	}

	public void deleteAccount(Integer id, int status) {
		billingAccountRepository.deleteAccount(id, status);
		
		
	}

}
