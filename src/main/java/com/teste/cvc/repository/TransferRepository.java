package com.teste.cvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.cvc.model.Transfer;


public interface TransferRepository extends JpaRepository<Transfer, Long> {

	List<Transfer> findByOriginAccount(String originAccount);

}
