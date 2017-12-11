package com.appdirect.skillassesment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateSubscriptionDTO {
	private String type;
	
	@JsonProperty("marketplace")
	private MarketplaceDTO marketplaceDTO;
	
	@JsonProperty("creator")
	private CreatorDTO creatorDTO;
	
	@JsonProperty("payload")
	private PayloadDTO payloadDTO;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MarketplaceDTO getMarketplaceDTO() {
		return marketplaceDTO;
	}
	public void setMarketplaceDTO(MarketplaceDTO marketplaceDTO) {
		this.marketplaceDTO = marketplaceDTO;
	}
	public CreatorDTO getCreatorDTO() {
		return creatorDTO;
	}
	public void setCreatorDTO(CreatorDTO creatorDTO) {
		this.creatorDTO = creatorDTO;
	}
	public PayloadDTO getPayloadDTO() {
		return payloadDTO;
	}
	public void setPayloadDTO(PayloadDTO payloadDTO) {
		this.payloadDTO = payloadDTO;
	}
	
	

}
