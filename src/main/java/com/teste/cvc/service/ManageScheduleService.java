package com.teste.cvc.service;

import java.util.List;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.exception.TransferException;
import com.teste.cvc.model.Transfer;

public interface ManageScheduleService {
	
	/**
	 * @param transferDto 
	 * @return {@link Transfer}
	 * @throws TransferException 
	 */
	Transfer save(TransferDTO transferDto) throws TransferException;
	
	/**
     * @param originAccount 
	 * @return List <{@link Transfer}>
	 */
	List<Transfer> getScheduleByOriginAccount(String originAccount);
}
