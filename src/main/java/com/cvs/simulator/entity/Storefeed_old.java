package com.cvs.simulator.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Storefeed_old {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int storeId;
	
	private String state;
	
	private String division;
	
	private String region;
	
	private String district;
	
	private int storeType;
	
	private String storeHours;
	
	private String facilityType;
	
	private int pharmacyStatus;
	
	private String status;
	
	private Date loadTime;
	
	private Date updatedTime;

	
	public Storefeed_old(int storeId, String state, String division, String region, String district, int storeType,
			String storeHours, String facilityType, int pharmacyStatus, String status, Date loadTime,
			Date updatedTime) {
		super();
		this.storeId = storeId;
		this.state = state;
		this.division = division;
		this.region = region;
		this.district = district;
		this.storeType = storeType;
		this.storeHours = storeHours;
		this.facilityType = facilityType;
		this.pharmacyStatus = pharmacyStatus;
		this.status = status;
		this.loadTime = loadTime;
		this.updatedTime = updatedTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getStoreType() {
		return storeType;
	}

	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}

	public String getStoreHours() {
		return storeHours;
	}

	public void setStoreHours(String storeHours) {
		this.storeHours = storeHours;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public int getPharmacyStatus() {
		return pharmacyStatus;
	}

	public void setPharmacyStatus(int pharmacyStatus) {
		this.pharmacyStatus = pharmacyStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(Date loadTime) {
		this.loadTime = loadTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	

}