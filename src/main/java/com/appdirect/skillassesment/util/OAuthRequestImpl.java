package com.appdirect.skillassesment.util;

import java.net.URL;
import java.util.List;
import java.util.Set;

import com.appdirect.skillassesment.web.HTTPMethod;
import com.sun.jersey.oauth.signature.OAuthRequest;

public class OAuthRequestImpl implements OAuthRequest {
	
	private HTTPMethod httpMethod;
	private URL url;
	private Set<String> parameterNames;
	private List<String> parameterValues;
	
	
	public OAuthRequestImpl(HTTPMethod httpMethod, URL url, Set<String> paramterNames, 
			List<String> paramterValues){
		this.httpMethod = httpMethod;
		this.url = url;
		this.parameterNames = paramterNames;
		this.parameterValues = paramterValues;
	}

	@Override
	public String getRequestMethod() {
		// TODO Auto-generated method stub
		return httpMethod.getValue();
	}

	@Override
	public URL getRequestURL() {
		// TODO Auto-generated method stub
		return url;
	}

	@Override
	public Set<String> getParameterNames() {
		// TODO Auto-generated method stub
		return parameterNames;
	}

	@Override
	public List<String> getParameterValues(String name) {
		// TODO Auto-generated method stub
		return parameterValues;
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

	public HTTPMethod getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HTTPMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public List<String> getParameterValues() {
		return parameterValues;
	}


	public void setParameterValues(List<String> parameterValues) {
		this.parameterValues = parameterValues;
	}

	public void setParameterNames(Set<String> parameterNames) {
		this.parameterNames = parameterNames;
	}

}
