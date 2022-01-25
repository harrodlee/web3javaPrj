package com.xq.okexchain;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.Optional;

public class OkexApi {
    public static void main(String[] args) throws IOException {
        String url = "https://exchaintestrpc.okex.org";
        Web3j web3j = Web3j.build(new HttpService(url));
        String txHash = "0x71e91d8073947d511f2cf365dadbe26204dd25088eb9e6485353c80003f3ea3a";
        Optional<TransactionReceipt> receipt = null;
        while (true) {
            receipt = web3j.ethGetTransactionReceipt(txHash).send().getTransactionReceipt();
            TransactionReceipt tr = receipt.get();
            if (receipt.isPresent()) {
                System.out.println("contractAddress: " + tr.getContractAddress());
                break;
            }
        }
    }
}
