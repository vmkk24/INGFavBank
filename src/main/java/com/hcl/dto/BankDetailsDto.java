package com.hcl.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankDetailsDto implements Serializable{

	private static final long serialVersionUID = -5123563162222506239L;

	private String bankName;
}
