package com.teste.cvc.business;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.exception.TransferException;
import com.teste.cvc.model.Transfer;
import com.teste.cvc.service.ManageFeeService;

@Service
public class ManageFeeRuleCServiceImpl implements ManageFeeService{
	
	private static final BigDecimal BETWEEN_10_20 = new BigDecimal("8");
    private static final BigDecimal BETWEEN_20_30 = new BigDecimal("6");
    private static final BigDecimal BETWEEN_30_40 = new BigDecimal("4");
    private static final BigDecimal ABOVE_40 = new BigDecimal("2");
    private static final BigDecimal ABOVE_100000 = new BigDecimal("100000");

	
	@Override
	public Transfer defineRule(TransferDTO transferDTO) throws TransferException {
		transferDTO.setFee((transferDTO.getValue().multiply(getPercent(transferDTO))));
		Transfer transfer = new Transfer(transferDTO);        
	    return transfer;
	}
	
	private BigDecimal getPercent(TransferDTO transferDto) throws TransferException {
		BigDecimal percent = BigDecimal.ZERO;
        if (transferDto.getDays() > 10 && transferDto.getDays() <=20) {
            percent = BETWEEN_10_20.divide(new BigDecimal(100));
        } else if( transferDto.getDays() >20 && transferDto.getDays() <=30) {
            percent = BETWEEN_20_30.divide(new BigDecimal(100));
        } else if ( transferDto.getDays() >30 && transferDto.getDays() <=40) {
            percent = BETWEEN_30_40.divide(new BigDecimal(100));
        } else if (transferDto.getDays() > 40 && transferDto.getValue().compareTo(ABOVE_100000) > 0) {
            percent = ABOVE_40.divide(new BigDecimal(100));
        }else {
        	throw new TransferException("There is no fee rule for this situation." );
        }
        return percent ;
    }
}
