package com.xq.demo;

import java.math.BigDecimal;

import org.web3j.utils.Convert;

public class WeiConversion {
	public static void main(String []args) {
	BigDecimal wei = Convert.toWei("20",Convert.Unit.GWEI);
	BigDecimal weiFinney = Convert.toWei("5",Convert.Unit.FINNEY);
	BigDecimal gWei=Convert.fromWei(weiFinney,Convert.Unit.GWEI);
	System.out.println(wei);
	System.out.println(gWei);
	
	//System.out.println(Convert.fromWei("1000000000000000000",Convert.Unit.ETHER));
	
	
	}
}