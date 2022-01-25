package com.xq.demo;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

public class Key {

	public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
		ECKeyPair keyPair=Keys.createEcKeyPair();//创建账户privatekey and publickey
		String privateKey=keyPair.getPrivateKey().toString(16);
		String publicKey=keyPair.getPublicKey().toString(16);
		//用公钥获取账户地址
		String account=Keys.getAddress(publicKey);



		System.out.println("privateKey:"+privateKey);
		System.out.println("publicKey:"+publicKey);
		System.out.println("account:"+account);
	}
}
