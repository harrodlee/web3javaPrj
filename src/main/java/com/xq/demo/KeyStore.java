//package com.xq.demo;
//
//import java.io.IOException;
//import java.math.BigInteger;
//
//import org.web3j.crypto.CipherException;
//import org.web3j.crypto.Credentials;
//import org.web3j.crypto.ECKeyPair;
//import org.web3j.crypto.WalletUtils;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.DefaultBlockParameterName;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.utils.Convert;
//import org.web3j.utils.Convert;
//public class KeyStore {
//
//	public static void main(String[] args) throws IOException, CipherException {
//		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
//		Credentials credentials = WalletUtils.loadCredentials("123","./keystore/UTC--2021-04-26T10-41-24.709541000Z--3582b865977d28493a16bb1b0b36f98787a2ad12.json");
//		BigInteger balance = web3j.ethGetBalance(credentials.getAddress(),
//                DefaultBlockParameterName.LATEST).send().getBalance();
//		System.out.println(Convert.fromWei(balance.toString(),Convert.Unit.ETHER));
//	}
//}
