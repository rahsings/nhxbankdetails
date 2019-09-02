package com.org.thewitchking.bankdetails.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.thewitchking.bankdetails.model.Bank_Branches;

public interface BankRepo extends JpaRepository<Bank_Branches,String>{
	
    @Query("SELECT e FROM Bank_Branches e WHERE LOWER(e.branch) LIKE LOWER(CONCAT('%',:branch, '%'))"+
    " ORDER BY e.ifsc")
	List<Bank_Branches> findBankByBranchIgnoreCase(final String branch);
	
	@Query("SELECT e FROM Bank_Branches e WHERE " +
            "LOWER(e.branch) LIKE LOWER(CONCAT('%',:branch, '%')) OR " +
            "LOWER(e.city) LIKE LOWER(CONCAT('%',:city, '%')) OR "+
            "LOWER(e.address) LIKE LOWER(CONCAT('%',:address, '%')) OR "+
            "LOWER(e.ifsc) LIKE LOWER(CONCAT('%',:ifsc, '%')) OR "+
            "LOWER(e.bank_name) LIKE LOWER(CONCAT('%',:name, '%')) OR "+
            "LOWER(e.district) LIKE LOWER(CONCAT('%',:district, '%')) OR "+
            "LOWER(e.state) LIKE LOWER(CONCAT('%',:state, '%')) "+
            "ORDER BY e.ifsc")
	List<Bank_Branches> findBankByAllIgnoreCase(String city,String address,String name,String state,String 
			district,String branch,String ifsc);

}
