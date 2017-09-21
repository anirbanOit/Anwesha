package com.example.crudexample.handler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import com.example.crudexample.domain.ReceiptDomain;
import com.example.crudexample.dto.ReceiptDTO;
import com.example.crudexample.exception.NotFoundException;
import com.example.crudexample.handler.impl.ReceiptHandlerImpl;
import com.example.crudexample.mockdata.MockData;
import com.example.crudexample.utils.APIGroupCode;

public class ReceiptHandlerTest {
	
	private ReceiptHandlerImpl receiptHandlerImpl;
	
	@Mock
	private ReceiptDomain receiptDomain;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@After
	public void tearDown() throws Exception {
		receiptHandlerImpl = null;
		receiptDomain = null;
	}
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		receiptHandlerImpl = new ReceiptHandlerImpl();
		// Using reflection as autowired is not working in bean service
		ReflectionTestUtils.setField(receiptHandlerImpl, "receiptDomain", receiptDomain);
	}
	
	@Test
	public final void test_performGetReceiptProfileDetail_Success() {
		final String errorCodePrefix = APIGroupCode.RECEIPT_GET_ALL.getGroupCode()
				+ APIGroupCode.RECEIPT_GET_ALL.getApiCode() + "000";

		when(receiptDomain.getAllReceiptsProfile()).thenReturn(MockData.getStubbedReceiptList());

		List<ReceiptDTO> receiptDTO = receiptHandlerImpl.performGetReceiptProfileDetail(errorCodePrefix);

		verify(receiptDomain).getAllReceiptsProfile();

		assertEquals(MockData.getStubbedReceiptList().get(0).getReceipt_type(), receiptDTO.get(0).getReceipt_type());
	}
	
	@Test(expected = NotFoundException.class)
	public final void test_performGetReceiptProfileDetail_Users_Null() {
		final String errorCodePrefix = APIGroupCode.RECEIPT_GET_ALL.getGroupCode()
				+ APIGroupCode.RECEIPT_GET_ALL.getApiCode() + "000";

		when(receiptDomain.getAllReceiptsProfile()).thenReturn(null);

		List<ReceiptDTO> receiptDTO = receiptHandlerImpl.performGetReceiptProfileDetail(errorCodePrefix);

		verify(receiptDomain).getAllReceiptsProfile();
	}
	
	@Test(expected = NotFoundException.class)
	public final void test_performGetReceiptProfileDetail_Users_Empty() {
		final String errorCodePrefix = APIGroupCode.RECEIPT_GET_ALL.getGroupCode()
				+ APIGroupCode.RECEIPT_GET_ALL.getApiCode() + "000";

		when(receiptDomain.getAllReceiptsProfile()).thenReturn(new ArrayList<>());

		List<ReceiptDTO> receiptDTO = receiptHandlerImpl.performGetReceiptProfileDetail(errorCodePrefix);

		verify(receiptDomain).getAllReceiptsProfile();
	}
}
