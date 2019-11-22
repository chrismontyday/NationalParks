package com.techelevator.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Weather {

	private String parkCode;
	private Integer fiveDayForecastValue;
	private Integer low;
	private Integer high;
	private String forecast;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public Integer getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(Integer fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public int getCelsiusLowTemp() {

		Double tempInC = (low - 32) / 1.8;
		int convTemp = tempInC.intValue();
		return convTemp;
	}

	public int getCelsiusHighTemp() {

		Double tempInC = (high - 32) / 1.8;
		int convTemp = tempInC.intValue();
		return convTemp;
	}

	public String getDayOfTheWeek() {

		LocalDate date = LocalDate.now();

		if (fiveDayForecastValue == 1) {
			return "Today";
		} else if (fiveDayForecastValue == 2) {
			return "Tomorrow";
		} else
			date = date.plusDays(fiveDayForecastValue - 1);
		return date.getDayOfWeek().toString();
	}

	public String getWeatherAdvice() {

		Integer diff = high - low;

		if (forecast.equals("snow")) {
			return "Burrr! Pack your snow shoes! a'hyuck!";
		} else if (forecast.equals("thunderstorms")) {
			return "Seek shelter and avoid hiking on exposed ridges.";
		} else if (forecast.equals("rain")) {
			return "Pack your rain gear.";
		} else if (high > 75 || low > 75) {
			return "Make sure to bring an extra gallon of water";
		} else if (diff > 20) {
			return "Wear breathable clothes";
		} else if (high < -20 || low < -20) {
			return "Exposure to extremely fridgid temperatures can be life-threatening and is extremely dangerous";
		} else if (forecast.equals("sunny")) {
			return "Bring your sunblock.";
		} return "Happy Hiking!";
	}

}
