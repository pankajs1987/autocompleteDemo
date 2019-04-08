package com.pramati.sample.autocomplete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutocompleteController {

// http://localhost:8080/suggestion?searchstr=car

	/**
	 * the rest controller which is requested by the autocomplete input field
	 * instead of the countries here could also be made a DB request
	 */
	@RequestMapping(value = "/suggest_cities", method = RequestMethod.GET,produces=MediaType.TEXT_PLAIN_VALUE)
	public String autocompleteSuggestions(@RequestParam(value = "start", required = true) String searchstr,
			@RequestParam(value = "atmost", required = true) int noOfResults) {
		System.out.println("searchstr: " + searchstr);
		List<String> suggestions = new ArrayList<>();
		Application.citiesList.forEach(city -> {
			if (city.toLowerCase().contains(searchstr.toLowerCase())) {
				suggestions.add(city);
			}
		});
		List<String> sulb = new ArrayList<>(suggestions.subList(0, noOfResults));
		StringBuffer buff = new StringBuffer();
		sulb.forEach(city->{
			buff.append(city+"\n");
		});
		SuggestionWrapper sw = new SuggestionWrapper();
		sw.setSuggestions(sulb);
		return buff.toString();
	}

}
