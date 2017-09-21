package com.example.crudexample.dto;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptDTO {
	
	@NotNull(message = "GENERIC_BUSINESS~MANDATORY_PARAMETER~NAME")
	@NotEmpty(message = "GENERIC_BUSINESS~MANDATORY_PARAMETER~NAME")
	@JsonProperty("Receipt Type")
	private String receipt_type;
	
	@NotNull(message = "GENERIC_BUSINESS~MANDATORY_PARAMETER~NAME")
	@NotEmpty(message = "GENERIC_BUSINESS~MANDATORY_PARAMETER~NAME")
	@JsonProperty("Receipt Amount")
	private double receipt_amount;
	
	@NotNull(message = "GENERIC_BUSINESS~MANDATORY_PARAMETER~ADDRESS")
	@NotEmpty(message = "GENERIC_BUSINESS~MANDATORY_PARAMETER~ADDRESS")
	@JsonProperty("Receipt Date")
    private String receipt_date;

	public ReceiptDTO(String receipt_type, double receipt_amount, String receipt_date) {
		super();
		this.receipt_type = receipt_type;
		this.receipt_amount = receipt_amount;
		this.receipt_date = receipt_date;
	}

	public ReceiptDTO() {
		super();
	}

	public String getReceipt_type() {
		return receipt_type;
	}

	public void setReceipt_type(String receipt_type) {
		this.receipt_type = receipt_type;
	}

	public double getReceipt_amount() {
		return receipt_amount;
	}

	public void setReceipt_amount(double receipt_amount) {
		this.receipt_amount = receipt_amount;
	}

	public String getReceipt_date() {
		return receipt_date;
	}

	public void setReceipt_date(String receipt_date) {
		this.receipt_date = receipt_date;
	}
	
	
}
