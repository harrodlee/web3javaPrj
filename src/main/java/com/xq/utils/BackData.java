package com.xq.utils;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Uint;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

import java.util.concurrent.ExecutionException;

public class BackData {

    public static void main(String[]args) throws IOException, ExecutionException, InterruptedException {


        String url="https://exchaintestrpc.okex.org";
        Web3j web3j = Web3j.build(new HttpService(url));
        String privateKey="95aae605123650c0ce90c3c5823d9ea19f27f575fb5eff97da4ae0cf59b14e37";
        String to="0x61B4Fc13E2352feE29B032E0A8E0CEBe9C8aD910";

        Function function=new Function("set",Arrays.<org.web3j.abi.datatypes.Type>asList(new Uint(BigInteger.valueOf(1))),
                Arrays.asList(new TypeReference<Uint>(){}));
        String txData = FunctionEncoder.encode(function);
        System.out.println(txData);
        Credentials credentials = Credentials.create(privateKey);
        BigInteger nonce = web3j.ethGetTransactionCount(credentials.getAddress(),DefaultBlockParameterName.PENDING).send().getTransactionCount();

        RawTransaction rawTransaction=RawTransaction.createTransaction(
                nonce,
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT,
                to,
                BigInteger.ZERO,
                txData);
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction,Byte.valueOf("65"),credentials);
        String hash = web3j.ethSendRawTransaction(Numeric.toHexString(signMessage)).sendAsync().get().getTransactionHash();
        System.out.println("hash:"+hash);
    }
}
