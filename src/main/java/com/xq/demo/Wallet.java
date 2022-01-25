//package com.xq.demo;
//
//import java.io.*;
//import java.security.InvalidAlgorithmParameterException;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//
//import org.web3j.crypto.CipherException;
//import org.web3j.crypto.ECKeyPair;
//import org.web3j.crypto.Keys;
//import org.web3j.crypto.WalletUtils;
//
///**
// * create a wallet
// * @author asahi
// *
// */
//public class Wallet {
//
//	public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException {
//		String pass = "12345678";
//		File destDir = new File("./keystore");
//		ECKeyPair keyPair=Keys.createEcKeyPair();
//		String fn = WalletUtils.generateWalletFile(pass,keyPair,destDir,true);
//		String account=Keys.getAddress(keyPair);
//		System.out.println("FileName: "+fn);
//		System.out.println("AccountAddr: "+account);
//	}
//}
