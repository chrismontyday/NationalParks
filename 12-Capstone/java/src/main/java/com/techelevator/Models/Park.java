package com.techelevator.Models;

public class Park {
	private String parkName;
	private String parkDescription;
	private String parkCode;
	private String parkState;
	private String parkClimate;
	private int parkAcreage;
	private int parkElevation;
	private Double parkTrailDistance;
	private int numOfCampsites;
	private int parkYearFounded;
	private int parkVisitorCount;
	private String parkInspirationalQuote;
	private String parkInspirationalQuoteSource;
	
	public String getParkInspirationalQuoteSource() {
		return parkInspirationalQuoteSource;
	}
	public void setParkInspirationalQuoteSource(String parkInspirationalQuoteSource) {
		this.parkInspirationalQuoteSource = parkInspirationalQuoteSource;
	}
	private int countOfSurveys;
	private int entryFee;
	private int numAnimalSpecies;
	
	
	public Double getParkTrailDistance() {
		return parkTrailDistance;
	}
	public void setParkTrailDistance(Double parkTrailDistance) {
		this.parkTrailDistance = parkTrailDistance;
	}
	public int getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumAnimalSpecies() {
		return numAnimalSpecies;
	}
	public void setNumAnimalSpecies(int numAnimalSpecies) {
		this.numAnimalSpecies = numAnimalSpecies;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getParkDescription() {
		return parkDescription;
	}
	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkState() {
		return parkState;
	}
	public void setParkState(String parkState) {
		this.parkState = parkState;
	}
	public String getParkClimate() {
		return parkClimate;
	}
	public void setParkClimate(String parkClimate) {
		this.parkClimate = parkClimate;
	}

	public int getParkAcreage() {
		return parkAcreage;
	}
	public void setParkAcreage(int parkAcreage) {
		this.parkAcreage = parkAcreage;
	}
	public int getParkElevation() {
		return parkElevation;
	}
	public void setParkElevation(int parkElevation) {
		this.parkElevation = parkElevation;
	}

	public int getNumOfCampsites() {
		return numOfCampsites;
	}
	public void setNumOfCampsites(int numOfCampsites) {
		this.numOfCampsites = numOfCampsites;
	}
	public int getParkYearFounded() {
		return parkYearFounded;
	}
	public void setParkYearFounded(int parkYearFounded) {
		this.parkYearFounded = parkYearFounded;
	}
	public int getParkVisitorCount() {
		return parkVisitorCount;
	}
	public void setParkVisitorCount(int parkVisitorCount) {
		this.parkVisitorCount = parkVisitorCount;
	}
	public String getParkInspirationalQuote() {
		return parkInspirationalQuote;
	}
	public void setParkInspirationalQuote(String parkInspirationalQuote) {
		this.parkInspirationalQuote = parkInspirationalQuote;
	}
	public int getCountOfSurveys() {
		return countOfSurveys;
	}
	public void setCountOfSurveys(int countOfSurveys) {
		this.countOfSurveys = countOfSurveys;
	}

}
