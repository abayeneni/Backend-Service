package com.cvs.simulator.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvs.simulator.entity.StoreFeed;
import com.cvs.simulator.repository.StoreFeedRepository;

@RestController
public class SimulatorServiceImpl implements simulatorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorServiceImpl.class);

	private static final String STATUS_UPLOADED = "uploaded";
	@Autowired
	private StoreFeedRepository storeFeedRepository;

	@Autowired
	private StorefeeduploadService uploadService;
	
	@Override
	public String home() {
		return "hello world";
	}

	@Override
	public ResponseEntity<String> getStoreFeed(@RequestBody StoreFeedRequest storeFeedRequest) {
		LOGGER.info("getStoreFeed :" + (storeFeedRequest.getStoreFeed() == null));
		LOGGER.info("is Empty" + storeFeedRequest.getStoreFeed().isEmpty());
		if (storeFeedRequest == null || storeFeedRequest.getStoreFeed() == null
				|| (!storeFeedRequest.getStoreFeed().isEmpty())) {
			for(StoreFeed storefeed:storeFeedRequest.getStoreFeed() ) {
				storefeed.setStatus(STATUS_UPLOADED);
			}
			storeFeedRepository.save(storeFeedRequest.getStoreFeed());
			uploadstorefeeds();
			return responseBuilder("successsfully loaded", HttpStatus.OK);
		}
		return responseBuilder("Invalid Data", HttpStatus.BAD_REQUEST);
	}
	
	private void uploadstorefeeds() {
		try {
		LOGGER.debug("uploadstorefeeds method");
		List<StoreFeed> storeFeedlist = storeFeedRepository.findByStatus( STATUS_UPLOADED);
		LOGGER.debug("storeFeedList :"+storeFeedlist.size());
		uploadService.uploadFeeds(storeFeedlist); 
		}catch(Exception ex) {
			LOGGER.error("unable to upload storefeeds",ex);
		}
	}

	private ResponseEntity<String> responseBuilder(String message, HttpStatus status) {
		return new ResponseEntity<String>(message, status);
	}
}
