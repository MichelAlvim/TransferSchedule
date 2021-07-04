package com.teste.cvc.business;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.model.Transfer;
import com.teste.cvc.service.ManageFeeService;

@Service
public class ManageFeeRuleBServiceImpl implements ManageFeeService{
	
	private static final Integer FEE_B = 12;
	
	@Override
	public Transfer defineRule(TransferDTO transferDTO) {
		transferDTO.setFee(new BigDecimal(transferDTO.getDays() * FEE_B));
		Transfer transfer = new Transfer(transferDTO);        
	    return transfer;
	}
}
