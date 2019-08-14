package com.blogdapp.controller;

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogdapp.VO.BlogRequestVO;
import com.blogdapp.VO.BlogVO;
import com.blogdapp.contracts.Blogs;
import com.blogdapp.service.BlogsService;

@RestController
@RequestMapping(value = "/api/v1/blogs")
public class BlogsController {
	
	@Autowired
	BlogsService blogsServiceImpl;
	
	@Autowired
	Blogs blog;
	
	@RequestMapping(value = "/total",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> totalBlogs(){
		try {
			java.math.BigInteger totalBlogs = blogsServiceImpl.totalBlogs(blog);
			return ResponseEntity.status(200).body("TotalBlogs :" + totalBlogs.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Unable to connect to Blockchain!!");
		}
	}
	
	@RequestMapping(value = "/add",
			method = RequestMethod.POST,
			headers="Accept=application/json",
			produces = "application/json")
	public ResponseEntity<String> addBlogs(
			@RequestBody BlogRequestVO _blog){
		try {
			blogsServiceImpl.addBlog(blog, _blog.getTitle(), _blog.getTypeOf(), _blog.getContent());
			return ResponseEntity.status(200).body("Blog Added!!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Unable to connect to Blockchain!!");
		}
	}
	
	@RequestMapping(value = "/get/{id}",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<BlogVO> getBlog(@PathVariable int id){
		try {
			BlogVO blogVo = blogsServiceImpl.getBlogs(blog, id);;
			return ResponseEntity.status(200).body(blogVo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}
	

}
