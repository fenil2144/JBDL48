package com.example.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{
	
	Wallet findByPhoneNumber(String phoneNumber);
	
	@Query("update Wallet w set w.balance = w.balance+ ?1 where w.phoneNumber = ?2")
	void updateWallet(Double amount, String phoneNumber);

	
}
