//package com.xq.demo;
//
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.tx.ClientTransactionManager;
//
//import java.io.IOException;
//import java.math.BigInteger;
//
//
///**
// *
// */
//public class ContractLoad {
//    public static void main(String[]args) throws Exception {
//        Web3j web3j = getWeb3j();
//        String contractAddress = "0x5c518b469443B04015B656483b29DA5987c9e961";
//        ClientTransactionManager ctm=ContractLoad.getCtm(3);
//
//        Voting_sol_Voting vsv= Voting_sol_Voting.load(contractAddress,web3j,ctm,BigInteger.valueOf(22_000_000_000L),BigInteger.valueOf(4_300_000));
//        BigInteger votes = vsv.getVotesFor(getByte32("Tommy")).send();
//        System.out.println(votes);
//
//    }
//
//
//    /**
//     *
//     * @param str
//     * @return
//     */
//    public static byte[] getByte32(String str) {
//        byte[]a=new byte[32];
//        System.arraycopy(str.getBytes(),0,a,32-str.length(),str.length());
//        return a;
//    }
//
//
//    /**
//     *
//     * @param voting
//     * @param str
//     * @return
//     * @throws Exception
//     */
//    public static void voteFor(Voting_sol_Voting voting, String str) throws Exception {
//        TransactionReceipt receipt = voting.voteFor(getByte32(str)).send();
//        //return receipt.getBlockNumber();
//    }
//
//    /**
//     * 获取web3j-Object
//     * @return
//     */
//    public static Web3j getWeb3j(){
//        return Web3j.build(new HttpService("http://localhost:8545"));
//    }
//
//    /**
//     * get ctm
//     * @return
//     * @throws IOException
//     */
//    public static ClientTransactionManager getCtm(int num) throws IOException {
//        return new ClientTransactionManager(getWeb3j(), getWeb3j().ethAccounts().send().getAccounts().get(num));
//    }
//
//
//    /**
//     *
//     * @param voting
//     * @param str
//     * @return
//     * @throws Exception
//     */
//    public static BigInteger getVoteCount(Voting_sol_Voting voting, String str) throws Exception {
//        return  voting.getVotesFor(getByte32(str)).send();
//    }
//}
