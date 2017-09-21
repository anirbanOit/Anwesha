package com.example.crudexample.domain.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crudexample.domain.ReceiptDomain;
import com.example.crudexample.domain.entity.Receipt;
import com.example.crudexample.domain.repo.ReceiptRepo;

@Service("receiptDomain")
public class ReceiptDomainImpl implements ReceiptDomain{
	
	@Autowired(required = true)
	private ReceiptRepo receiptRepo;

	@Override
	public List<Receipt> getAllReceiptsProfile() {
		return receiptRepo.findAll();
	}

}
