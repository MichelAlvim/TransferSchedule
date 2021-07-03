package com.teste.cvc.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cvc.model.Transfer;


@RestController
@RequestMapping(path = "/api/v1/finTransfer")
public class FinTransferController {

	
	
	/**
	 * POST: Transfer Schedule.
	 *
	 * @param transfer Transfer data to be processed.
	 * @return the ResponseEntity with status 201 (CREATED)
	 */
	@PostMapping
	public ResponseEntity<String> scheduleTransfer(@RequestBody Transfer transfer, HttpServletRequest request) {
		return ResponseEntity.created(URI.create("")).body("");
	}
}
