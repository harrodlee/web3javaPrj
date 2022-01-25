//package com.xq.demo;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.tx.ClientTransactionManager;
//import org.web3j.tx.Transfer;
//import org.web3j.utils.Convert;
//
//public class ManagedTransaction {
//
//	public static void main(String[] args) throws Exception {
//		Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
//		List<String> accounts=web3.ethAccounts().send().getAccounts();
//		String from=accounts.get(2);
//		String to=accounts.get(4);
//		BigDecimal value=BigDecimal.valueOf(2.39);
//		//System.out.println(value);
//		int attempts = 10;
//		int sleepDuration = 1000;
//		ClientTransactionManager ctm=new ClientTransactionManager(web3,from,attempts,sleepDuration);
//		Transfer  transfer=new Transfer(web3, ctm);
//		TransactionReceipt tr=transfer.sendFunds(to, value,Convert.Unit.ETHER).send();
//	}
//}
