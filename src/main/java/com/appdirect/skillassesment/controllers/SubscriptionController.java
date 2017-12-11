package com.appdirect.skillassesment.controllers;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.skillassesment.dto.CreateSubscriptionDTO;
import com.appdirect.skillassesment.util.OAuthUtil;
import com.appdirect.skillassesment.web.AppHttpClient;
import com.appdirect.skillassesment.web.ErrorCode;
import com.appdirect.skillassesment.web.HTTPMethod;
import com.appdirect.skillassesment.web.Response;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
	@Autowired
	private OAuthUtil oAuthUtil;
	private static final String requestUrl = "http://rahul91.ca:8080/api/subscription";
	
	@RequestMapping(value = "/create", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Response create(HttpServletRequest httpServletRequest, @RequestHeader("authorization") String authorizationHeader ,@RequestParam("url") String url) {
		Response response = null;
		try{
			response = new Response();
			Map<String, String> map = oAuthUtil.parseOAuthHeader(authorizationHeader);
			final String urlDecoder = URLDecoder.decode(url.toString(), "UTF-8");
			if(map == null || map.isEmpty()){
				throw new AuthenticationException();
			}
			String requestUrl = httpServletRequest.getRequestURL().toString();
			String timestamp = map.containsKey(OAuthUtil.OAUTH_TIMESTAMP) ? map.get(OAuthUtil.OAUTH_TIMESTAMP) : null;
			String nonce = map.containsKey(OAuthUtil.OAUTH_NONCE) ? map.get(OAuthUtil.OAUTH_NONCE) : null;
			String signature = map.containsKey(OAuthUtil.OAUTH_SIGNATURE) ? map.get(OAuthUtil.OAUTH_SIGNATURE) : null;
			String signatureMethod = map.containsKey(OAuthUtil.OAUTH_SIGNATURE_METHOD) ? map.get(OAuthUtil.OAUTH_SIGNATURE_METHOD) : null;
			Set<String> params = new HashSet<String>(){{add("url");}};
			List<String> values = new ArrayList<String>(){{add(urlDecoder);}};
			AppHttpClient<CreateSubscriptionDTO> appHttpClient = new AppHttpClient<>(CreateSubscriptionDTO.class);
			if(StringUtils.isNotBlank(urlDecoder)){
				CreateSubscriptionDTO createSubscriptionDTO = appHttpClient.getEventDetail(urlDecoder);
				String accountIdentifier = createSubscriptionDTO.getPayloadDTO().getCompanyDTO().getUuid();
			}
			response.setSuccess(true);
			response.setAccountIdentifier("new-account-identifier");
			return response;
		} 
		catch(AuthenticationException authenticationException){
			response = new Response();
			response.setSuccess(false);
			response.setErrorCode(ErrorCode.ACCOUNT_NOT_FOUND.getCode());
			response.setErrorCode(ErrorCode.ACCOUNT_NOT_FOUND.getMessage());
			return response;
		}
		catch(Exception exception){
			response = new Response();
			response.setSuccess(false);
			response.setErrorCode(ErrorCode.BAD_REQUEST.getCode());
			response.setErrorCode(ErrorCode.BAD_REQUEST.getMessage());
			return response;
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Response delete(@RequestHeader("authorization") String authorizationHeader ,@RequestParam("url") String url) {
		Response response = null;
		try{
			response = new Response();
			Map<String, String> map = oAuthUtil.parseOAuthHeader(authorizationHeader);
			final String urlDecoder = URLDecoder.decode(url.toString(), "UTF-8");
			if(map == null || map.isEmpty()){
				throw new AuthenticationException();
			}
			String timestamp = map.containsKey(OAuthUtil.OAUTH_TIMESTAMP) ? map.get(OAuthUtil.OAUTH_TIMESTAMP) : null;
			String nonce = map.containsKey(OAuthUtil.OAUTH_NONCE) ? map.get(OAuthUtil.OAUTH_NONCE) : null;
			String signature = map.containsKey(OAuthUtil.OAUTH_SIGNATURE) ? map.get(OAuthUtil.OAUTH_SIGNATURE) : null;
			String signatureMethod = map.containsKey(OAuthUtil.OAUTH_SIGNATURE_METHOD) ? map.get(OAuthUtil.OAUTH_SIGNATURE_METHOD) : null;
			Set<String> params = new HashSet<String>(){{add("url");}};
			List<String> values = new ArrayList<String>(){{add(urlDecoder);}};
			AppHttpClient<CreateSubscriptionDTO> appHttpClient = new AppHttpClient<>(CreateSubscriptionDTO.class);
			CreateSubscriptionDTO createSubscriptionDTO = appHttpClient.getEventDetail(urlDecoder);
			String accountIdentifier = createSubscriptionDTO.getPayloadDTO().getCompanyDTO().getUuid();
			response.setSuccess(true);
			response.setAccountIdentifier(accountIdentifier);
			return response;
		} 
		catch(AuthenticationException authenticationException){
			response = new Response();
			response.setSuccess(false);
			response.setErrorCode(ErrorCode.ACCOUNT_NOT_FOUND.getCode());
			response.setErrorCode(ErrorCode.ACCOUNT_NOT_FOUND.getMessage());
			return response;
		}
		catch(Exception exception){
			response = new Response();
			response.setSuccess(false);
			response.setErrorCode(ErrorCode.BAD_REQUEST.getCode());
			response.setErrorCode(ErrorCode.BAD_REQUEST.getMessage());
			return response;
		}
	}
	
}
