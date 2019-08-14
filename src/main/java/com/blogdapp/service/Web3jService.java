package com.blogdapp.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import com.blogdapp.config.EthereumConfig;
import com.blogdapp.contracts.Blogs;

@Service
public class Web3jService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Web3j web3j;
	
	@Autowired
	EthereumConfig ethereumConfig;
	
	@Value("${blog.contract}")
	public String blogContractAddress;

	public String getClientVersion() throws IOException {
		Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
		logger.info("web3j clientVersion:: {}", web3ClientVersion);
		return web3ClientVersion.getWeb3ClientVersion();
	}
	
	@SuppressWarnings("deprecation")
	public String deployContract(Web3j web3j, Credentials credentials) throws Exception {
        return Blogs.deploy(web3j, credentials, ethereumConfig.getGasPrice(), ethereumConfig.getGasLimit())
                .send()
                .getContractAddress();
    }
	
	@SuppressWarnings("deprecation")
	private Blogs loadBlogContract(String contractAddress, Web3j web3j, Credentials credentials) {
        return Blogs.load(contractAddress, web3j, credentials, ethereumConfig.getGasPrice(), ethereumConfig.getGasLimit());
    }
	
	@Bean
	public Blogs getBlogContract() throws IOException, CipherException {
		Blogs blog = loadBlogContract(blogContractAddress, web3j, ethereumConfig.getCredentialsFromPrivateKey());
		return blog;
	}

	public String getContractAddress(String trHash) {
		String hash = null;
		EthGetTransactionReceipt transactionReceipt = null;
		try {
		Thread.sleep(15);
		transactionReceipt = web3j.ethGetTransactionReceipt(trHash).send();
		logger.info("In getcontractaddress- transactionReceipt:: {}", transactionReceipt.toString());
		if (transactionReceipt != null && transactionReceipt.getResult() != null) {
			hash = transactionReceipt.getResult().getContractAddress();
			logger.info("Contract Address Value:: {}", hash);
			return hash;
		}
		} catch (InterruptedException | IOException e) {
			logger.error("Exception :: {}" + e.getMessage());
			Thread.currentThread().interrupt();
		}
		return null;
	}

	public TransactionReceipt getTransactionReceipt(String trHash) {
		TransactionReceipt txReceipt = null;
		try {
			Thread.sleep(1500);

		EthGetTransactionReceipt receipt = web3j.ethGetTransactionReceipt(trHash).send();
		if (receipt.getTransactionReceipt().isPresent()) {
			txReceipt = receipt.getResult();
			logger.info("Tx receipt: {}", txReceipt);
		}
		} catch (InterruptedException | IOException e) {
			logger.error("Exception :: {}" + e.getMessage());
			Thread.currentThread().interrupt();
		}
		return txReceipt;

	}

	public BigInteger getBlockNumber(String trHash) {
		boolean blocks = true;
		Optional<TransactionReceipt> optionalReceipt;
		BigInteger blockNumber = BigInteger.valueOf(999);
		try {
		while (blocks) {
		
				optionalReceipt = web3j.ethGetTransactionReceipt(trHash).send().getTransactionReceipt();

			if(optionalReceipt.isPresent()) {
				blockNumber = optionalReceipt.get().getBlockNumber();
			}		
			if (blockNumber != null) {
				return blockNumber;
			}

		}
		} catch (IOException e) {
			logger.error("Exception :: {}" + e.getMessage());
		}
		return blockNumber;
	}

	public String getStatus(String trHash){
		String status = null;
		EthGetTransactionReceipt transactionReceipt = null;
		
		try {
			Thread.sleep(15);
			transactionReceipt = web3j.ethGetTransactionReceipt(trHash).send();

		if (transactionReceipt != null && transactionReceipt.getResult() != null) {
			status = transactionReceipt.getResult().getStatus();
			logger.info("Status :: {}", status);
			return status;
		}
		} catch (IOException | InterruptedException e) {
			logger.error("Exception :: {}" + e.getMessage());
			Thread.currentThread().interrupt();
		}
		return null;
	}

}
