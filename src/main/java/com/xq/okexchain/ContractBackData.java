package com.xq.okexchain;


import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;



import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.xq.utils.ABIBack.getABICode;

public class ContractBackData {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        String url = "https://exchaintestrpc.okex.org";
        Web3j web3j = Web3j.build(new HttpService(url));
        String contractAddr = "0x50ae29adF2Cf2C5429A01d21dEB1c88A218438B8";
        //发送方地址
        String from = "0x36887B5A431d3f424c1918Db8fF3D2708Ec606E8";
        String txData = getABICode("getVotesFor(bytes32)", "Merry");

        System.out.println(txData);

        Function function = new Function("getVotesFor", Arrays.asList(),
                Arrays.asList(new TypeReference<Uint32>() {
        }));

        BigInteger nonce = web3j.ethGetTransactionCount(from,DefaultBlockParameterName.PENDING).send().getTransactionCount();
        Transaction transaction0= Transaction.createFunctionCallTransaction(
                from,
                nonce,
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT,
                contractAddr,
                txData
        );

        EthCall ethCall  = web3j.ethCall(transaction0, DefaultBlockParameterName.LATEST).send();
        List<Type> results = FunctionReturnDecoder.decode(ethCall.getResult(), function.getOutputParameters());
        BigInteger count = (BigInteger) results.get(0).getValue();
        System.out.println(count);
    }
}
