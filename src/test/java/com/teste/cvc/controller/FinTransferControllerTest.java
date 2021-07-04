package com.teste.cvc.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.cvc.dto.TransferDTO;
import com.teste.cvc.model.Transfer;
import com.teste.cvc.service.ManageScheduleService;

public class FinTransferControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private ManageScheduleService manageScheduleService;
	
	@InjectMocks
	FinTransferController finTransferController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(finTransferController).build();
	}
	
	@Test
	public void GET_SHEDULE() throws Exception {
		
		String originAccount = "123456";
		
		when(manageScheduleService.getScheduleByOriginAccount(originAccount)).thenReturn(loadListSchedules());
		mockMvc.perform(get("/api/v1/finTransfer?originAccount="+originAccount)
					.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].destinationAccount", is("456123")))
				.andDo(print());
		
		verify(manageScheduleService).getScheduleByOriginAccount(originAccount);
		
	}
	

	private TransferDTO requestSchedules() {
		TransferDTO transfer1 = new TransferDTO();
		
		transfer1.setDestinationAccount("456123");	
		transfer1.setOriginAccount("123456");
		
		return transfer1;
	}
	
	private Transfer loadSchedules() {
		Transfer transfer1 = new Transfer();
		
		transfer1.setDestinationAccount("456123");	
		transfer1.setOriginAccount("123456");
		transfer1.setSchedulingDate(LocalDate.now());
		transfer1.setTransferDate(LocalDate.now());
		
		return transfer1;
	}
	
	
	private List<Transfer> loadListSchedules() {
		
		Transfer transfer1 = new Transfer();
		transfer1.setDestinationAccount("456123");	
		transfer1.setOriginAccount("123456");
		transfer1.setSchedulingDate(LocalDate.now());
		transfer1.setTransferDate(LocalDate.now());
		
		
		Transfer transfer2 = new Transfer();
		transfer2.setDestinationAccount("654321");	
		transfer2.setOriginAccount("123456");
		transfer2.setSchedulingDate(LocalDate.now());
		transfer2.setTransferDate(LocalDate.now());
		
		List<Transfer> listTransfer = new ArrayList<>();
		listTransfer.add(transfer1);
		listTransfer.add(transfer2);
		
		return listTransfer;
	}
	
	public static String asJsonString(final Object obj) {
        try {
        	
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
