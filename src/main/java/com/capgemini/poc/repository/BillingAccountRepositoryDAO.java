package com.capgemini.poc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.poc.vo.BillingAccountVO;

@Repository
public interface BillingAccountRepositoryDAO extends CrudRepository<BillingAccountVO, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE BillingAccountVO ba SET ba.status = :status WHERE ba.accountID = :accountID")
	void deleteAccount(@Param("accountID") Integer accountID, @Param("status") int status);
}
