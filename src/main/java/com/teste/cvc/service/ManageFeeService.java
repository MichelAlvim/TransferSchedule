package com.teste.cvc.service;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.exception.TransferException;
import com.teste.cvc.model.Transfer;

public interface ManageFeeService {
	
	/**
	 * Manage fee rules.
	 * 
	 * @param transferDTO TransferDTO
	 * @return Transfer
	 * @throws TransferException 
	 */
	Transfer defineRule(TransferDTO transferDTO) throws TransferException;
}
