package com.xq.utils;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.Utils;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.generated.Bytes32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorCode {
    public static void main(String[]args){
        List candidateNames = Arrays.asList("Micky");
        System.out.println(getEncodedConstructor(candidateNames));
    }

    /**
     *
     * @param candidateNames
     * @return
     */
    public static String getEncodedConstructor(List<String> candidateNames){
        List<byte[]> candidateNamesByte = candidateNames.stream().map(val->strToByte(val)).collect(Collectors.toList());
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.asList(new DynamicArray(Bytes32.class, Utils.typeMap(candidateNamesByte,Bytes32.class))));
        return encodedConstructor;
    }
    /**
     *
     * @param str
     * @return
     */
    private static byte[] strToByte(String str) {
        byte[] byteValue = str.getBytes();
        byte[] byteValueLen32 = new byte[32];
        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
        return byteValueLen32;
    }

    /***
     *
     * @param candidateNames
     * @return
     */
    public static List<DynamicArray> getAsList(List<String> candidateNames){
        List<byte[]> candidateNamesByte = candidateNames.stream().map(val->strToByte(val)).collect(Collectors.toList());
        List<DynamicArray> dynamicArrays=Arrays.asList(new DynamicArray(Bytes32.class, Utils.typeMap(candidateNamesByte,Bytes32.class)));
        return dynamicArrays;
    }
}
