//package com.revature.bankapp.filter;
//
//import java.io.IOException;
//import java.util.Collection;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.revature.bankapp.model.Customer;
//
//@WebFilter("/*")
//public class CORSFilter implements Filter {
//	private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        LOGGER.info("Start of doFilter()");
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        String path = httpRequest.getRequestURL().toString();
//        LOGGER.debug("Servlet Path: **" + path + "**");
//        setCORSHeaders(httpResponse);
//        if (path.endsWith("/authenticate") || path.endsWith("/customers")) {
//        	LOGGER.debug("Inside authenticate");
//        	chain.doFilter(request, response);
//        } else {
//        	LOGGER.debug("Inside else of Authenticate");
//        	Customer customer = (Customer) httpRequest.getSession().getAttribute("customer");
//        	LOGGER.debug("Customer : {}", customer);
//        	if(customer == null) {
//        		httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        	} else {
//        		chain.doFilter(request, response);
//        	}
//        }
//        setCookieProperties(httpResponse);
//        LOGGER.info("End of doFilter()");
//    }
//
//	private void setCookieProperties(HttpServletResponse httpResponse) {
//		Collection<String> headers = httpResponse.getHeaders("Set-Cookie");
//		if (headers.size() == 1) {
//			String cookieValue = headers.iterator().next();
//			httpResponse.setHeader("Set-Cookie", cookieValue + "; SameSite=None; Secure");
//		}
//	}
//
//	private void setCORSHeaders(HttpServletResponse httpResponse) {
//		httpResponse.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
//		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST, DELETE");
//		httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
//		httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
//	}
//}
package com.revature.bankapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class CORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filter called.");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST, DELETE");
        httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
        chain.doFilter(request, response);
    }

   
}