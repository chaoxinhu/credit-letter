package org.fiscobcos.quiz.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version null.
 */
@SuppressWarnings("unchecked")
public class CreditLetterFactory extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b50611638806100206000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680637f368f65146100515780638afbc1ed146100f2575b600080fd5b34801561005d57600080fd5b506100f0600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190505050610149565b005b3480156100fe57600080fd5b50610147600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919050505061029d565b005b6000868686868686610159610585565b808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019650505050505050604051809103906000f080158015610226573d6000803e3d6000fd5b5090507f4481db8423b8eae544e932e436f55884c6487e4d3ca295a3ca992ecf84ecc6958185604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a150505050505050565b60008060008060008060008996508673ffffffffffffffffffffffffffffffffffffffff16635a9b0b896040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161010060405180830381600087803b15801561031057600080fd5b505af1158015610324573d6000803e3d6000fd5b505050506040513d61010081101561033b57600080fd5b810190808051906020019092919080519060200190929190805190602001909291908051906020019092919080519060200190929190805190602001909291908051906020019092919080519060200190929190505050505096509650509550955095508673ffffffffffffffffffffffffffffffffffffffff1663bfe389ed8a84038a6040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083815260200182815260200192505050600060405180830381600087803b15801561041857600080fd5b505af115801561042c573d6000803e3d6000fd5b505050508585858a868d61043e610585565b808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019650505050505050604051809103906000f08015801561050b573d6000803e3d6000fd5b5090507f4481db8423b8eae544e932e436f55884c6487e4d3ca295a3ca992ecf84ecc6958189604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a150505050505050505050565b6040516110778061059683390190560060806040526000600660006101000a81548160ff0219169083151502179055506000600660016101000a81548160ff0219169083151502179055506000600755600160085534801561005057600080fd5b5060405160c0806110778339810180604052810190808051906020019092919080519060200190929190805190602001909291908051906020019092919080519060200190929190805190602001909291905050508573ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16148061010a57508373ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16145b15156101a4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260288152602001807f4f6e6c79206973737565722063616e206973737565206869732f686572206f7781526020017f6e206c657474657200000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b856000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555084600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600381905550816004819055508060058190555060098590806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600a839080600181540180825580915050906001820390600052602060002001600090919290919091505550505050505050610d55806103226000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631c9242801461007d57806358007b86146100b65780635a9b0b89146100ef5780635dfd3c98146101d7578063a9059cbb1461028b578063bfe389ed146102d8575b600080fd5b34801561008957600080fd5b506100b46004803603810190808035151590602001909291908035906020019092919050505061030f565b005b3480156100c257600080fd5b506100ed6004803603810190808035151590602001909291908035906020019092919050505061044e565b005b3480156100fb57600080fd5b5061010461060a565b604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200186815260200185815260200184815260200183151515158152602001821515151581526020019850505050505050505060405180910390f35b3480156101e357600080fd5b506101ec6106c1565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b83811015610233578082015181840152602081019050610218565b50505050905001838103825284818151815260200191508051906020019060200280838360005b8381101561027557808201518184015260208101905061025a565b5050505090500194505050505060405180910390f35b34801561029757600080fd5b506102d6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506108ec565b005b3480156102e457600080fd5b5061030d6004803603810190808035906020019092919080359060200190929190505050610b93565b005b60008111151561031e57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156103e3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f4f6e6c79206163636570746f722063616e20706179000000000000000000000081525060200191505060405180910390fd5b81600660016101000a81548160ff0219169083151502179055507f1ecf1b9cee605f7dc61806c2f40429418dbc06abbb7cfe58d1b5480f084af9a060085483836040518084815260200183151515158152602001828152602001935050505060405180910390a15050565b60008111151561045d57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061050557506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561059f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260238152602001807f4f6e6c79206163636570746f72206f72206973737565722063616e206170707281526020017f6f7665000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b81600660006101000a81548160ff0219169083151502179055507f1ecf1b9cee605f7dc61806c2f40429418dbc06abbb7cfe58d1b5480f084af9a060075483836040518084815260200183151515158152602001828152602001935050505060405180910390a15050565b6000806000806000806000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600354600454600554600660009054906101000a900460ff16600660019054906101000a900460ff16975097509750975097509750975097509091929394959697565b6060806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061076c5750600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610806576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602f8152602001807f4f6e6c7920697373756572206f72206163636570746f722063616e206368656381526020017f6b207472616e73666572206c6f6773000000000000000000000000000000000081525060400191505060405180910390fd5b6009600a8180548060200260200160405190810160405280929190818152602001828054801561088b57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610841575b50505050509150808054806020026020016040519081016040528092919081815260200182805480156108dd57602002820191906000526020600020905b8154815260200190600101908083116108c9575b50505050509050915091509091565b8173ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415151561094957600080fd5b60008111151561095857600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a1d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4f6e6c7920686f6c6465722063616e207472616e73666572000000000000000081525060200191505060405180910390fd5b81600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060093390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600a8190806001815401808255809150509060018203906000526020600020016000909192909190915055507f0b208f30897dd37bbda3db1da3cf917bce605c53cdab4f7be8eaac32c8082f10338383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a15050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161480610c3b5750600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16145b1515610cd5576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602f8152602001807f4f6e6c7920697373756572206f72206163636570746f722063616e207265736581526020017f742063726564697420616d6f756e74000000000000000000000000000000000081525060400191505060405180910390fd5b816005819055507fbe251dfecb445e45c89b4940942865904cf0efeea8fb1e4aa0f340e8370c03cd600554838360405180848152602001838152602001828152602001935050505060405180910390a150505600a165627a7a7230582023e1f874bfbc470e53f942f2f0ffb73d07fdc0facbdd7237f2cf8c290a84020b0029a165627a7a72305820bba6a2110d0e17989997b57239fd2261d53aa6e418e5d9674078aafc30f0c8150029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"issuer\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"holder\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"acceptor\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"issuanceTime\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"interestRate\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"credit\",\"type\":\"uint256\"}],\"name\":\"create\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"originalAddress\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"amount\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"split\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"addr\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"CreateLog\",\"payable\":false,\"type\":\"event\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_SPLIT = "split";

    public static final Event CREATELOG_EVENT = new Event("CreateLog", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CreditLetterFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CreditLetterFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CreditLetterFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CreditLetterFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> create(String issuer, String holder, String acceptor, BigInteger issuanceTime, BigInteger interestRate, BigInteger credit) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(issuer), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(holder), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(acceptor), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(issuanceTime), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(interestRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(credit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void create(String issuer, String holder, String acceptor, BigInteger issuanceTime, BigInteger interestRate, BigInteger credit, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(issuer), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(holder), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(acceptor), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(issuanceTime), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(interestRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(credit)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createSeq(String issuer, String holder, String acceptor, BigInteger issuanceTime, BigInteger interestRate, BigInteger credit) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(issuer), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(holder), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(acceptor), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(issuanceTime), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(interestRate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(credit)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple6<String, String, String, BigInteger, BigInteger, BigInteger> getCreateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple6<String, String, String, BigInteger, BigInteger, BigInteger>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (BigInteger) results.get(4).getValue(), 
                (BigInteger) results.get(5).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> split(String originalAddress, BigInteger amount, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SPLIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(originalAddress), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void split(String originalAddress, BigInteger amount, BigInteger timestamp, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SPLIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(originalAddress), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String splitSeq(String originalAddress, BigInteger amount, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SPLIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(originalAddress), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, BigInteger, BigInteger> getSplitInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SPLIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, BigInteger, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue()
                );
    }

    public List<CreateLogEventResponse> getCreateLogEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREATELOG_EVENT, transactionReceipt);
        ArrayList<CreateLogEventResponse> responses = new ArrayList<CreateLogEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreateLogEventResponse typedResponse = new CreateLogEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerCreateLogEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATELOG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerCreateLogEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATELOG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static CreditLetterFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CreditLetterFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CreditLetterFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CreditLetterFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CreditLetterFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CreditLetterFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CreditLetterFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CreditLetterFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CreditLetterFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CreditLetterFactory.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CreditLetterFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CreditLetterFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CreditLetterFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CreditLetterFactory.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CreditLetterFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CreditLetterFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateLogEventResponse {
        public Log log;

        public String addr;

        public BigInteger timestamp;
    }
}
