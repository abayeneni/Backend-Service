package com.cvs.simulator.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class StoreFeed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private StoreAttributes storeAttributes;

	private int retailStoreId;

	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_hours")
	private List<StoreHours> storeHours = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private RetailPharmacyLocation retailPharmacyLocation;

	public StoreAttributes getStoreAttributes() {
		return storeAttributes;
	}

	public void setStoreAttributes(StoreAttributes storeAttributes) {
		this.storeAttributes = storeAttributes;
	}

	public int getRetailStoreId() {
		return retailStoreId;
	}

	public void setRetailStoreId(int retailStoreId) {
		this.retailStoreId = retailStoreId;
	}

	public RetailPharmacyLocation getRetailPharmacyLocation() {
		return retailPharmacyLocation;
	}

	public void setRetailPharmacyLocation(RetailPharmacyLocation retailPharmacyLocation) {
		this.retailPharmacyLocation = retailPharmacyLocation;
	}

	@Override
	public String toString() {
		return "ClassPojo [storeAttributes = " + storeAttributes + ", retailStoreId = " + retailStoreId
				+ ", storeHours = " + storeHours + ", retailPharmacyLocation = " + retailPharmacyLocation + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<StoreHours> getStoreHours() {
		return storeHours;
	}

	public void setStoreHours(List<StoreHours> storeHours) {
		this.storeHours = storeHours;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}