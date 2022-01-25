package com.xq.utils;



import java.io.IOException;

public class RimexInputData {
    public static void main(String args[]) throws IOException{
        //这里传入 你要编译成byte32的 原文
        System.out.print(getByte32("abc"));
    }

    private static String getByte32(String str) {
        byte[]a=new byte[32];
        System.arraycopy(str.getBytes(),0,a,32-str.length(),str.length());
        StringBuffer strBu=new StringBuffer("0x");
        for (int i=0;i<a.length;i++){
            strBu.append(a[i]);
        }
        String tmp=strBu+"";
        String backCode="";
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
        return backCode;
    }
}
