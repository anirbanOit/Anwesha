package com.example.crudexample.feature.receipt.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.crudexample.exception.handler.AppExceptionHandler;
import com.example.crudexample.feature.employee.api.message.response.AllReceiptDetailResponse;
import com.example.crudexample.feature.receipt.bean.ReceiptBean;
import com.example.crudexample.util.TestUtil;
import com.example.crudexample.utils.constant.AppConstant;

public class ReceiptControllerTest {
	
	private MockMvc mockMvc;
	private ReceiptController receiptController;

	@Mock
	private ReceiptBean receiptBean;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.receiptController = new ReceiptController(receiptBean);
		this.mockMvc = MockMvcBuilders.standaloneSetup(receiptController)
				.setControllerAdvice(new AppExceptionHandler()).build();
	}

	@After
	public void tearDown() throws Exception {
		this.receiptBean = null;
		this.mockMvc = null;
		this.receiptController = null;
	}
	
	@Test
	public void test_getAllReceipt_Success() throws Exception {
		String accessorId = "1";
		String sessionToken = "test";
		when(receiptBean.processGetAllReceiptProfile(accessorId, sessionToken)).thenReturn(new AllReceiptDetailResponse());
		mockMvc.perform(get("/receipt/receiptlist?admin_id=1").header("session_token", "test")).andDo(print())
				.andExpect(status().is2xxSuccessful()).andExpect(new ResultMatcher() {
					@Override
					public void match(MvcResult result) throws Exception {
						String successStatusCode = TestUtil.parse((result.getResponse().getContentAsString()));
						System.out.println("Status Code: " + successStatusCode);
						assertEquals(AppConstant.GENERIC_SUCCESS_CODE, successStatusCode);
					}
				});
		verify(receiptBean).processGetAllReceiptProfile(accessorId, sessionToken);
	}
	
	@Test
	public void test_getAllReceipt_Failure_noHeader() throws Exception {
		String statusCode = "0000100101";
		mockMvc.perform(get("/receipt/receiptlist?admin_id=1")).andDo(print()).andExpect(status().is4xxClientError())
				.andExpect(new ResultMatcher() {
					@Override
					public void match(MvcResult result) throws Exception {
						String errorStatusCode = TestUtil.parse((result.getResponse().getContentAsString()));
						System.out.println("Status Code: " + errorStatusCode);
						assertEquals(statusCode, errorStatusCode);
					}
				});
		verify(receiptBean, never()).processGetAllReceiptProfile(anyString(), anyString());
	}
	
	@Test
	public void test_getAllReceipt_Failure_noParam() throws Exception {
		String statusCode = "0000200122";
		mockMvc.perform(get("/receipt/receiptlist").header("session_token", "test")).andDo(print())
				.andExpect(status().is4xxClientError()).andExpect(new ResultMatcher() {
					@Override
					public void match(MvcResult result) throws Exception {
						String errorStatusCode = TestUtil.parse((result.getResponse().getContentAsString()));
						System.out.println("Status Code: " + errorStatusCode);
						assertEquals(statusCode, errorStatusCode);
					}
				});
		verify(receiptBean, never()).processGetAllReceiptProfile(anyString(), anyString());
	}
	
	@Test
	public void test_getAllReceipt_Failure_IncorrectParam() throws Exception {
		String statusCode = "0000200122";
		mockMvc.perform(get("/receipt/receiptlist?admin_i=1").header("session_token", "test")).andDo(print())
				.andExpect(status().is4xxClientError()).andExpect(new ResultMatcher() {
					@Override
					public void match(MvcResult result) throws Exception {
						String errorStatusCode = TestUtil.parse((result.getResponse().getContentAsString()));
						System.out.println("Status Code: " + errorStatusCode);
						assertEquals(statusCode, errorStatusCode);
					}
				});
		verify(receiptBean, never()).processGetAllReceiptProfile(anyString(), anyString());
	}
}
