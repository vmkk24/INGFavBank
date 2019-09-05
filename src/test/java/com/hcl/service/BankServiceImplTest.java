package com.hcl.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.dto.BankDetailsDto;
import com.hcl.entity.Bank;
import com.hcl.repository.BankRepository;

@RunWith(MockitoJUnitRunner.class)
public class BankServiceImplTest {

	@Mock
	BankRepository bankRepository;
	
	@InjectMocks
	BankServiceImpl bankServiceImpl;

	BankDetailsDto bankDetailsDto = null;
	Bank bank = null;
	List<Bank> banks = null;
	
	@Before
	public void setup() {
		bankDetailsDto = new BankDetailsDto();
		bankDetailsDto.setStatusCode(200);
		
		bank = new Bank();
		bank.setBankCode(1234);
		
		banks = new ArrayList<>();
		banks.add(bank);
	}
	
	@Test
	public void bankSuccessTest() {
		Mockito.when(bankRepository.findByBankCode(Mockito.anyInt())).thenReturn(banks);
		BankDetailsDto bankDetails = bankServiceImpl.bank(Mockito.anyString());
		assertEquals(bankDetailsDto.getStatusCode(), bankDetails.getStatusCode());
	}
	@Test
	public void bankNumberTest() {
		bankDetailsDto = new BankDetailsDto();
		bankDetailsDto.setStatusCode(200);
		
		Mockito.when(bankRepository.findByBankCode(Mockito.anyInt())).thenReturn(banks);
		BankDetailsDto bankDetails = bankServiceImpl.bank("ES01234567");
		assertEquals(bankDetailsDto.getStatusCode(), bankDetails.getStatusCode());
	}
}
