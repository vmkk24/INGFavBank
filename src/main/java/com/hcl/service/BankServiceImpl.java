package com.hcl.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.BankDetailsDto;
import com.hcl.entity.Bank;
import com.hcl.exception.IngBankException;
import com.hcl.repository.BankRepository;
import com.hcl.util.IngConstants;

/**
 * 
 * @author Lakshmi
 */
@Service
public class BankServiceImpl implements BankService{

	private static final Logger LOGGER = LoggerFactory.getLogger(BankServiceImpl.class);
	
	@Autowired
	BankRepository bankRepository;
	
	/**
	 * This method is intended for bank details of customer
	 * @param ibanNumber
	 * @return BankDetailsDto
	 */
	public BankDetailsDto bank(String ibanNumber) {
		
		LOGGER.debug("BankServiceImpl bank");
		BankDetailsDto bankDetailsDto = new BankDetailsDto();
		String result;
		if(ibanNumber.length()>=20) {
			result = ibanNumber.substring(4,8);
		}
		else {
			throw new IngBankException(IngConstants.IBAN_NOT_VALID);
		}
		Integer bankCode = Integer.parseInt(result);
		List<Bank> banks = bankRepository.findByBankCode(bankCode);
		if(banks.isEmpty()) {
			throw new IngBankException(IngConstants.BANK_NAME_NOT_FOUND);
		}
		else {
			Bank bank = banks.get(0);
			BeanUtils.copyProperties(bank, bankDetailsDto);
		}
		return bankDetailsDto;
	}

}
