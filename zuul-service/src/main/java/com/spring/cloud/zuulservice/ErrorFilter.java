package com.spring.cloud.zuulservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class); 
	
	  @Override
	  public String filterType() {
	    return "error";
	  }
	 
	  @Override
	  public int filterOrder() {
	    return 1;
	  }
	 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	 
	  @Override
	  public Object run() {
		  System.out.println("Inside Error Filter");
		  RequestContext ctx = RequestContext.getCurrentContext();
	      String response = ctx.getResponseBody();
	      log.info("Error occurred, Response  = {}, ", response);
		  return null;
	  }
	}