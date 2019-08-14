package com.blogdapp.config;

import java.io.IOException;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.blogdapp.contracts.Blogs;

@Configuration
public class EthereumConfig {
	
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${node.url}")
	public String url;

	@Value("${node.privatekey}")
	public String PRIVATE_KEY;
	
	@Value("${node.account}")
	public String accountAddress;
	

	@Bean
	public Web3j startEthereum() {
		Web3j web3j = Web3j.build(new HttpService(url));
		try {
			logger.info("Connected to Ethereum client version: {}" , web3j.web3ClientVersion().send().getWeb3ClientVersion());
		} catch (IOException e) {
			logger.error(e.toString());
		}
		return web3j;
	}
	
	private Credentials getCredentialsFromWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
                "passphrase",	//EditMe
                "wallet/path"	//EditMe
        );
    }

    public Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

	private Credentials getCredentials() throws IOException, CipherException {
		Credentials credentials = null;
		try {
			credentials = WalletUtils.loadCredentials("", "credentials_path");	//EditMe
		} catch (Exception e) {
			logger.error("failure", e);
		}
		return credentials;
	} 

	public BigInteger getGasPrice() {
		return BigInteger.valueOf(20000000000L);
	}

	public BigInteger getGasLimit() {
		return BigInteger.valueOf(6721975);
	}


}
