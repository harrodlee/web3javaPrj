package com.xq.utils;
import org.web3j.abi.datatypes.generated.Bytes32;

import static org.web3j.crypto.Hash.sha3String;


public class ABIBack {

    public static String getABICode(String methodName,String par0){
        String methodCode= sha3String(methodName).substring(0,10);
        StringBuffer ABICode=new StringBuffer(methodCode);
        System.out.println("ABICode:"+methodCode);
        byte[]a=new byte[32];
        System.arraycopy(par0.getBytes(),0,a,32-par0.length(),par0.length());
        StringBuffer strBu=new StringBuffer("");
        for (int i=0;i<a.length;i++){
            strBu.append(a[i]);
        }
        String tmp=strBu+"";
        String backCode;
        if (tmp.length()<66){
            int count=66-tmp.length();
            for (int i=0;i<count;i++){
                strBu.append(0);
            }
            backCode=strBu+"";
        }else if(tmp.length()==66){
            backCode=strBu+"";
        }else {
            backCode=strBu.substring(0,66);
        }

        ABICode.append(backCode);
        return ABICode+"";
    }


    public static byte[] getByte32(String par0){
        byte[]a=new byte[32];
        System.arraycopy(par0.getBytes(),0,a,32-par0.length(),par0.length());
        return a;
    }


    public static void main(String[]args){

        getABICode("vote()","");
    }

    public static Bytes32 stringToBytes32(String string) {
        byte[] byteValue = string.getBytes();
        byte[] byteValueLen32 = new byte[32];
        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
        System.out.println(byteValueLen32);
        return new Bytes32(byteValueLen32);
    }

    public static String asciiToHex(String asciiValue)
    {
        byte[] byteArray = "This string is converted to a byte array".getBytes();
        String hexValue = javax.xml.bind.DatatypeConverter.printHexBinary(byteArray);
        return  hexValue;
    }
}