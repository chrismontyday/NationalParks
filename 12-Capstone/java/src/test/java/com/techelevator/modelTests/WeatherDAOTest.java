package com.techelevator.modelTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.Models.JDBCWeatherDAO;
import com.techelevator.Models.Weather;
import com.techelevator.Models.WeatherDAO;

public class WeatherDAOTest {
	private static SingleConnectionDataSource dataSource;
	private WeatherDAO weatherDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			dataSource = new SingleConnectionDataSource();
			dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
			dataSource.setUsername("postgres");
			dataSource.setPassword("postgres1");
			dataSource.setAutoCommit(false);
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dataSource.destroy();
	}

	@Before
	public void setUp() throws Exception {
		weatherDAO= new JDBCWeatherDAO(dataSource);
	}

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	public DataSource getDataSource() {
		return dataSource;
	}

	@Test
	public void weatherFromSpecificParkTempTest() {
		String parkCode="ENP";
		Integer expLow = 70;
		Integer expHighDay4 = 82;
		List<Weather> myWeather = new ArrayList<>();
		myWeather = weatherDAO.getWeatherFromSpecificPark(parkCode);
		assertEquals(5, myWeather.size());
		Weather testWeather = new Weather();
		testWeather=myWeather.get(0);
		assertEquals(expLow, testWeather.getLow());	
		testWeather=myWeather.get(3);
		assertEquals(expHighDay4, testWeather.getHigh());
	}
	@Test
	public void getCorrectForecastTest() {
		String parkCode="ENP";
		List<Weather> myWeather = new ArrayList<>();
		myWeather = weatherDAO.getWeatherFromSpecificPark(parkCode);
		assertEquals(5, myWeather.size());
		Weather testWeather = new Weather();
		testWeather=myWeather.get(2);
		assertEquals("partly cloudy", testWeather.getForecast());
	}

}
