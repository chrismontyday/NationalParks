package com.techelevator.Models;

import java.util.List;

public interface ParkDAO {
	
	public List<Park> getAllParks();
	public List<Park> getPopularParks();
	Park getSpecificPark(String parkcode);

}
