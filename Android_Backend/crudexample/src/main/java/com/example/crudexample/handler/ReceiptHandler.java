package com.example.crudexample.handler;

import java.util.List;

import com.example.crudexample.dto.ReceiptDTO;

public interface ReceiptHandler {

	List<ReceiptDTO> performGetReceiptProfileDetail(String errorCodePrefix);

}
