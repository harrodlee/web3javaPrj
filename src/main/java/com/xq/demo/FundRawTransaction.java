package com.xq.demo;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

public class FundRawTransaction {
	public static void main(String[] args) throws Exception {
//		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
//		List<String> accounts = web3j.ethAccounts().send().getAccounts();
//		Credentials credentials = WalletUtils.loadCredentials("123","./keystore/UTC--2021-04-26T10-41-24.709541000Z--3582b865977d28493a16bb1b0b36f98787a2ad12.json");
//		String from = accounts.get(8);
//		String to = credentials.getAddress();
//		System.out.println(to);
//		BigDecimal value = BigDecimal.valueOf(50);
//		ClientTransactionManager ctm = new ClientTransactionManager(web3j,from);
//		Transfer transfer = new Transfer(web3j,ctm);
//		TransactionReceipt receipt = transfer.sendFunds(to,value,Convert.Unit.ETHER).send();


		Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
		List<String> accounts = web3.ethAccounts().send().getAccounts();
		Credentials credentials = WalletUtils.loadCredentials("123","./keystore/UTC--2021-04-26T10-41-24.709541000Z--3582b865977d28493a16bb1b0b36f98787a2ad12.json");
		String to = accounts.get(1);
		System.out.println(to);
		BigDecimal wei = Convert.toWei("8000000000",Convert.Unit.GWEI);
		BigDecimal value= Convert.fromWei(wei, Convert.Unit.ETHER);
		System.out.println(value);
		RawTransactionManager ctm = new RawTransactionManager(web3,credentials);
		Transfer transfer = new Transfer(web3,ctm);
		System.out.println("raw transfer...");
		TransactionReceipt receipt = transfer.sendFunds(to,value,Convert.Unit.ETHER).send();
		System.out.println("receipt => " + receipt);
	}
}
