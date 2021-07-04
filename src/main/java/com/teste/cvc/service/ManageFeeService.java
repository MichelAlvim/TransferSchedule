package com.teste.cvc.service;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.model.Transfer;

public interface ManageFeeService {
	
	/**
	 * Manage fee rules.
	 * 
	 * @param transferDTO TransferDTO
	 * @return Transfer
	 */
	Transfer defineRule(TransferDTO transferDTO);
}
