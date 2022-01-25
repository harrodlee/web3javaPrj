package com.xq.okexchain;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class TxSend {
    public static void signETHTransaction() throws IOException, ExecutionException, InterruptedException {

        String url="https://exchaintestrpc.okex.org";
        Web3j web3j = Web3j.build(new HttpService(url));

        //发送方地址
        String from = "0x6d3042B29710130b810E1A84840ee531793e2ac1";
        //发送方私钥
        String privateKey = "fa67dc3eb9e3ecde179756c7cc51e83c54d31b63c12a9bc9524a4d3976e79ae4";
        //转账数量
        String amount = "0.5";
        //接收者地址
        String to = "0x8fd67B78fAA54645e98701Dce7aD74E19dd654D5";
        //查询地址交易编号
        BigInteger nonce = web3j.ethGetTransactionCount(from, DefaultBlockParameterName.PENDING).send().getTransactionCount();
        //支付的矿工费
        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
        BigInteger gasLimit = new BigInteger("210000");

        BigInteger amountWei = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();
        //签名交易
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, to, amountWei, "");
        Credentials credentials = Credentials.create(privateKey);
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);


        StringBuffer sb=new StringBuffer();

        for(int i=0;i<signMessage.length;i++){
            sb.append(signMessage[i]);
        }
        String ss=Hash.sha3(sb+"");
        System.out.println(ss);

        String hash = web3j.ethSendRawTransaction(Numeric.toHexString(signMessage)).sendAsync().get().getTransactionHash();

        System.out.println("hash:" + hash);
    }
    public static void main(String args[]){
        try {
            signETHTransaction();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
