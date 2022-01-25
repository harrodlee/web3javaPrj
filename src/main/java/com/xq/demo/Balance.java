package com.xq.demo;

import java.io.IOException;
import java.math.BigInteger;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.http.HttpService;


public class Balance {
	public static void main(String[] args) throws IOException {
		Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
		String account=web3.ethAccounts().send().getAccounts().get(6);
		BigInteger balance1=web3.ethGetBalance(account, DefaultBlockParameterName.LATEST).send().getBalance();
		BigInteger balance2=web3.ethGetBalance(account, DefaultBlockParameterName.EARLIEST).send().getBalance();
		BigInteger balance3=web3.ethGetBalance(account, new DefaultBlockParameterNumber(0L)).send().getBalance();
		System.out.println(balance1);
		System.out.println(balance2);
		System.out.println(balance3);
	}
}
