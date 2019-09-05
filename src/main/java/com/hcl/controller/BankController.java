package com.hcl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.BankDetailsDto;
import com.hcl.service.BankService;

/**
 * 
 * @author Lakshmi
 */
@RestController
@CrossOrigin(origins = {"*","*/"},allowedHeaders = {"*","*/"})
public class BankController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BankController.class);
	
	@Autowired
	BankService bankService;
	
	/**
	 * This method is intended for login of customer
	 * @param ibanNumber
	 * @return BankDetailsDto
	 */
	@GetMapping("/bank/{ibanNumber}")
	public ResponseEntity<BankDetailsDto> bank(@PathVariable("ibanNumber") String ibanNumber){
		LOGGER.debug("BankController bank()");
		BankDetailsDto bankDetailsDto = bankService.bank(ibanNumber);
		return new ResponseEntity<>(bankDetailsDto,HttpStatus.OK);
	}
}
