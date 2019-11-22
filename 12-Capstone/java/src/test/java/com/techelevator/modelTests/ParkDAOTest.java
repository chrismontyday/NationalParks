package com.techelevator.modelTests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.Models.JDBCParkDAO;
import com.techelevator.Models.Park;
import com.techelevator.Models.ParkDAO;


public class ParkDAOTest {

	private static SingleConnectionDataSource dataSource;
	private ParkDAO parkDAO;
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
		parkDAO= new JDBCParkDAO(dataSource);
	}

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	@Test
	public void allParksListTest() {
		List<Park> myParks = parkDAO.getAllParks();
		assertEquals(10, myParks.size());
	}
	@Test
	public void popularParks() {
		List<Park> myParks=parkDAO.getPopularParks();
		Park myPark = new Park();
		Park mySecondPark = new Park();
		if(myParks.size()>1) {
			myPark = myParks.get(0);
			mySecondPark= myParks.get(1);
			Boolean oneGreaterThanTwo = myPark.getCountOfSurveys()>=mySecondPark.getCountOfSurveys();
			assertEquals(true, oneGreaterThanTwo);
			for(Park tempPark : myParks) {
				Boolean isNotZero = tempPark.getCountOfSurveys()>0;
				assertEquals(true, isNotZero);
			}
		}
		else if (myParks.size()==1) {
			myPark=myParks.get(0);
			Boolean hasSurveyCount = myPark.getCountOfSurveys()>=1;
			assertEquals(true, hasSurveyCount);
		}

	}
	@Test
	public void specificParkTest() {
		String parkCode = "YNP";
		
		Park myPark = new Park();
		myPark=parkDAO.getSpecificPark(parkCode);
	    assertEquals("Yellowstone National Park", myPark.getParkName());
	}

}
