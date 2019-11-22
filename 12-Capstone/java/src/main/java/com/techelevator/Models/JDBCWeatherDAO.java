package com.techelevator.Models;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherFromSpecificPark(String parkcode) {
		List<Weather> weather = new ArrayList<>();
		String sqlStatement = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement, parkcode);
		while (results.next()) {
			Weather myWeather = new Weather();
			myWeather.setParkCode(results.getString("parkcode").toLowerCase());
			myWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));;
			myWeather.setHigh(results.getInt("high"));
			myWeather.setLow(results.getInt("low"));
			myWeather.setForecast(results.getString("forecast").toLowerCase().replaceAll(" ", ""));
			weather.add(myWeather);
		}
		return weather;
	}
	
	
}

