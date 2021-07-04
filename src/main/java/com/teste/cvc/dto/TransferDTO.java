package com.teste.cvc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TransferDTO {
	
	private String originAccount;
	
	private String destinationAccount;
	
	private BigDecimal value;
			
    private BigDecimal fee;
    
    private Long days;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GMT-3")
    private LocalDate transferDate = LocalDate.now(); 
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GMT-3")
    private LocalDate schedulingDate = LocalDate.now();
   
}
