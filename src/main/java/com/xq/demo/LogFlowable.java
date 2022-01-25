//package com.xq.demo;
//
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.request.EthFilter;
//
//
//
///***
// * 尽量别用这种办法
// */
//public class LogFlowable {
//    public static void main(String []args){
//        Web3j web3j = getWeb3j();
//        EthFilter filter = new EthFilter();
//        web3j.ethLogFlowable(filter).subscribe(log -> {
//            System.out.println("index: " + log.getLogIndex());
//            System.out.println("data: " + log.getData());
//        });
//    }
//}
