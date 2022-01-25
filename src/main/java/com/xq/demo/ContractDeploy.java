//package com.xq.demo;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.tx.RawTransactionManager;
//import org.web3j.tx.TransactionManager;
//
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ContractDeploy {
//    public static void main(String[] args) throws IOException{
//
//        String url="https://exchaintestrpc.okex.org";
//        Web3j web3j = Web3j.build(new HttpService(url));
//        String privateKey="95aae605123650c0ce90c3c5823d9ea19f27f575fb5eff97da4ae0cf59b14e37";
//        Credentials credentials = Credentials.create(privateKey);
//        System.out.println(credentials.getAddress());
//        TransactionManager txManager = new RawTransactionManager(web3j,credentials);
//
//
//        //String contractAddress="0x79BE5cc37B7e17594028BbF5d43875FDbed417db";
//
//        List<byte[]> candidates = new ArrayList<byte[]>();
//        candidates.add(getByte32("Tommy"));
//        candidates.add(getByte32("Jerry"));
//        candidates.add(getByte32("Micky"));
//        Voting_sol_Voting voting=null;
//        try {
//            voting = Voting_sol_Voting.deploy(web3j,txManager,BigInteger.valueOf(22_000_000_000L),BigInteger.valueOf(4_300_000),candidates).send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String contractAddresss = voting.getContractAddress();
//        //System.out.println(contractAddress);
//    }
//
//    private static byte[] getByte32(String str) {
//        byte[]a=new byte[32];
//        System.arraycopy(str.getBytes(),0,a,32-str.length(),str.length());
//        return a;
//    }
//}
