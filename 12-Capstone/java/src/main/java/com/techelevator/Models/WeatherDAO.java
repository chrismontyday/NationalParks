package com.techelevator.Models;

import java.util.List;

public interface WeatherDAO {

	public List<Weather> getWeatherFromSpecificPark(String parkcode);
}
