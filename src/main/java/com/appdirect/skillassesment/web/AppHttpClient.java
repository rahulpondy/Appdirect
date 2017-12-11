package com.appdirect.skillassesment.web;

import java.io.IOException;
import java.net.URISyntaxException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import com.appdirect.skillassesment.util.OAuthUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppHttpClient<T> {
	@Autowired
	private OAuthUtil oAuthUtil;
	private Class<?> clazz;
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public AppHttpClient(Class<?> clazz){
		this.clazz = clazz;
	}
	
	public T getEventDetail(String url) throws HttpClientErrorException, 
	URISyntaxException, JsonParseException, 
	JsonMappingException, UnsupportedOperationException, 
	IOException, OAuthExpectationFailedException, 
	OAuthCommunicationException, OAuthException{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		httpGet =(HttpGet) oAuthUtil.getOAuthHeader(httpGet);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		T t = (T) objectMapper.readValue(httpResponse.getEntity().getContent(), clazz);
        return t;
	}
	
}
