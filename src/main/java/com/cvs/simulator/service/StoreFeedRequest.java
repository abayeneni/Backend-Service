package com.cvs.simulator.service;

import java.util.List;

import com.cvs.simulator.entity.StoreFeed;

public class StoreFeedRequest {
	
	List<StoreFeed> storeFeed ;
	

	public List<StoreFeed> getStoreFeed() {
		return storeFeed;
	}

	public void setStoreFeed(List<StoreFeed> storeFeed) {
		this.storeFeed = storeFeed;
	}

}
