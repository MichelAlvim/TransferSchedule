package com.teste.cvc.business;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.model.Transfer;
import com.teste.cvc.service.ManageFeeService;

@Service
public class ManageFeeRuleAServiceImpl implements ManageFeeService{
	
	private static final BigDecimal FEE_A = new BigDecimal("3");
	
	@Override
	public Transfer defineRule(TransferDTO transferDTO) {
		transferDTO.setFee((transferDTO.getValue().divide(new BigDecimal("100")).multiply(FEE_A)).add(FEE_A));
		Transfer transfer = new Transfer(transferDTO);        
	    return transfer;
	}
}
