package com.blogdapp.serviceImpl;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;

import com.blogdapp.VO.BlogVO;
import com.blogdapp.contracts.Blogs;
import com.blogdapp.service.BlogsService;

@Service
public class BlogsServiceImpl implements BlogsService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void addBlog(Blogs blog, String title, String typeOf, String blogContent) throws Exception{
		TransactionReceipt addBlogReceipt = blog.addBlog(title, typeOf, blogContent).send();
		logger.info("Receipt: " + addBlogReceipt.toString());
	}
	
	@Override
	public BigInteger totalBlogs(Blogs blog) throws Exception{
		BigInteger tb = blog.totalBlogs().send();
		logger.info("Total Blogs: " + tb.toString());
		return tb;
	}
	
	@Override
	public BlogVO getBlogs(Blogs blog, int index) throws Exception{
		BigInteger bi = BigInteger.valueOf(index);
		Tuple8<BigInteger, BigInteger, String, String, String, String, BigInteger, BigInteger> tb = blog.blogs(bi).send();
		BlogVO blogVo = new BlogVO(
				tb.getValue1().intValue(),
				tb.getValue2().longValue(),
				tb.getValue3(),
				tb.getValue4(),
				tb.getValue5(),
				tb.getValue6(),
				tb.getValue7().intValue(),
				tb.getValue8().intValue()
				);
		logger.info("Blog: " + blogVo);
		return blogVo;
	}

}
