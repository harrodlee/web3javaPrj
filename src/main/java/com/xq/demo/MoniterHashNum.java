//package com.xq.demo;
//
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.response.EthBlock;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.utils.Async;
//
//public class MoniterHashNum {
//    public static void main(String[] args) {
//        Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"),1000, Async.defaultExecutorService());
//            web3j.blockFlowable(true).subscribe(ethBlock -> {
//            EthBlock.Block block = ethBlock.getBlock();
//            System.out.println("hash: " + block.getHash());
//            System.out.println("number: " + block.getNumber());
//        });
//    }
//}
