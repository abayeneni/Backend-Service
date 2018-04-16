package com.cvs.simulator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RetailPharmacyLocation
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String region;

    private String division;

    private String state;

    private String district;

    public String getRegion ()
    {
        return region;
    }

    public void setRegion (String region)
    {
        this.region = region;
    }

    public String getDivision ()
    {
        return division;
    }

    public void setDivision (String division)
    {
        this.division = division;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getDistrict ()
    {
        return district;
    }

    public void setDistrict (String district)
    {
        this.district = district;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [region = "+region+", division = "+division+", state = "+state+", district = "+district+"]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
