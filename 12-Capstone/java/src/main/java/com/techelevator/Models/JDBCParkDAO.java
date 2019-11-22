package com.techelevator.Models;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		List<Park> parkList = new ArrayList<>();
		String sqlStatement = "SELECT parkcode, parkname, parkdescription FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);
		while (results.next()) {
			Park myPark = new Park();
			myPark.setParkCode(results.getString("parkcode").toLowerCase());
			myPark.setParkName(results.getString("parkname"));
			myPark.setParkDescription(results.getString("parkdescription"));
			parkList.add(myPark);
		}
		return parkList;
	}

	public List<Park> getPopularParks() {
		List<Park> parkList = new ArrayList<>();
		String sqlStatement = "SELECT COUNT(surveyid), P.parkname, S.parkcode" + 
				" FROM survey_result S" + 
				" INNER JOIN park P" + 
				" ON P.parkcode=S.parkcode" + 
				" GROUP BY S.parkcode, P.parkname" + 
				" ORDER BY COUNT(surveyid) DESC, P.parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);
		while (results.next()) {
			Park myPark = new Park();
			myPark.setCountOfSurveys(results.getInt("count"));
			myPark.setParkName(results.getString("parkname"));
			myPark.setParkCode(results.getString("parkcode").toLowerCase());
			parkList.add(myPark);
		}
		return parkList;
	}
	
	@Override
	public Park getSpecificPark(String parkcode) {
		Park myPark = new Park();
		String sqlStatement = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement, parkcode);
		while (results.next()) {
			myPark.setParkCode(results.getString("parkcode"));
			myPark.setParkName(results.getString("parkname"));
			myPark.setParkDescription(results.getString("parkdescription"));
			myPark.setParkState(results.getString("state"));
			myPark.setParkClimate(results.getString("climate"));
			myPark.setParkAcreage(results.getInt("acreage"));
			myPark.setParkElevation(results.getInt("elevationinfeet"));
			myPark.setParkTrailDistance(results.getDouble("milesoftrail"));
			myPark.setNumOfCampsites(results.getInt("numberofcampsites"));
			myPark.setParkYearFounded(results.getInt("yearfounded"));
			myPark.setParkVisitorCount(results.getInt("annualvisitorcount"));
			myPark.setParkInspirationalQuote(results.getString("inspirationalquote"));
			myPark.setParkInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			myPark.setEntryFee(results.getInt("entryfee"));
			myPark.setNumAnimalSpecies(results.getInt("numberofanimalspecies"));
		}
		return myPark;
	}

}
