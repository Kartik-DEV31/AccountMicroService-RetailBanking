package com.retailBanking.accountsService.Models;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction {
	
	private double transactionId;
	   private double amount;
	   
	   @JsonFormat(pattern="dd-MM-yyyy")
	   private LocalDate date;

	public double getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(double transactionId, double amount, LocalDate date) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", date=" + date + "]";
	}

	
	
	
	   
	   
		

}