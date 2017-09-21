package com.example.crudexample.feature.employee.api.message.response;

import java.util.List;
import javax.validation.constraints.NotNull;

import com.example.crudexample.api.message.response.GenericSuccessResponse;
import com.example.crudexample.dto.ReceiptDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AllReceiptDetailResponse extends GenericSuccessResponse{
	
	@NotNull
	@JsonProperty("result")
	private List<ReceiptDTO> receiptDTO;

	public AllReceiptDetailResponse() {
		
	}

	/**
	 * @return the receiptDTO
	 */
	public List<ReceiptDTO> getEmployeeDTO() {
		return receiptDTO;
	}

	/**
	 * @param receiptDTO the receiptDTO to set
	 */
	public void setReceiptDTO(List<ReceiptDTO> receiptDTO) {
		this.receiptDTO = receiptDTO;
	}
}
