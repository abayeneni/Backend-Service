package com.cvs.simulator.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cvs.simulator.entity.StoreFeed;

@Service
public class StorefeeduploadService {

	@Autowired
	private RestTemplate restTemplate;

	static final String FEED_UPLOAD_URL = "https://ere-stores-service-qa.apps.pcf.cic.cvshealth.com/stores/feed/upload";

	public void uploadFeeds(List<StoreFeed> storefeedlist) {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON }));
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> entity = new HttpEntity<Object>(storefeedlist, header);
		
		ResponseEntity<String> response = restTemplate.exchange(FEED_UPLOAD_URL, HttpMethod.POST, entity, String.class);
	}
}
