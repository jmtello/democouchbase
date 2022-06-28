package com.jtr.democouchbase.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jtr.democouchbase.command.CreateAirportCommand;
import com.jtr.democouchbase.entity.Airport;
import com.jtr.democouchbase.services.AirportService;

@RestController
public class AirportController
{

	private final AirportService airportService;

	public AirportController(AirportService airportService)
	{
		this.airportService = airportService;
	}

	@GetMapping("/airport")
	public List<Airport> list(@RequestParam int pageNumber, @RequestParam int pageSize)
	{
		return airportService.list(pageNumber, pageSize);
	}

	@GetMapping("find/airport/{country}")
	public List<Airport> list(@PathVariable String country, @RequestParam int pageNumber, @RequestParam int pageSize)
	{
		return airportService.list(country, pageNumber, pageSize);
	}

	@PostMapping("create/airport")
	public Airport create(@RequestBody CreateAirportCommand command)
	{
		return airportService.create(command);
	}

}
