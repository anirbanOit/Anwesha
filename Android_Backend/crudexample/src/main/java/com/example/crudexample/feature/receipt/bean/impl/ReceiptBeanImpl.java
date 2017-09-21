package com.example.crudexample.feature.receipt.bean.impl;

import java.util.List;
import javax.inject.Inject;
import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crudexample.api.message.response.AbstractResponse;
import com.example.crudexample.dto.ReceiptDTO;
import com.example.crudexample.feature.employee.api.message.response.AllReceiptDetailResponse;
import com.example.crudexample.feature.receipt.bean.ReceiptBean;
import com.example.crudexample.handler.ReceiptHandler;
import com.example.crudexample.handler.RequestValidator;
import com.example.crudexample.utils.APIGroupCode;
import com.example.crudexample.utils.AppUtil;
import com.example.crudexample.utils.log.AppLog;

@Service("receiptBean")
public class ReceiptBeanImpl implements ReceiptBean{

	@Autowired(required = true)
	private ReceiptHandler receiptHandler;

	@Autowired(required = true)
	private RequestValidator requestValidator;

	private final AppLog appLog;

	@Inject
	public ReceiptBeanImpl() {
		appLog = AppLog.getInstance(getClass());
	}

	
	@Override
	public AbstractResponse processGetAllReceiptProfile(String accessorIdStr, String sessionToken) {
		
		final String errorCodePrefix = APIGroupCode.RECEIPT_GET_ALL.getGroupCode()
				+ APIGroupCode.RECEIPT_GET_ALL.getApiCode() + "000";

		String beanServiceName = "processGetAllReceiptProfile";

		appLog.printLog(Level.DEBUG, beanServiceName, " Accessor ID:" + accessorIdStr);

		// Validating Permissions & Session Token
		requestValidator.validateAuthToken(sessionToken, beanServiceName, errorCodePrefix);
		requestValidator.validateEMRId(accessorIdStr, errorCodePrefix);

		List<ReceiptDTO> receiptDTOs = receiptHandler.performGetReceiptProfileDetail(errorCodePrefix);

		AllReceiptDetailResponse getAllReceiptDetailResponse = new AllReceiptDetailResponse();
		appLog.printLog(Level.DEBUG, beanServiceName, AppUtil.convertObjectToJson(getAllReceiptDetailResponse));
		getAllReceiptDetailResponse.setReceiptDTO(receiptDTOs);

		return getAllReceiptDetailResponse;
	}


}
