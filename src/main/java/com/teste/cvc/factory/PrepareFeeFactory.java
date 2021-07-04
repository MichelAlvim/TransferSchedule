package com.teste.cvc.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teste.cvc.business.ManageFeeRuleAServiceImpl;
import com.teste.cvc.business.ManageFeeRuleBServiceImpl;
import com.teste.cvc.business.ManageFeeRuleCServiceImpl;
import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.exception.TransferException;
import com.teste.cvc.service.ManageFeeService;

@Component
public class PrepareFeeFactory {

	@Autowired
	private ManageFeeRuleAServiceImpl manageFeeA;
	
	@Autowired
	private ManageFeeRuleBServiceImpl manageFeeB;
	
	@Autowired
	private ManageFeeRuleCServiceImpl manageFeeC;
	
	/**
	 * Responsible for identifying the correct implementation.
	 * 
	 * @param transferDto TransferDTO
	 * @return ManageFeeService
	 * @throws TransferException 
	 */
	public ManageFeeService getFactoryPrepareFee(TransferDTO transferDto) throws TransferException{
		if(transferDto.getDays() == 0) {
			return manageFeeA;
		}else if (null != transferDto.getDays() && transferDto.getDays() > 0 && transferDto.getDays() <= 10) {
            return manageFeeB;
        } else if (null != transferDto.getDays() && transferDto.getDays() > 10) {
            return manageFeeC;
        } else {
        	throw new TransferException("There is no fee rule for this situation." );
    	}	
	}
}