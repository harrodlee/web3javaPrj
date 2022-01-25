//package com.xq.demo;
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.util.List;
//import java.util.Optional;
//
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.request.Transaction;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.utils.Convert;
//
//public class Transactions {
//
//	public static void main(String[] args) throws IOException, InterruptedException {
//		Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
//		List<String> accounts=web3.ethAccounts().send().getAccounts();
//		String to=accounts.get(2);
//		String from=accounts.get(4);
//		BigInteger gasPrice=Convert.toWei("20",Convert.Unit.GWEI).toBigInteger();
//		BigInteger gasLimit=BigInteger.valueOf(60000);
//		BigInteger value=BigInteger.valueOf(1000000000000000000L);
//		BigInteger nonce=null;
//		String data=null;
//		Transaction tx=new Transaction(from, nonce, gasPrice, gasLimit, to, value, data);
//		String txHash=web3.ethSendTransaction(tx).send().getTransactionHash();
//		//System.out.println(txHash);
//
//		long timeout = 300000L;
//		long t0 = System.currentTimeMillis();
//		Optional<TransactionReceipt> receipt = null;
//		while(true){
//		  receipt = web3.ethGetTransactionReceipt(txHash).send().getTransactionReceipt();
//		  TransactionReceipt tr=receipt.get();
//		  if(receipt.isPresent()){
//			    System.out.println("tx receipt =>");
//			    System.out.println("tx hash: " + tr.getTransactionHash());
//			    System.out.println("tx index: " + tr.getTransactionIndex());
//			    System.out.println("block hash: " + tr.getBlockHash());
//			    System.out.println("block number: " + tr.getBlockNumber());
//			    System.out.println("cumulativeGasUsed: " + tr.getCumulativeGasUsed());
//			    System.out.println("gas used: " + tr.getGasUsed());
//			    System.out.println("contractAddress: " + tr.getContractAddress());
//			    System.out.println("root: " + tr.getRoot());
//			    System.out.println("status: " + tr.getStatus());
//			    System.out.println("from: " + tr.getFrom());
//			    System.out.println("to: " + tr.getTo());
//			    System.out.println("logs: " + tr.getLogs());
//			    System.out.println("logsBloom: " + tr.getLogsBloom());
//			  break;
//
//		  }
//		  if((System.currentTimeMillis() - t0) > timeout) {
//			  System.out.println("transaction timeout");
//			  break;
//		  }
//		  Thread.sleep(1000*1);
//		}
//	}
//}
