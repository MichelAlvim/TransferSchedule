package com.teste.cvc.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.model.Transfer;
import com.teste.cvc.service.ManageScheduleService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(path = "/api/v1/finTransfer")
public class FinTransferController {

	@Autowired
	private ManageScheduleService manageSchedule;
	
    
    /**
	 * POST: Transfer Schedule.
	 *
	 * @param transfer Transfer data to be processed.
	 * @return the ResponseEntity with status 201 (CREATED)
	 */
	@ApiOperation(value = "Create Shuedule Transfer.")
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> scheduleTransfer(@RequestBody TransferDTO transferDto, HttpServletRequest request) {
		try {
			manageSchedule.save(transferDto);
			return ResponseEntity.created(URI.create("")).body("Schedule transfer done");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("An error occurred contact administrators");
		}
	}
	
	@ApiOperation(value = "Return Schedule Transfer by Origin Account.")
	@GetMapping
    public ResponseEntity<List<Transfer>> getScheduleTransfer(@RequestParam(required = true) String originAccount)   {
        return ResponseEntity.ok().body(manageSchedule.getScheduleByOriginAccount(originAccount));
	}
	
}
