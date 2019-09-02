package com.org.thewitchking.bankdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.thewitchking.bankdetails.model.Bank_Branches;
import com.org.thewitchking.bankdetails.repo.BankRepo;

@Service
public class BankService{

	@Autowired 
	BankRepo bankRepo;
	
//    public List<Bank_Branches> getAllBanks() {
//    	List<Bank_Branches> listAll=bankRepo.findAll();
//    	return listAll;
//    }
    
    public List<Bank_Branches> getBankByBranch(String branch,int offset,int limit) {
    	List<Bank_Branches> bankBranch = bankRepo.findBankByBranchIgnoreCase(branch);
        return bankBranch.subList(offset,offset+limit);
    }
    
    public List<Bank_Branches> getBankByAll(String id,int offset,int limit) {
    	List<Bank_Branches> bankBranch = bankRepo.findBankByAllIgnoreCase(id,id,id,id,id,id,id);
        return bankBranch.subList(offset,offset+limit);
    }
}
