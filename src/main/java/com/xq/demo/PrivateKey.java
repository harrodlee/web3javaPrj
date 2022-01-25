package com.xq.demo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

public class PrivateKey {

	public static void main(String[] args) {
		
		BigInteger privateKey = new BigInteger("b1323cb0ab672b491cbc502bc39ddc342b9c307536708207db104c52f2f2f746",16);
		//ECKeyPair keyPair = ECKeyPair.create(privateKey);
//		String account=Keys.getAddress(keyPair);
//		String publicKey=keyPair.getPublicKey().toString(16);
//		System.out.println("publicKey: "+publicKey);
//		System.out.println("account: "+"0x"+account);


		List<BigInteger> privateKeyList=new ArrayList();
		privateKeyList.add(new BigInteger("6A647C6A869474297A8A894BE3F5909075912BFCB5AECC563AE357EDFA96A164",16));
		privateKeyList.add(new BigInteger("FE06352F8C5F4682C8ACD043DB7016A0D1E77076EEFCE5DEA9EE7C2F793835F1",16));
		privateKeyList.add(new BigInteger("8A1C48BD7157668B4CCD3EDCFD4940E7E34304AEA196F1C126F4C5714D388D5A",16));
		privateKeyList.add(new BigInteger("C2112BFAE4A13BFB40B06AAD7778FD3B279B15DF84F0B19CBC9BCA6CE4D31562",16));
		privateKeyList.add(new BigInteger("4949A3B3DC7076436483CA9806D804DC6EBF6180217B958F529DC7750CBFF51A",16));
		privateKeyList.add(new BigInteger("89DCA44C8613BD04C56B3DC8A720723EF5DDAD153C1CCBCF102E53CD928DBFEE",16));
		privateKeyList.add(new BigInteger("3B5AF75ABA6329887D13577CC51D62DBC7CDA44A031152806330F97846033D28",16));
		privateKeyList.add(new BigInteger("87F511AFB4CD378D6F461AF3A14FE78EEC59A9355F2F0E1D3CBA4ECAE2C05043",16));
		privateKeyList.add(new BigInteger("86D9064F13806DEE4587A919BDB51B8B5CC944467C158B76C2A362B2FD197466",16));
		privateKeyList.add(new BigInteger("86A06FBBE5098BBF300E14036956551339B00B4CBCA46D3A06C520FF1C2B9AF9",16));

		ECKeyPair keyPair;
		for (int i=0;i<privateKeyList.size();i++){
			keyPair=ECKeyPair.create(privateKeyList.get(i));
			System.out.println(Keys.getAddress(keyPair));
		}
	}
}
