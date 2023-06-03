package com.example.wallet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletRepository;
	
	@KafkaListener(topics= CommonConstants.USER_CREATION_TOPIC)
	public void createWallet(String msg) throws ParseException {
		
		JSONObject data = (JSONObject) new JSONParser().parse(msg);
		
		Long userId = (Long) data.get(CommonConstants.USER_CREATION_TOPIC_USERID);
		String phoneNumber = (String) data.get(CommonConstants.USER_CREATION_TOPIC_PHONE_NUMBER);
		String identifierKey = (String) data.get(CommonConstants.USER_CREATION_TOPIC_IDENTIFIER_KEY);
		String identifierValue = (String) data.get(CommonConstants.USER_CREATION_TOPIC_IDENTIFIER_VALUE);
		
		Wallet wallet = Wallet.builder()
				.userId(userId).phoneNumber(phoneNumber).userIdentifier(UserIdentifier.valueOf(identifierValue))
				.identifierValue(identifierValue).balance(10.0).build();
		walletRepository.save(wallet);
	}

}
