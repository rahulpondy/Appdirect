package com.appdirect.skillassesment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayloadDTO {
	@JsonProperty("company")
	private CompanyDTO companyDTO;
	
	@JsonProperty("order")
	private OrderDTO orderDTO;
	
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	public OrderDTO getOrderDTO() {
		return orderDTO;
	}
	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}
	
	

}
