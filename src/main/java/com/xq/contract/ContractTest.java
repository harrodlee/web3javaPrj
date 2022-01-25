//package com.xq.contract;
//
//import com.xq.counter.Counter_sol_Counter;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.RemoteCall;
//import org.web3j.protocol.http.HttpService;
//
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.util.concurrent.ExecutionException;
//
//public class ContractTest {
//    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
//        String url="https://exchaintestrpc.okex.org";
//        Web3j web3j = Web3j.build(new HttpService(url));
//        String privateKey="95aae605123650c0ce90c3c5823d9ea19f27f575fb5eff97da4ae0cf59b14e37";
//        Credentials credentials=Credentials.create(privateKey);
//        RemoteCall<Counter_sol_Counter> deploy = Counter_sol_Counter.deploy(web3j, credentials,
//                BigInteger.valueOf(22_000_000_000L),BigInteger.valueOf(4_300_000));
//        try {
//            Counter_sol_Counter counter_sol_Counter = deploy.send();
//            counter_sol_Counter.isValid();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
