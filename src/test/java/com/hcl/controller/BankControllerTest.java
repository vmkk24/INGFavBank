package com.hcl.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.dto.BankDetailsDto;
import com.hcl.service.BankService;

@RunWith(MockitoJUnitRunner.class)
public class BankControllerTest {

	@Mock
	BankService bankService;
	
	@InjectMocks
	BankController bankController;
	
	BankDetailsDto BankDetailsDto = null;
	
	@Before
	public void setup() {
		BankDetailsDto = new BankDetailsDto();
		BankDetailsDto.setStatusCode(200);
	}
	
	@Test
	public void bankTest() {
		Mockito.when(bankService.bank(Mockito.anyString())).thenReturn(BankDetailsDto);
		ResponseEntity<BankDetailsDto> responseEntity = bankController.bank(Mockito.anyString());
		BankDetailsDto baDetailsDto = responseEntity.getBody();
		assertEquals(BankDetailsDto.getStatusCode(), baDetailsDto.getStatusCode());
	}
}
