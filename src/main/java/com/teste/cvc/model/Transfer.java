package com.teste.cvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Transfer implements Serializable{
	  	/**
	 * 
	 */
	private static final long serialVersionUID = 527885316574872938L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String originAccount;

	    private String destinationAccount;

	    private BigDecimal value;

	    private BigDecimal fee;

	    private LocalDate transferDate;

	    private LocalDate schedulingDate;
}
