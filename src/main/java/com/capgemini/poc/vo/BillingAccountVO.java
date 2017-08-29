package com.capgemini.poc.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "BILLING_ACCOUNT")
@Component
@JsonInclude(value = Include.NON_NULL)
public class BillingAccountVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountID;
	@Column(name = "customer_id")
	private Integer customerID;
	@Column(name = "customer_bal")
	private Double currentBalance;
	@Column(name = "unbilled_debits")
	private Double unbilledDebits;
	@Column(name = "unbilled_credits")
	private Double unbilledCredits;
	@Column(name = "unbilled_payments")
	private Double unbilledPayments;
	@JsonIgnore
	@Column(name = "status", columnDefinition = "int default 1")
	private int status = 1;

	public BillingAccountVO(int accountID, int customerID, double currentBalance, double unbilledDebits,
			double unbilledCredits, double unbilledPayments) {
		super();
		this.accountID = accountID;
		this.customerID = customerID;
		this.currentBalance = currentBalance;
		this.unbilledDebits = unbilledDebits;
		this.unbilledCredits = unbilledCredits;
		this.unbilledPayments = unbilledPayments;
	}

	public BillingAccountVO() {
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getUnbilledDebits() {
		return unbilledDebits;
	}

	public void setUnbilledDebits(double unbilledDebits) {
		this.unbilledDebits = unbilledDebits;
	}

	public double getUnbilledCredits() {
		return unbilledCredits;
	}

	public void setUnbilledCredits(double unbilledCredits) {
		this.unbilledCredits = unbilledCredits;
	}

	public double getUnbilledPayments() {
		return unbilledPayments;
	}

	public void setUnbilledPayments(double unbilledPayments) {
		this.unbilledPayments = unbilledPayments;
	}

	@Override
	public String toString() {
		return "BillingAccountDAO [accountID=" + accountID + ", customerID=" + customerID + ", currentBalance="
				+ currentBalance + ", unbilledDebits=" + unbilledDebits + ", unbilledCredits=" + unbilledCredits
				+ ", unbilledPayments=" + unbilledPayments + "]";
	}
}