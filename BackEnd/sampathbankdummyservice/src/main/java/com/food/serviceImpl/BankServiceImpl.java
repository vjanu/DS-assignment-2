package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.food.security.AESEncryption;
import com.food.service.BankService;

public class BankServiceImpl implements BankService{
	
	@Autowired
	AESEncryption aesEncryption;
	
	List<String> creditCardDetails = new ArrayList<>();
	List<String> getcreditCardDetails = new ArrayList<>();
	BankServiceImpl bankService = new BankServiceImpl();
	
	
	//calling the rest method and sending the success message
	@Override
	@RequestMapping(value = "/sampathpay", method = RequestMethod.GET)
    public Map getSampathPay(String creditCardNumber, int cvcNumber, String holderName) {
		if(bankService.ValidateCredentials(creditCardNumber, cvcNumber, holderName)) {
			Map<String,String> sampathMap = new HashMap<>();
			sampathMap.put("sampath", "Bill was successfully paid with your credit card");
			return sampathMap;
		}
		return null;
    }

	//validates the credit card details of the customer using encrypted and decrypted data
	@Override
	public boolean ValidateCredentials(String creditCardNumber, int cvcNumber, String holderName) {
		try {
			String cardNumber = aesEncryption.encrypt(creditCardNumber);
			String cvc = aesEncryption.encrypt(String.valueOf(cvcNumber));
			String name = aesEncryption.encrypt(holderName);
			
			//dummy validation
			getcreditCardDetails = bankService.decryptData(creditCardNumber, cvcNumber, holderName);
			if(getcreditCardDetails.get(0) == creditCardNumber && getcreditCardDetails.get(1) == String.valueOf(cvcNumber)&&
			         getcreditCardDetails.get(2) == holderName) {
				return true;
			}
			
		} catch (Exception e) {
			System.err.println("Encryption cannot be done "+e.getMessage());	
		}
		return false;
	}
	
	//decrypts the credit card details of the customer
	public List<String> decryptData(String creditCardNumber, int cvcNumber, String holderName){
		try {
			creditCardDetails.add(aesEncryption.decrypt(creditCardNumber));
			creditCardDetails.add(aesEncryption.decrypt(String.valueOf(cvcNumber)));
			creditCardDetails.add(aesEncryption.decrypt(holderName));
		} catch (Exception e) {
			System.err.println("Decryption cannot be done "+e.getMessage());
		}
		
		return creditCardDetails;
		
	}
	
	
}
