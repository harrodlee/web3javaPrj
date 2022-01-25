package com.xq.okexchain;


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
import java.util.concurrent.ExecutionException;
import static com.xq.utils.ABIBack.getABICode;

public class ContractCall {


    public static void main(String[]args) throws IOException, ExecutionException, InterruptedException {
        String url="https://exchaintestrpc.okex.org";
        Web3j web3j = Web3j.build(new HttpService(url));
        String privateKey="95aae605123650c0ce90c3c5823d9ea19f27f575fb5eff97da4ae0cf59b14e37";
        String contractAddr="0x50ae29adF2Cf2C5429A01d21dEB1c88A218438B8";
        //发送方地址
        String from = "0x36887B5A431d3f424c1918Db8fF3D2708Ec606E8";
        String txData=getABICode("voteFor(bytes32)", "0");
        Credentials credentials = Credentials.create(privateKey);
        BigInteger nonce = web3j.ethGetTransactionCount(from, DefaultBlockParameterName.PENDING).send().getTransactionCount();

        //创建一个交易数据
        RawTransaction rt=RawTransaction.createTransaction(
                nonce,
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT,
                contractAddr,
                BigInteger.ZERO,
                txData);
        //离线签名
        byte[] signMessage = TransactionEncoder.signMessage(rt,Byte.valueOf("65"),credentials);
        //广播交易
        String hash = web3j.ethSendRawTransaction(Numeric.toHexString(signMessage)).sendAsync().get().getTransactionHash();
        System.out.println("hash:"+hash);
    }
}
