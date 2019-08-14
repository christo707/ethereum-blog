package com.blogdapp.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
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
 * <p>Generated with web3j version 4.3.0.
 */
public class Blogs extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610cbb806100206000396000f3fe608060405234801561001057600080fd5b50600436106100a95760003560e01c80636e1a9d68116100715780636e1a9d681461038d57806380f052d814610395578063aa7e56831461052b578063d0b2acd7146105d6578063df139560146105f9578063e7a918291461061c576100a9565b80632166c0f5146100ae5780634342f728146100e35780634639107c1461012257806348892753146102d2578063686bfa901461036a575b600080fd5b6100d1600480360360408110156100c457600080fd5b508035906020013561063f565b60408051918252519081900360200190f35b610106600480360360408110156100f957600080fd5b5080359060200135610661565b604080516001600160a01b039092168252519081900360200190f35b6102d06004803603606081101561013857600080fd5b810190602081018135600160201b81111561015257600080fd5b82018360208201111561016457600080fd5b803590602001918460018302840111600160201b8311171561018557600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156101d757600080fd5b8201836020820111156101e957600080fd5b803590602001918460018302840111600160201b8311171561020a57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561025c57600080fd5b82018360208201111561026e57600080fd5b803590602001918460018302840111600160201b8311171561028f57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061068b945050505050565b005b6102f5600480360360408110156102e857600080fd5b508035906020013561077e565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561032f578181015183820152602001610317565b50505050905090810190601f16801561035c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6100d16004803603604081101561038057600080fd5b508035906020013561082b565b6100d1610860565b6103b2600480360360208110156103ab57600080fd5b5035610866565b60405180898152602001888152602001876001600160a01b03166001600160a01b03168152602001806020018060200180602001868152602001858152602001848103845289818151815260200191508051906020019080838360005b8381101561042757818101518382015260200161040f565b50505050905090810190601f1680156104545780820380516001836020036101000a031916815260200191505b5084810383528851815288516020918201918a019080838360005b8381101561048757818101518382015260200161046f565b50505050905090810190601f1680156104b45780820380516001836020036101000a031916815260200191505b50848103825287518152875160209182019189019080838360005b838110156104e75781810151838201526020016104cf565b50505050905090810190601f1680156105145780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b6102d06004803603604081101561054157600080fd5b81359190810190604081016020820135600160201b81111561056257600080fd5b82018360208201111561057457600080fd5b803590602001918460018302840111600160201b8311171561059557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610a4d945050505050565b6102d0600480360360408110156105ec57600080fd5b5080359060200135610ae5565b6100d16004803603604081101561060f57600080fd5b5080359060200135610b9f565b6101066004803603604081101561063257600080fd5b5080359060200135610bc1565b6000918252600160208181526040808520938552600990930190529120015490565b6000918252600160209081526040808420928452600990920190529020546001600160a01b031690565b600080546001908101808355604080516101008101825282815242602080830191825233838501908152606084018b8152608085018b905260a085018a905260c0850189905260e08501899052958852868252939096208251815590519481019490945590516002840180546001600160a01b0319166001600160a01b0390921691909117905590518051919361072a92600385019290910190610beb565b5060808201518051610746916004840191602090910190610beb565b5060a08201518051610762916005840191602090910190610beb565b5060c0820151600682015560e090910151600790910155505050565b60008281526001602081815260408084208585526009018252928390206002908101805485519481161561010002600019011691909104601f8101839004830284018301909452838352606093909183018282801561081e5780601f106107f35761010080835404028352916020019161081e565b820191906000526020600020905b81548152906001019060200180831161080157829003601f168201915b5050505050905092915050565b600082815260016020908152604080832084845260080190915281206002015460ff16600581111561085957fe5b9392505050565b60005481565b60016020818152600092835260409283902080548184015460028084015460038501805489516101009982161599909902600019011692909204601f8101879004870288018701909852878752929691956001600160a01b03909316949091908301828280156109175780601f106108ec57610100808354040283529160200191610917565b820191906000526020600020905b8154815290600101906020018083116108fa57829003601f168201915b5050505060048301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156109a75780601f1061097c576101008083540402835291602001916109a7565b820191906000526020600020905b81548152906001019060200180831161098a57829003601f168201915b5050505060058301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610a375780601f10610a0c57610100808354040283529160200191610a37565b820191906000526020600020905b815481529060010190602001808311610a1a57829003601f168201915b5050505050908060060154908060070154905088565b60408051606081018252338152426020808301918252828401858152600087815260018084528682206007810154820183526009018452959020845181546001600160a01b0319166001600160a01b039091161781559251948301949094559251805192939192610ac49260028501920190610beb565b50505060009182525060016020819052604090912060070180549091019055565b60408051606081018252338152426020820152908101826005811115610b0757fe5b6005811115610b1257fe5b90526000838152600160208181526040808420600681015484018552600801825292839020845181546001600160a01b0319166001600160a01b039091161781559084015181830155918301516002830180549192909160ff191690836005811115610b7a57fe5b0217905550505060009182525060016020819052604090912060060180549091019055565b6000918252600160208181526040808520938552600890930190529120015490565b6000918252600160209081526040808420928452600890920190529020546001600160a01b031690565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610c2c57805160ff1916838001178555610c59565b82800160010185558215610c59579182015b82811115610c59578251825591602001919060010190610c3e565b50610c65929150610c69565b5090565b610c8391905b80821115610c655760008155600101610c6f565b9056fea265627a7a72305820ef6fe8edf156c6b904d455214afc45574cccfadc2dfc84d39bd3e768e2bd3ae664736f6c634300050a0032";

    public static final String FUNC_GETCOMMENTTIME = "getCommentTime";

    public static final String FUNC_GETCOMMENTOWNER = "getCommentOwner";

    public static final String FUNC_ADDBLOG = "addBlog";

    public static final String FUNC_GETCOMMENT = "getComment";

    public static final String FUNC_GETREACTION = "getReaction";

    public static final String FUNC_TOTALBLOGS = "totalBlogs";

    public static final String FUNC_BLOGS = "blogs";

    public static final String FUNC_ADDCOMMENT = "addComment";

    public static final String FUNC_ADDREACTION = "addReaction";

    public static final String FUNC_GETREACTIONTIME = "getReactionTime";

    public static final String FUNC_GETREACTIONOWNER = "getReactionOwner";

    @Deprecated
    protected Blogs(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Blogs(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Blogs(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Blogs(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getCommentTime(BigInteger _blogid, BigInteger _commentid) {
        final Function function = new Function(FUNC_GETCOMMENTTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.generated.Uint256(_commentid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getCommentOwner(BigInteger _blogid, BigInteger _commentid) {
        final Function function = new Function(FUNC_GETCOMMENTOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.generated.Uint256(_commentid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addBlog(String _title, String _typeOf, String _blog) {
        final Function function = new Function(
                FUNC_ADDBLOG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_typeOf), 
                new org.web3j.abi.datatypes.Utf8String(_blog)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getComment(BigInteger _blogid, BigInteger _commentid) {
        final Function function = new Function(FUNC_GETCOMMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.generated.Uint256(_commentid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getReaction(BigInteger _blogid, BigInteger _reactid) {
        final Function function = new Function(FUNC_GETREACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.generated.Uint256(_reactid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalBlogs() {
        final Function function = new Function(FUNC_TOTALBLOGS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple8<BigInteger, BigInteger, String, String, String, String, BigInteger, BigInteger>> blogs(BigInteger param0) {
        final Function function = new Function(FUNC_BLOGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple8<BigInteger, BigInteger, String, String, String, String, BigInteger, BigInteger>>(
                new Callable<Tuple8<BigInteger, BigInteger, String, String, String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, String, String, String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, BigInteger, String, String, String, String, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addComment(BigInteger _blogid, String _comment) {
        final Function function = new Function(
                FUNC_ADDCOMMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.Utf8String(_comment)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addReaction(BigInteger _blogid, BigInteger _reaction) {
        final Function function = new Function(
                FUNC_ADDREACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.generated.Uint256(_reaction)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getReactionTime(BigInteger _blogid, BigInteger _reactid) {
        final Function function = new Function(FUNC_GETREACTIONTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.generated.Uint256(_reactid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getReactionOwner(BigInteger _blogid, BigInteger _reactid) {
        final Function function = new Function(FUNC_GETREACTIONOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_blogid), 
                new org.web3j.abi.datatypes.generated.Uint256(_reactid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Blogs load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Blogs(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Blogs load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Blogs(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Blogs load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Blogs(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Blogs load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Blogs(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Blogs> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Blogs.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Blogs> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blogs.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Blogs> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Blogs.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Blogs> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blogs.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
