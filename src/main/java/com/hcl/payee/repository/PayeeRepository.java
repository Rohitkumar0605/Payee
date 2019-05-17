package com.hcl.payee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.payee.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {
	


}