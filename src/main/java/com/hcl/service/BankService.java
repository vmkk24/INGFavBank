package com.hcl.service;

import com.hcl.dto.BankDetailsDto;

public interface BankService {
	public BankDetailsDto bank(String ibanNumber);
}
