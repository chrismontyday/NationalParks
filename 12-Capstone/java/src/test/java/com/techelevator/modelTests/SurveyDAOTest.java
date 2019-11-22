package com.techelevator.modelTests;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.Models.JDBCSurveyDAO;
import com.techelevator.Models.JDBCWeatherDAO;
import com.techelevator.Models.SurveyDAO;
import com.techelevator.Models.WeatherDAO;

public class SurveyDAOTest {

	private static SingleConnectionDataSource dataSource;
	private SurveyDAO surveyDAO;
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
		surveyDAO= new JDBCSurveyDAO(dataSource);
	}

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	
	//No testable methods

}
