package com.xq.demo;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class WalletAccount {
    public static void main(String []args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("https://exchaintestrpc.okex.org"));
        Credentials credentials = WalletUtils.loadCredentials("12345678","./keystore/UTC--2021-05-13T03-46-26.758000000Z--8cb022aa04817f0e23712ff59ac65513580b965b.json");
        String privateKey=credentials.getEcKeyPair().getPrivateKey().toString(16);
        String publicKey=credentials.getAddress();
        System.out.println(publicKey);
        //        ClientTransactionManager ctm= new ClientTransactionManager(web3j,credentials.getAddress());
//        String contractAddress = "0x1D6E190a4B41425b4e140DBc578540EFa895EAF4";
//        Voting_sol_Voting voting = Voting_sol_Voting.load(contractAddress, web3j, ctm, BigInteger.valueOf(22_000_000_000L), BigInteger.valueOf(4_300_000));
//        System.out.print(ContractLoad.getVoteCount(voting,"Jerry"));
    }
}
