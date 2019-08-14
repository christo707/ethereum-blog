package com.blogdapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import com.blogdapp.config.EthereumConfig;
import com.blogdapp.service.Web3jService;

@RestController
@RequestMapping(value = "/api/v1/deploy")
public class DeploymentController {
	
	@Autowired
	Web3jService web3jService;
	
	@Autowired
	Web3j web3j;
	
	@Autowired
	EthereumConfig ethereumConfig;
	
	@RequestMapping(value = "/blogs",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> deployBlogContract(){
		Credentials cred = ethereumConfig.getCredentialsFromPrivateKey();
		try {
			String add = web3jService.deployContract(web3j, cred);
			return ResponseEntity.status(200).body("Blog contract deployed with address: " + add);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error in deploying Blog COntract");
		}
		
	}

}
