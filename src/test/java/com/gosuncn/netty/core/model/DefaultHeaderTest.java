package com.gosuncn.netty.core.model;


import org.junit.Before;
import org.junit.Test;

import com.gosuncn.netty.common.util.JsonUtils;
import com.gosuncn.netty.common.util.LoggerUtils;

public class DefaultHeaderTest {

	private DefaultRequestHeader requestHeader;
	
	private DefaultResponseHeader responseHeader;
	
	private DefaultRequestDTO defaultDTO;
	
	@Before
	public void init(){
		
		requestHeader = new DefaultRequestHeader();
		requestHeader.setRequestType((short)1);
		requestHeader.setUrl("xiaomo/helloworld");
		
		responseHeader = new DefaultResponseHeader();
		responseHeader.setResponseType((short)1);
		responseHeader.setStatus((short)2);
		
		defaultDTO = new DefaultRequestDTO();
		defaultDTO.setHeaderLen((short)requestHeader.getBytes().length);
		defaultDTO.setHeader(requestHeader);
		
		byte[] body = new byte[10];
		body[0] = 6;
		body[1] = 6;
		body[2] = 6;
		defaultDTO.setBodyLen(body.length);
		defaultDTO.setBody(body);
	}
	
	
	@Test
	public void testRequestHeader(){
		
		LoggerUtils.info("requestHeader对象-{}",JsonUtils.toJsonString(requestHeader));
		
		byte[] data = requestHeader.getBytes(); 
		
		LoggerUtils.info("转换后的字节数组-{}",data);
		
		DefaultRequestHeader exchangedHeader = new DefaultRequestHeader();
		exchangedHeader.readFromBytes(data);
		
		LoggerUtils.info("exchangedHeader对象-{}",JsonUtils.toJsonString(exchangedHeader));
		
	}
	
	@Test
	public void testResponseHeader(){
		
		LoggerUtils.info("responseHeader对象-{}",JsonUtils.toJsonString(responseHeader));
		
		byte[] data = responseHeader.getBytes();
		
		LoggerUtils.info("转换后的字节数组-{}",data);
		
		DefaultResponseHeader exchangedHeader = new DefaultResponseHeader();
		exchangedHeader.readFromBytes(data);
		
		LoggerUtils.info("exchangedHeader对象-{}",JsonUtils.toJsonString(exchangedHeader));
		
	}
	
	@Test
	public void testDefaultDTO(){
		
		LoggerUtils.info("defaultDTO对象-{}",JsonUtils.toJsonString(defaultDTO));
		
		byte[] data = defaultDTO.getBytes();
		
		LoggerUtils.info("转换后的字节数组-{}",data);
		
		DefaultResponseDTO exchangedDTO = new DefaultResponseDTO();
		exchangedDTO.readFromBytes(data);
		
		LoggerUtils.info("exchangedDTO对象-{}",JsonUtils.toJsonString(exchangedDTO));
		
	}

}
