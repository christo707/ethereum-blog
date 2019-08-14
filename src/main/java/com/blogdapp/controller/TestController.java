package com.blogdapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogdapp.service.Web3jService;

@RestController
@RequestMapping(value = "/api/v1")
public class TestController {
	
	@Autowired
	Web3jService web3jService;

	@RequestMapping(value = "/test",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity test(){
		return ResponseEntity.status(200).body("Blogs Dapp api is up!!!!!!");
	}
	
	@RequestMapping(value = "/web3j-client",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity web3jClientVersion(){
		try {
			String client = web3jService.getClientVersion();
			return ResponseEntity.status(200).body(client);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error is connecting Blockchain!!!!!!");
		}
	}
}
