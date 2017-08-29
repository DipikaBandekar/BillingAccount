package com.capgemini.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.poc.service.BillingAccountService;
import com.capgemini.poc.vo.BillingAccountVO;

@RestController
@RequestMapping("/billingAccount")
public class BillingAccountController {

	@Autowired
	private BillingAccountService service;

	private final int INACTIVE = 2;

	@GetMapping(value = "/accountId/{id}", produces = "application/json")
	public ResponseEntity getAccountById(@PathVariable(required = true) Integer id) {
		try {
			BillingAccountVO billingAccount = service.findAccountById(id);
			return new ResponseEntity(billingAccount, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Error finding Account Details", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/addAccount", produces = "application/json")
	public ResponseEntity saveAccount(@RequestBody BillingAccountVO billingAccount) {
		try {
			service.saveAccount(billingAccount);
			return new ResponseEntity("Account saved successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Error Adding Account", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateAccount", produces = "application/json")
	public ResponseEntity updateAccount(@RequestBody(required = true) BillingAccountVO billingAccount) {
		try {
			service.saveAccount(billingAccount);
			return new ResponseEntity(billingAccount, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Error Updating Account Details", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/deleteAccount/{id}", produces = "application/json")
	public ResponseEntity deleteAccount(@PathVariable(required = true) Integer id) {
		try {
			service.deleteAccount(id, INACTIVE);
			return new ResponseEntity("Account deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Error Deleting the Account", HttpStatus.NOT_FOUND);
		}
	}
}
