package com.teste.cvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.cvc.dto.TransferDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer implements Serializable{
  	
	public Transfer(TransferDTO transferDTO) {
		setOriginAccount(transferDTO.getOriginAccount());
		setDestinationAccount(transferDTO.getDestinationAccount());
		setValue(transferDTO.getValue());
		setFee(transferDTO.getFee());
		setTransferDate(transferDTO.getTransferDate());
		setSchedulingDate(transferDTO.getSchedulingDate());
	}

		/**
	 * 
	 */
	private static final long serialVersionUID = 527885316574872938L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
		
		@NotNull
	    private String originAccount;
		
		@NotNull
	    private String destinationAccount;
		
		@NotNull
	    private BigDecimal value;
				
	    private BigDecimal fee;
		    
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GMT-3")
	    private LocalDate transferDate;
	    
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GMT-3")
	    private LocalDate schedulingDate;
}
