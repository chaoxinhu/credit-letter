package org.fiscobcos.quiz.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple8;
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
public class CreditLetter extends Contract {
    public static String BINARY = "60806040526000600660006101000a81548160ff0219169083151502179055506000600660016101000a81548160ff0219169083151502179055506000600755600160085534801561005057600080fd5b5060405160c0806110778339810180604052810190808051906020019092919080519060200190929190805190602001909291908051906020019092919080519060200190929190805190602001909291905050508573ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16148061010a57508373ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16145b15156101a4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260288152602001807f4f6e6c79206973737565722063616e206973737565206869732f686572206f7781526020017f6e206c657474657200000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b856000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555084600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600381905550816004819055508060058190555060098590806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600a839080600181540180825580915050906001820390600052602060002001600090919290919091505550505050505050610d55806103226000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631c9242801461007d57806358007b86146100b65780635a9b0b89146100ef5780635dfd3c98146101d7578063a9059cbb1461028b578063bfe389ed146102d8575b600080fd5b34801561008957600080fd5b506100b46004803603810190808035151590602001909291908035906020019092919050505061030f565b005b3480156100c257600080fd5b506100ed6004803603810190808035151590602001909291908035906020019092919050505061044e565b005b3480156100fb57600080fd5b5061010461060a565b604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200186815260200185815260200184815260200183151515158152602001821515151581526020019850505050505050505060405180910390f35b3480156101e357600080fd5b506101ec6106c1565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b83811015610233578082015181840152602081019050610218565b50505050905001838103825284818151815260200191508051906020019060200280838360005b8381101561027557808201518184015260208101905061025a565b5050505090500194505050505060405180910390f35b34801561029757600080fd5b506102d6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506108ec565b005b3480156102e457600080fd5b5061030d6004803603810190808035906020019092919080359060200190929190505050610b93565b005b60008111151561031e57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156103e3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f4f6e6c79206163636570746f722063616e20706179000000000000000000000081525060200191505060405180910390fd5b81600660016101000a81548160ff0219169083151502179055507f1ecf1b9cee605f7dc61806c2f40429418dbc06abbb7cfe58d1b5480f084af9a060085483836040518084815260200183151515158152602001828152602001935050505060405180910390a15050565b60008111151561045d57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061050557506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561059f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260238152602001807f4f6e6c79206163636570746f72206f72206973737565722063616e206170707281526020017f6f7665000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b81600660006101000a81548160ff0219169083151502179055507f1ecf1b9cee605f7dc61806c2f40429418dbc06abbb7cfe58d1b5480f084af9a060075483836040518084815260200183151515158152602001828152602001935050505060405180910390a15050565b6000806000806000806000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600354600454600554600660009054906101000a900460ff16600660019054906101000a900460ff16975097509750975097509750975097509091929394959697565b6060806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061076c5750600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610806576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602f8152602001807f4f6e6c7920697373756572206f72206163636570746f722063616e206368656381526020017f6b207472616e73666572206c6f6773000000000000000000000000000000000081525060400191505060405180910390fd5b6009600a8180548060200260200160405190810160405280929190818152602001828054801561088b57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610841575b50505050509150808054806020026020016040519081016040528092919081815260200182805480156108dd57602002820191906000526020600020905b8154815260200190600101908083116108c9575b50505050509050915091509091565b8173ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415151561094957600080fd5b60008111151561095857600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a1d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4f6e6c7920686f6c6465722063616e207472616e73666572000000000000000081525060200191505060405180910390fd5b81600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060093390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600a8190806001815401808255809150509060018203906000526020600020016000909192909190915055507f0b208f30897dd37bbda3db1da3cf917bce605c53cdab4f7be8eaac32c8082f10338383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a15050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161480610c3b5750600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16145b1515610cd5576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602f8152602001807f4f6e6c7920697373756572206f72206163636570746f722063616e207265736581526020017f742063726564697420616d6f756e74000000000000000000000000000000000081525060400191505060405180910390fd5b816005819055507fbe251dfecb445e45c89b4940942865904cf0efeea8fb1e4aa0f340e8370c03cd600554838360405180848152602001838152602001828152602001935050505060405180910390a150505600a165627a7a7230582023e1f874bfbc470e53f942f2f0ffb73d07fdc0facbdd7237f2cf8c290a84020b0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"status\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"setStatusPaid\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"status\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"setStatusApproved\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getInfo\",\"outputs\":[{\"indexed\":false,\"name\":\"issuerVal\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"holderVal\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"acceptorVal\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"issuanceTimeVal\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"interestRateVal\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"creditVal\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"approved\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"paid\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllTransferLogs\",\"outputs\":[{\"indexed\":false,\"name\":\"\",\"type\":\"address[]\"},{\"indexed\":false,\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"to\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"transfer\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"amount\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"resetCreditAmount\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"issuerVal\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"holderVal\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"acceptorVal\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"issuanceTimeVal\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"interestRateVal\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"creditVal\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"id\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"latestStatus\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"StatusChanged\",\"payable\":false,\"type\":\"event\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"from\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"to\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"HolderChanged\",\"payable\":false,\"type\":\"event\"},{\"constant\":false,\"inputs\":[{\"indexed\":false,\"name\":\"original\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"amount\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"}],\"name\":\"CreditChanged\",\"payable\":false,\"type\":\"event\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_SETSTATUSPAID = "setStatusPaid";

    public static final String FUNC_SETSTATUSAPPROVED = "setStatusApproved";

    public static final String FUNC_GETINFO = "getInfo";

    public static final String FUNC_GETALLTRANSFERLOGS = "getAllTransferLogs";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_RESETCREDITAMOUNT = "resetCreditAmount";

    public static final Event STATUSCHANGED_EVENT = new Event("StatusChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event HOLDERCHANGED_EVENT = new Event("HolderChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event CREDITCHANGED_EVENT = new Event("CreditChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CreditLetter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CreditLetter(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CreditLetter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CreditLetter(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> setStatusPaid(Boolean status, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SETSTATUSPAID, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(status), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setStatusPaid(Boolean status, BigInteger timestamp, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSTATUSPAID, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(status), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setStatusPaidSeq(Boolean status, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SETSTATUSPAID, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(status), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<Boolean, BigInteger> getSetStatusPaidInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSTATUSPAID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<Boolean, BigInteger>(

                (Boolean) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setStatusApproved(Boolean status, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SETSTATUSAPPROVED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(status), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setStatusApproved(Boolean status, BigInteger timestamp, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSTATUSAPPROVED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(status), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setStatusApprovedSeq(Boolean status, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SETSTATUSAPPROVED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(status), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<Boolean, BigInteger> getSetStatusApprovedInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSTATUSAPPROVED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<Boolean, BigInteger>(

                (Boolean) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<Tuple8<String, String, String, BigInteger, BigInteger, BigInteger, Boolean, Boolean>> getInfo() {
        final Function function = new Function(FUNC_GETINFO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple8<String, String, String, BigInteger, BigInteger, BigInteger, Boolean, Boolean>>(
                new Callable<Tuple8<String, String, String, BigInteger, BigInteger, BigInteger, Boolean, Boolean>>() {
                    @Override
                    public Tuple8<String, String, String, BigInteger, BigInteger, BigInteger, Boolean, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<String, String, String, BigInteger, BigInteger, BigInteger, Boolean, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (Boolean) results.get(6).getValue(), 
                                (Boolean) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<Tuple2<List<String>, List<BigInteger>>> getAllTransferLogs() {
        final Function function = new Function(FUNC_GETALLTRANSFERLOGS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<Tuple2<List<String>, List<BigInteger>>>(
                new Callable<Tuple2<List<String>, List<BigInteger>>>() {
                    @Override
                    public Tuple2<List<String>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<String>, List<BigInteger>>(
                                convertToNative((List<Address>) results.get(0).getValue()), 
                                convertToNative((List<Uint256>) results.get(1).getValue()));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> transfer(String to, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(to), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void transfer(String to, BigInteger timestamp, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(to), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String transferSeq(String to, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(to), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getTransferInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_TRANSFER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> resetCreditAmount(BigInteger amount, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_RESETCREDITAMOUNT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void resetCreditAmount(BigInteger amount, BigInteger timestamp, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_RESETCREDITAMOUNT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String resetCreditAmountSeq(BigInteger amount, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_RESETCREDITAMOUNT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<BigInteger, BigInteger> getResetCreditAmountInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_RESETCREDITAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public List<StatusChangedEventResponse> getStatusChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(STATUSCHANGED_EVENT, transactionReceipt);
        ArrayList<StatusChangedEventResponse> responses = new ArrayList<StatusChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StatusChangedEventResponse typedResponse = new StatusChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.latestStatus = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerStatusChangedEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(STATUSCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerStatusChangedEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(STATUSCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<HolderChangedEventResponse> getHolderChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(HOLDERCHANGED_EVENT, transactionReceipt);
        ArrayList<HolderChangedEventResponse> responses = new ArrayList<HolderChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HolderChangedEventResponse typedResponse = new HolderChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerHolderChangedEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(HOLDERCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerHolderChangedEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(HOLDERCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<CreditChangedEventResponse> getCreditChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREDITCHANGED_EVENT, transactionReceipt);
        ArrayList<CreditChangedEventResponse> responses = new ArrayList<CreditChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreditChangedEventResponse typedResponse = new CreditChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.original = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerCreditChangedEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREDITCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerCreditChangedEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREDITCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static CreditLetter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CreditLetter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CreditLetter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CreditLetter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CreditLetter load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CreditLetter(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CreditLetter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CreditLetter(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CreditLetter> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String issuerVal, String holderVal, String acceptorVal, BigInteger issuanceTimeVal, BigInteger interestRateVal, BigInteger creditVal) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(issuerVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(holderVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(acceptorVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(issuanceTimeVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(interestRateVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(creditVal)));
        return deployRemoteCall(CreditLetter.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CreditLetter> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String issuerVal, String holderVal, String acceptorVal, BigInteger issuanceTimeVal, BigInteger interestRateVal, BigInteger creditVal) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(issuerVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(holderVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(acceptorVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(issuanceTimeVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(interestRateVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(creditVal)));
        return deployRemoteCall(CreditLetter.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CreditLetter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String issuerVal, String holderVal, String acceptorVal, BigInteger issuanceTimeVal, BigInteger interestRateVal, BigInteger creditVal) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(issuerVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(holderVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(acceptorVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(issuanceTimeVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(interestRateVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(creditVal)));
        return deployRemoteCall(CreditLetter.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CreditLetter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String issuerVal, String holderVal, String acceptorVal, BigInteger issuanceTimeVal, BigInteger interestRateVal, BigInteger creditVal) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(issuerVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(holderVal), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(acceptorVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(issuanceTimeVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(interestRateVal), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(creditVal)));
        return deployRemoteCall(CreditLetter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class StatusChangedEventResponse {
        public Log log;

        public BigInteger id;

        public Boolean latestStatus;

        public BigInteger timestamp;
    }

    public static class HolderChangedEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger timestamp;
    }

    public static class CreditChangedEventResponse {
        public Log log;

        public BigInteger original;

        public BigInteger amount;

        public BigInteger timestamp;
    }
}
