//package com.xq.transfer;
//
//import java.math.BigInteger;
//import java.util.Arrays;
//import java.util.Collections;
//import org.web3j.abi.TypeReference;
//import org.web3j.abi.datatypes.Function;
//import org.web3j.abi.datatypes.Type;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.RemoteCall;
//import org.web3j.protocol.core.RemoteFunctionCall;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.tx.Contract;
//import org.web3j.tx.TransactionManager;
//import org.web3j.tx.gas.ContractGasProvider;
//
///**
// * <p>Auto generated code.
// * <p><strong>Do not modify!</strong>
// * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
// * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
// * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
// *
// * <p>Generated with web3j version 1.4.1.
// */
//@SuppressWarnings("rawtypes")
//public class Transfer_sol_IERC20 extends Contract {
//    public static final String BINARY = "";
//
//    public static final String FUNC_TRANSFER = "transfer";
//
//    @Deprecated
//    protected Transfer_sol_IERC20(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    protected Transfer_sol_IERC20(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    @Deprecated
//    protected Transfer_sol_IERC20(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    protected Transfer_sol_IERC20(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> transfer(String recipient, BigInteger amount) {
//        final Function function = new Function(
//                FUNC_TRANSFER,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient),
//                new org.web3j.abi.datatypes.generated.Uint256(amount)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    @Deprecated
//    public static Transfer_sol_IERC20 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        return new Transfer_sol_IERC20(contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    @Deprecated
//    public static Transfer_sol_IERC20 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return new Transfer_sol_IERC20(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    public static Transfer_sol_IERC20 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        return new Transfer_sol_IERC20(contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    public static Transfer_sol_IERC20 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        return new Transfer_sol_IERC20(contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
//    public static RemoteCall<Transfer_sol_IERC20> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        return deployRemoteCall(Transfer_sol_IERC20.class, web3j, credentials, contractGasProvider, BINARY, "");
//    }
//
//    @Deprecated
//    public static RemoteCall<Transfer_sol_IERC20> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        return deployRemoteCall(Transfer_sol_IERC20.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
//    }
//
//    public static RemoteCall<Transfer_sol_IERC20> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        return deployRemoteCall(Transfer_sol_IERC20.class, web3j, transactionManager, contractGasProvider, BINARY, "");
//    }
//
//    @Deprecated
//    public static RemoteCall<Transfer_sol_IERC20> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return deployRemoteCall(Transfer_sol_IERC20.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
//    }
//}
