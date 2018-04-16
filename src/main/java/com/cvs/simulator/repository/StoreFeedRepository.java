package com.cvs.simulator.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvs.simulator.entity.StoreFeed;

@Transactional
public interface StoreFeedRepository extends JpaRepository<StoreFeed, Long> {
	
	StoreFeed findById(long id);
	
	List<StoreFeed> findByStatus(String statusUploaded);
}
