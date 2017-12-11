package com.appdirect.skillassesment.util;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;

import com.appdirect.skillassesment.web.HTTPMethod;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthRequest;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import com.sun.jersey.oauth.signature.OAuthSignature;
import com.sun.jersey.oauth.signature.OAuthSignatureException;

//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OAuthUtil {
	public static final String OAUTH_NONCE = "oauth_nonce";
	public static final String OAUTH_SIGNATURE = "oauth_signature";
	public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
	public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
	public static final String OAUTH_TIMESTAMP = "oauth_timestamp";
	public static final String CONSUMER_KEY = "test4-186870";
	public static final String CONSUMER_SECRET = "Fns4fN4EXpSsccG4";
	
	public boolean verifyRequest(final HTTPMethod httpMethod, final URL url, final Set<String> paramterNames, 
			final List<String> paramterValues, String timestamp, String nonce, String signature, String signatureMethod) 
					throws OAuthSignatureException{
	    	   	/*OAuthRequest oAuthRequest = new OAuthRequestImpl(httpMethod, url, paramterNames, paramterValues);*/
				OAuthRequest oAuthRequest = new OAuthRequest() {
					
					@Override
					public URL getRequestURL() {
						// TODO Auto-generated method stub
						return url;
					}
					
					@Override
					public String getRequestMethod() {
						// TODO Auto-generated method stub
						return httpMethod.getValue();
					}
					
					@Override
					public List<String> getParameterValues(String name) {
						// TODO Auto-generated method stub
						return paramterValues;
					}
					
					@Override
					public Set<String> getParameterNames() {
						// TODO Auto-generated method stub
						return paramterNames;
					}
					
					@Override
					public List<String> getHeaderValues(String name) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public void addHeaderValue(String name, String value)
							throws IllegalStateException {
						// TODO Auto-generated method stub
						
					}
				};
	      	
	    	   	OAuthSecrets oAuthSecrets = new OAuthSecrets();
	    	   	oAuthSecrets.setConsumerSecret(CONSUMER_SECRET);
	      	
		      	OAuthParameters oAuthParameters = new OAuthParameters();
		      	oAuthParameters.setNonce(nonce);
		      	oAuthParameters.setSignature(signature);
		      	oAuthParameters.setSignatureMethod(signatureMethod);
		      	oAuthParameters.setTimestamp(timestamp);
		      	oAuthParameters.setConsumerKey(CONSUMER_KEY);
		      	return OAuthSignature.verify(oAuthRequest, oAuthParameters, oAuthSecrets);
	}
	
	public static HttpRequest getOAuthHeader(HttpGet httpRequest) throws OAuthException, OAuthExpectationFailedException, OAuthCommunicationException {
		OAuthConsumer oAuthConsumer = new DefaultOAuthConsumer(SettingConstant.CONSUMER_KEY, SettingConstant.CONSUMER_SECRET);
		oAuthConsumer.sign(httpRequest);
		return httpRequest;
	}
	
	public Map<String, String> parseOAuthHeader(String authorizationHeader){
		Map<String, String> OAuthMap = null;
		if(StringUtils.isBlank(authorizationHeader)){
			return OAuthMap;
		}
		
		OAuthMap = new HashMap<>();
		String[] headerArray = authorizationHeader.split(",");
		for(String header : headerArray){
			if(header.contains(" ")){
				String[] headerToken = header.split(" ");
				header = headerToken[1];
			}
			String[] oAuthArray = header.trim().split("=");
			OAuthMap.put(oAuthArray[0], oAuthArray[1]);
					
		}
		return OAuthMap;
	}

}
