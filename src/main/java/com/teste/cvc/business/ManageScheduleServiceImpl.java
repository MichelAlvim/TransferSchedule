package com.teste.cvc.business;

import static java.time.temporal.ChronoUnit.DAYS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.exception.TransferException;
import com.teste.cvc.factory.PrepareFeeFactory;
import com.teste.cvc.model.Transfer;
import com.teste.cvc.repository.TransferRepository;
import com.teste.cvc.service.ManageFeeService;
import com.teste.cvc.service.ManageScheduleService;

@Service
public class ManageScheduleServiceImpl implements ManageScheduleService{
	
	private TransferRepository transferRepository;
	
	@Autowired
	private PrepareFeeFactory factory;
	
	/**
	 * Construtor padrao.
	 */
	@Autowired
	public ManageScheduleServiceImpl(TransferRepository transferRepository) {
		this.transferRepository = transferRepository;
	}
	
	@Override
	public Transfer save(TransferDTO transferDto) throws TransferException {
		return transferRepository.save(processScedule(transferDto));
		//return null;
	}
	
	private Transfer processScedule(TransferDTO transferDto) throws TransferException {
		 try{
			 
			transferDto.setDays(DAYS.between(transferDto.getTransferDate(), transferDto.getSchedulingDate()));
			
			ManageFeeService manageFee;
			manageFee = factory.getFactoryPrepareFee(transferDto);
			Transfer transfer = manageFee.defineRule(transferDto);
			
			return transfer;		
		
		 } catch (TransferException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		return null;
	}
	
	@Override
	public List<Transfer> getScheduleByOriginAccount(String originAccount) {
		try {
			return transferRepository.findByOriginAccount(originAccount);
		} catch (Exception e) {
			return null;
		}
		
	}
}
