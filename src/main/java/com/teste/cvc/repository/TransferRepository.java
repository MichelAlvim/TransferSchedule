package com.teste.cvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teste.cvc.model.Transfer;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

}
