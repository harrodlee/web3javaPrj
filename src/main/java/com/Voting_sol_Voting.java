//package com;
//
//import io.reactivex.Flowable;
//import io.reactivex.functions.Function;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import org.web3j.abi.EventEncoder;
//import org.web3j.abi.FunctionEncoder;
//import org.web3j.abi.TypeReference;
//import org.web3j.abi.datatypes.Address;
//import org.web3j.abi.datatypes.Bool;
//import org.web3j.abi.datatypes.Event;
//import org.web3j.abi.datatypes.Type;
//import org.web3j.abi.datatypes.generated.Bytes32;
//import org.web3j.abi.datatypes.generated.Uint8;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.DefaultBlockParameter;
//import org.web3j.protocol.core.RemoteCall;
//import org.web3j.protocol.core.RemoteFunctionCall;
//import org.web3j.protocol.core.methods.request.EthFilter;
//import org.web3j.protocol.core.methods.response.BaseEventResponse;
//import org.web3j.protocol.core.methods.response.Log;
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
//public class Voting_sol_Voting extends Contract {
//    public static final String BINARY = "60806040523480156100115760006000fd5b5060405161056f38038061056f833981810160405260208110156100355760006000fd5b81019080805160405193929190846401000000008211156100565760006000fd5b8382019150602082018581111561006d5760006000fd5b825186602082028301116401000000008211171561008b5760006000fd5b8083526020830192505050908051906020019060200280838360005b838110156100c35780820151818401525b6020810190506100a7565b505050509050016040526020015050505b80600160005090805190602001906100ed9291906100f5565b505b50610176565b82805482825590600052602060002090810192821561013a579160200282015b82811115610139578251826000509060001916905591602001919060010190610115565b5b509050610147919061014b565b5090565b6101739190610155565b8082111561016f5760008181506000905550600101610155565b5090565b90565b6103ea806101856000396000f3fe60806040523480156100115760006000fd5b506004361061005c5760003560e01c80632b38cd96146100625780633477ee2e146100af57806335154986146100fa578063392e66781461012d578063b1347908146101785761005c565b60006000fd5b610093600480360360208110156100795760006000fd5b8101908080356000191690602001909291905050506101c5565b604051808260ff1660ff16815260200191505060405180910390f35b6100dc600480360360208110156100c65760006000fd5b81019080803590602001909291905050506101ea565b60405180826000191660001916815260200191505060405180910390f35b61012b600480360360208110156101115760006000fd5b810190808035600019169060200190929190505050610212565b005b61015e600480360360208110156101445760006000fd5b8101908080356000191690602001909291905050506102ee565b604051808215151515815260200191505060405180910390f35b6101a96004803603602081101561018f5760006000fd5b81019080803560001916906020019092919050505061035f565b604051808260ff1660ff16815260200191505060405180910390f35b600060005060205280600052604060002060009150909054906101000a900460ff1681565b6001600050818154811015156101fc57fe5b906000526020600020900160005b915090505481565b610221816102ee63ffffffff16565b151561022d5760006000fd5b600160006000506000836000191660001916815260200190815260200160002060008282829054906101000a900460ff160192506101000a81548160ff021916908360ff1602179055507fc1eff9d9e2ab8a2b29706e0c2818cd78972e60f1ce84c268a77005b0bece97c43382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182600019166000191681526020019250505060405180910390a15b50565b60006000600090505b60016000508054905081101561035057826000191660016000508281548110151561031e57fe5b906000526020600020900160005b505460001916141561034257600191505061035a565b5b80806001019150506102f7565b506000905061035a565b919050565b6000610370826102ee63ffffffff16565b151561037c5760006000fd5b60006000506000836000191660001916815260200190815260200160002060009054906101000a900460ff1690506103af565b91905056fea2646970667358221220dd0a7c0efba5e5d98d701b07804b7938db8221618ee917eeef7aa89405d75eca64736f6c63430006000033";
//
//    public static final String FUNC_CANDIDATES = "candidates";
//
//    public static final String FUNC_GETVOTESFOR = "getVotesFor";
//
//    public static final String FUNC_VALIDCANDIDATE = "validCandidate";
//
//    public static final String FUNC_VOTEFOR = "voteFor";
//
//    public static final String FUNC_VOTES = "votes";
//
//    public static final Event VOTE_EVENT = new Event("Vote",
//            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}));
//    ;
//
//    @Deprecated
//    protected Voting_sol_Voting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    protected Voting_sol_Voting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    @Deprecated
//    protected Voting_sol_Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    protected Voting_sol_Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
//    public List<VoteEventResponse> getVoteEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(VOTE_EVENT, transactionReceipt);
//        ArrayList<VoteEventResponse> responses = new ArrayList<VoteEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            VoteEventResponse typedResponse = new VoteEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.voter = (String) eventValues.getNonIndexedValues().get(0).getValue();
//            typedResponse.candidate = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }
//
//    public Flowable<VoteEventResponse> voteEventFlowable(EthFilter filter) {
//        return web3j.ethLogFlowable(filter).map(new Function<Log, VoteEventResponse>() {
//            @Override
//            public VoteEventResponse apply(Log log) {
//                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(VOTE_EVENT, log);
//                VoteEventResponse typedResponse = new VoteEventResponse();
//                typedResponse.log = log;
//                typedResponse.voter = (String) eventValues.getNonIndexedValues().get(0).getValue();
//                typedResponse.candidate = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
//                return typedResponse;
//            }
//        });
//    }
//
//    public Flowable<VoteEventResponse> voteEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(VOTE_EVENT));
//        return voteEventFlowable(filter);
//    }
//
//    public RemoteFunctionCall<byte[]> candidates(BigInteger param0) {
//        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CANDIDATES,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
//        return executeRemoteCallSingleValueReturn(function, byte[].class);
//    }
//
//    public RemoteFunctionCall<BigInteger> getVotesFor(byte[] candidate) {
//        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETVOTESFOR,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
//        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
//    }
//
//    public RemoteFunctionCall<Boolean> validCandidate(byte[] candidate) {
//        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VALIDCANDIDATE,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
//        return executeRemoteCallSingleValueReturn(function, Boolean.class);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> voteFor(byte[] candidate) {
//        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
//                FUNC_VOTEFOR,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteFunctionCall<BigInteger> votes(byte[] param0) {
//        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VOTES,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
//        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
//    }
//
//    @Deprecated
//    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        return new Voting_sol_Voting(contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    @Deprecated
//    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return new Voting_sol_Voting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        return new Voting_sol_Voting(contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        return new Voting_sol_Voting(contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
//    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<byte[]> candidateNames) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
//                        org.web3j.abi.datatypes.generated.Bytes32.class,
//                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
//        return deployRemoteCall(Voting_sol_Voting.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
//    }
//
//    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<byte[]> candidateNames) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
//                        org.web3j.abi.datatypes.generated.Bytes32.class,
//                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
//        return deployRemoteCall(Voting_sol_Voting.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
//    }
//
//    @Deprecated
//    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> candidateNames) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
//                        org.web3j.abi.datatypes.generated.Bytes32.class,
//                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
//        return deployRemoteCall(Voting_sol_Voting.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
//    }
//
//    @Deprecated
//    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> candidateNames) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
//                        org.web3j.abi.datatypes.generated.Bytes32.class,
//                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
//        return deployRemoteCall(Voting_sol_Voting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
//    }
//
//    public static class VoteEventResponse extends BaseEventResponse {
//        public String voter;
//
//        public byte[] candidate;
//    }
//}
