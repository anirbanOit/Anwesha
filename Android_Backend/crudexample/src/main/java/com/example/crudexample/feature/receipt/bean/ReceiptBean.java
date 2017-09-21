package com.example.crudexample.feature.receipt.bean;

import com.example.crudexample.api.message.response.AbstractResponse;

public interface ReceiptBean {

	public AbstractResponse processGetAllReceiptProfile(String accessorIdStr, String sessionToken);

}
