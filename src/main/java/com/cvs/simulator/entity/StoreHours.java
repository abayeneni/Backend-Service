package com.cvs.simulator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store_hours")
public class StoreHours
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String twentyFourHourIndicator;

    private String day;

    private String closeHour;

    public String getTwentyFourHourIndicator ()
    {
        return twentyFourHourIndicator;
    }

    public void setTwentyFourHourIndicator (String twentyFourHourIndicator)
    {
        this.twentyFourHourIndicator = twentyFourHourIndicator;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }

    public String getCloseHour ()
    {
        return closeHour;
    }

    public void setCloseHour (String closeHour)
    {
        this.closeHour = closeHour;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [twentyFourHourIndicator = "+twentyFourHourIndicator+", day = "+day+", closeHour = "+closeHour+"]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
			