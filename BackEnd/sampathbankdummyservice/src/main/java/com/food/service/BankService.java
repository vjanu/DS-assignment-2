package com.food.service;

import java.util.Map;

public interface BankService {
	Map getSampathPay(String creditCardNumber, int cvcNumber, String holderName);
	boolean ValidateCredentials(String creditCardNumber, int cvvcNumber, String holderName);
}
