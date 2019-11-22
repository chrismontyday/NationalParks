package com.techelevator.npgeek;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.Models.Park;
import com.techelevator.Models.ParkDAO;
import com.techelevator.Models.Survey;
import com.techelevator.Models.SurveyDAO;
import com.techelevator.Models.Weather;
import com.techelevator.Models.WeatherDAO;

@Controller
public class HomeController {

	@Autowired
	private ParkDAO dao;
	
	@Autowired
	private SurveyDAO survDAO;
	
	@Autowired 
	private WeatherDAO weathDAO;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayHomePage(ModelMap model) {
		List<Park> park = dao.getAllParks();
		model.put("npgeek", park);
		return "homePage";
	}

	@RequestMapping("/surveyPage")
	public String displaySurveyPage(ModelMap map) {
		if (!map.containsAttribute("survey")) {
			map.addAttribute("survey", new Survey());
		}

		return "surveyPage";
	}

	@RequestMapping(path = "/surveyPage", method = RequestMethod.POST)
	public String submitSurvey(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			flash.addFlashAttribute("survey", survey);
			return "redirect:/surveyPage";
		}

		survDAO.submitSurvey(survey);

		return "redirect:/favoritePage";
	}

	@RequestMapping("/favoritePage")
	public String displayFavoritesPage(ModelMap model) {
		List<Park> park = dao.getPopularParks();
		model.put("npgeek", park);
		return "favoritePage";
	}
	
	@RequestMapping(path="/parkPage", method = RequestMethod.GET)
	public String displayParkPage(@RequestParam (value="parkcode") String parkCode, ModelMap map) {
		Park park = dao.getSpecificPark(parkCode);
		map.put("npgeek", park);
		List<Weather> weather = weathDAO.getWeatherFromSpecificPark(parkCode);
		map.put("npgeek2", weather);
		
		return "parkPage";
	}
	
	@RequestMapping(path="/parkPage", method = RequestMethod.POST)
	public String displayParkPage(@RequestParam (value="temp") Boolean tempType, @RequestParam (value="tempCode") String parkCode, HttpSession mySession) {
		mySession.setAttribute("type", tempType);
		return "redirect:/parkPage?parkcode="+parkCode;
	}
	
}
