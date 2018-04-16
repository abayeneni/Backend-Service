package com.cvs.simulator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StoreAttributes
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String pharmacyStatus;

    private String facilityType;

    private String storeType;

    public String getPharmacyStatus ()
    {
        return pharmacyStatus;
    }

    public void setPharmacyStatus (String pharmacyStatus)
    {
        this.pharmacyStatus = pharmacyStatus;
    }

    public String getFacilityType ()
    {
        return facilityType;
    }

    public void setFacilityType (String facilityType)
    {
        this.facilityType = facilityType;
    }

    public String getStoreType ()
    {
        return storeType;
    }

    public void setStoreType (String storeType)
    {
        this.storeType = storeType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pharmacyStatus = "+pharmacyStatus+", facilityType = "+facilityType+", storeType = "+storeType+"]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}