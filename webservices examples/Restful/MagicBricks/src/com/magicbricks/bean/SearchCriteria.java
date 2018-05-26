package com.magicbricks.bean;

import java.util.List;

import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.annotations.Query;

public class SearchCriteria {
	@PathParam("city")
	protected String city;
	@QueryParam("apartmentType")
	protected String apartmentType;
	@QueryParam("minBudget")
	protected double minBudget;
	@QueryParam("maxBudget")
	protected double maxBudget;
	@MatrixParam("area")
	protected String area;
	@QueryParam("amenities")
	protected List<String> amenities;
	@QueryParam("builderName")
	protected String builderName;
	@QueryParam("facing")
	protected String facing;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getApartmentType() {
		return apartmentType;
	}

	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}

	public double getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(double minBudget) {
		this.minBudget = minBudget;
	}

	public double getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(double maxBudget) {
		this.maxBudget = maxBudget;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	@Override
	public String toString() {
		return "SearchCriteria [city=" + city + ", apartmentType=" + apartmentType + ", minBudget=" + minBudget
				+ ", maxBudget=" + maxBudget + ", area=" + area + ", amenities=" + amenities + ", builderName="
				+ builderName + ", facing=" + facing + "]";
	}

}
