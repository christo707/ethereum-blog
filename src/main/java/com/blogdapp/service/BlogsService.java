package com.blogdapp.service;

import java.math.BigInteger;

import com.blogdapp.VO.BlogVO;
import com.blogdapp.contracts.Blogs;

public interface BlogsService {
	
	public void addBlog(Blogs blog, String title, String typeOf, String blogContent) throws Exception;

	BigInteger totalBlogs(Blogs blog) throws Exception;

	BlogVO getBlogs(Blogs blog, int index) throws Exception;

}
