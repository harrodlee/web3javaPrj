//package com.xq.demo;
//
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.request.EthFilter;
//import org.web3j.tx.ClientTransactionManager;
//
//import java.io.IOException;
//import java.math.BigInteger;
//
//import static com.xq.demo.ContractLoad.getWeb3j;
//
//public class EventFlowable {
//    public static void main(String []args) throws IOException {
//        Web3j web3j = getWeb3j();
//        String contractAddress = "0x1D6E190a4B41425b4e140DBc578540EFa895EAF4";
//        ClientTransactionManager ctm = ContractLoad.getCtm(3);
//        System.out.println(ctm.getFromAddress());
//
//        Test voting = Test.load(contractAddress, web3j, ctm, BigInteger.valueOf(22_000_000_000L), BigInteger.valueOf(4_300_000));
//        EthFilter filter = new EthFilter();
//        voting.voteEventFlowable(filter).subscribe(event -> {
//            System.out.println("here!!!");
//            System.out.println(event.voter + " : " + new String(event.candidate));
//        });
//    }
//}
