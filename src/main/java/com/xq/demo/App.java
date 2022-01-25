package com.xq.demo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.http.HttpService;

public class App {

	public static void main(String[] args) throws IOException {
		Web3j web3 = Web3j.build(new HttpService("https://http-testnet.huobichain.com"));


//		for(int i=0;i<accounts.size();i++){
//			System.out.println(accounts.get(i));
//
//		}
//		String clientVersion  = web3.web3ClientVersion().send().getWeb3ClientVersion();
//		System.out.println("Client version: " + clientVersion);

//		Web3ClientVersion web3ClientVersion;
//		try {
//			web3ClientVersion = web3.web3ClientVersion().send();
//			String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//			System.out.println(clientVersion);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Request<?,EthAccounts> request = web3.ethAccounts();
//
//		for (Iterator iterator = accounts.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//			System.out.println("accout: "+string);
//		}
	}
}
