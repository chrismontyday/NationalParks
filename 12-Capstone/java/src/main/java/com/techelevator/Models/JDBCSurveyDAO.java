package com.techelevator.Models;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private int getNextId() {
		String sqlStatement = "SELECT NEXTVAL('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);
		results.next();
		return results.getInt(1);
	}

	public void submitSurvey(Survey survey) {
		int surveyId = getNextId();
		String sqlStatement = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlStatement, surveyId, survey.getParkCode(), survey.getEmailAddress(), survey.getStateId(),
				survey.getActivityLevel());
	}
	
}
