//package com.xq.demo;
//import java.io.IOException;
//
//import org.web3j.crypto.CipherException;
//import org.web3j.crypto.Credentials;
//import org.web3j.crypto.ECKeyPair;
//import org.web3j.crypto.WalletUtils;
//public class AccountCredentials {
//
//	public static void main(String[] args) throws IOException, CipherException {
//		Credentials cre=WalletUtils.loadCredentials("12345678", "./keystore/UTC--2021-05-13T03-46-26.758000000Z--8cb022aa04817f0e23712ff59ac65513580b965b.json");
//		ECKeyPair kp=cre.getEcKeyPair();
//		String privateKey=kp.getPrivateKey().toString(16);
//		String publicKey=kp.getPublicKey().toString(16);
//		String account=cre.getAddress();
//		System.out.println(privateKey);
//		System.out.println(publicKey);
//		System.out.println(account);
//	}
//}
//
//
////solc Voting.sol --bin --abi -optimize --overwrite -o build/