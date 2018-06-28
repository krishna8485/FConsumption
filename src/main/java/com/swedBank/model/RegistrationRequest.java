package com.swedBank.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RegistrationRequest implements Serializable {
	
	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -70951366952153374L;
	private String fuelType;
    private String price;
    private String volume;
    private String date;
    private String driverId;
    
	public RegistrationRequest() {
		super();
	}
	public RegistrationRequest(String fuelType, String price, String volume, String date, String driverId) {
		super();
		this.fuelType = fuelType;
		this.price = price;
		this.volume = volume;
		this.date = date;
		this.driverId = driverId;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

    @ApiModelProperty(required = true, dataType = "java.lang.String", example ="95")
    public String getFuelType() {
        return fuelType;
    }

    @ApiModelProperty(required = true, dataType = "java.lang.String", example ="10.10")
    public String getPrice() {
        return price;
    }

    @ApiModelProperty(required = true, dataType = "java.lang.String", example ="12.5")
    public String getVolume() {
        return volume;
    }
    @ApiModelProperty(required = true, dataType = "java.lang.String", example ="01.21.2018")
    public String getDate() {
        return date;
    }


    @ApiModelProperty(required = true, dataType = "java.lang.String", example ="12345")
    public String getDriverId() {
        return driverId;
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((driverId == null) ? 0 : driverId.hashCode());
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationRequest other = (RegistrationRequest) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (driverId == null) {
			if (other.driverId != null)
				return false;
		} else if (!driverId.equals(other.driverId))
			return false;
		if (fuelType == null) {
			if (other.fuelType != null)
				return false;
		} else if (!fuelType.equals(other.fuelType))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegistrationRequest [fuelType=" + fuelType + ", price=" + price + ", volume=" + volume + ", date="
				+ date + ", driverId=" + driverId + "]";
	}


}
