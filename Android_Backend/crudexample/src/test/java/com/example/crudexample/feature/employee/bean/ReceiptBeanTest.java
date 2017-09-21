package com.example.crudexample.feature.employee.bean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import com.example.crudexample.feature.employee.api.message.response.AllReceiptDetailResponse;
import com.example.crudexample.feature.receipt.bean.impl.ReceiptBeanImpl;
import com.example.crudexample.handler.ReceiptHandler;
import com.example.crudexample.handler.RequestValidator;
import com.example.crudexample.mockdata.MockData;
import com.example.crudexample.utils.APIGroupCode;
import com.example.crudexample.utils.constant.AppConstant;

public class ReceiptBeanTest {
	
	private ReceiptBeanImpl receiptBeanImpl;

	@Mock
	private ReceiptHandler receiptHandler;

	@Mock
	private RequestValidator requestValidator;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		receiptBeanImpl = new ReceiptBeanImpl();
		// Using reflection as autowired is not working in bean service
		ReflectionTestUtils.setField(receiptBeanImpl, "receiptHandler", receiptHandler);
		ReflectionTestUtils.setField(receiptBeanImpl, "requestValidator", requestValidator);
	}

	@After
	public void tearDown() throws Exception {
		receiptBeanImpl = null;
		requestValidator = null;
		receiptHandler = null;
	}
	
	@Test
	public void test_processGetAllReceiptProfile_Success() {
		final String errorCodePrefix = APIGroupCode.EMPLOYEE_GET_ALL_USERS.getGroupCode()
				+ APIGroupCode.EMPLOYEE_GET_ALL_USERS.getApiCode() + "000";
		// Mock Data Create
		String accessorIdStr = "1";
		String sessionToken = AppConstant.TOKEN;
		when(receiptHandler.performGetReceiptProfileDetail(errorCodePrefix))
				.thenReturn(MockData.getStubbedReceiptDTOList());
		AllReceiptDetailResponse allReceiptDetailResponse = (AllReceiptDetailResponse) receiptBeanImpl
				.processGetAllReceiptProfile(accessorIdStr, sessionToken);
		verify(receiptHandler).performGetReceiptProfileDetail(errorCodePrefix);

		assertEquals(MockData.getStubbedReceiptDTOList().get(0).getReceipt_type(),
				allReceiptDetailResponse.getEmployeeDTO().get(0).getReceipt_type());
		assertEquals(AppConstant.API_STATUS_OK, allReceiptDetailResponse.getStatusMessage());
	}

}
