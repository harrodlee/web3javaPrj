package com.xq.counter;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Counter_sol_Counter extends Contract {
    public static final String BINARY = "60806040526000600060005090905534801561001b5760006000fd5b50610021565b6102bc806100306000396000f3fe60806040523480156100115760006000fd5b50600436106100465760003560e01c80631003e2d21461004c5780636deebae31461007b5780638ada066e1461008557610046565b60006000fd5b610079600480360360208110156100635760006000fd5b81019080803590602001909291905050506100a3565b005b610083610132565b005b61008d610274565b6040518082815260200191505060405180910390f35b806000600050540160006000508190909055507f64a55044d1f2eddebe1b90e8e2853e8e96931cefadbfa0b2ceb34bee360619416000600050546040518082815260200191505060405180910390a17f938d2ee5be9cfb0f7270ee2eff90507e94b37625d9d2b3a61c97d30a4560b8296000600050546040518082815260200191505060405180910390a15b50565b6000600060005054116040518060400160405280600f81526020017f434f554e5445525f544f4f5f4c4f57000000000000000000000000000000000081526020015090151561021d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360005b838110156101e25780820151818401525b6020810190506101c6565b50505050905090810190601f16801561020f5780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b5060006000818150548092919060019003919050909055507f938d2ee5be9cfb0f7270ee2eff90507e94b37625d9d2b3a61c97d30a4560b8296000600050546040518082815260200191505060405180910390a15b565b60006000600050549050610283565b9056fea26469706673582212206b619c15c776ee7e72c5abdade8587993c73bb94ff23009cb23e9c327416414f64736f6c63430006000033";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_GETCOUNTER = "getCounter";

    public static final String FUNC_SUBTRACT = "subtract";

    public static final Event ADDED_EVENT = new Event("Added", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event CHANGED_EVENT = new Event("Changed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Counter_sol_Counter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Counter_sol_Counter(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Counter_sol_Counter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Counter_sol_Counter(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddedEventResponse> getAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDED_EVENT, transactionReceipt);
        ArrayList<AddedEventResponse> responses = new ArrayList<AddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddedEventResponse typedResponse = new AddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.counter = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddedEventResponse> addedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddedEventResponse>() {
            @Override
            public AddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDED_EVENT, log);
                AddedEventResponse typedResponse = new AddedEventResponse();
                typedResponse.log = log;
                typedResponse.counter = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddedEventResponse> addedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDED_EVENT));
        return addedEventFlowable(filter);
    }

    public List<ChangedEventResponse> getChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHANGED_EVENT, transactionReceipt);
        ArrayList<ChangedEventResponse> responses = new ArrayList<ChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangedEventResponse typedResponse = new ChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.counter = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChangedEventResponse> changedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ChangedEventResponse>() {
            @Override
            public ChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGED_EVENT, log);
                ChangedEventResponse typedResponse = new ChangedEventResponse();
                typedResponse.log = log;
                typedResponse.counter = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChangedEventResponse> changedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGED_EVENT));
        return changedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> add(BigInteger delta) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(delta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getCounter() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> subtract() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SUBTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Counter_sol_Counter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter_sol_Counter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Counter_sol_Counter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter_sol_Counter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Counter_sol_Counter load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Counter_sol_Counter(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Counter_sol_Counter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Counter_sol_Counter(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Counter_sol_Counter> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Counter_sol_Counter.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Counter_sol_Counter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Counter_sol_Counter.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Counter_sol_Counter> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Counter_sol_Counter.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Counter_sol_Counter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Counter_sol_Counter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AddedEventResponse extends BaseEventResponse {
        public BigInteger counter;
    }

    public static class ChangedEventResponse extends BaseEventResponse {
        public BigInteger counter;
    }
}
