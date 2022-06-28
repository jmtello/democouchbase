package com.jtr.democouchbase.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jtr.democouchbase.command.CreateAirportCommand;
import com.jtr.democouchbase.dao.AirportRepository;
import com.jtr.democouchbase.entity.Airport;

@Service
public class AirportService
{

	private final AirportRepository airportRepository;

	public AirportService(AirportRepository airportRepository)
	{
		this.airportRepository = airportRepository;
	}

	public List<Airport> list(int pageNumber, int pageSize)
	{
		Iterable<Airport> airportIterable = airportRepository.findAll();
		List<Airport> airports = new ArrayList<>();
		airportIterable.forEach(airports::add);
		return airports;
	}

	public List<Airport> list(String country, int pageNumber, int pageSize)
	{

		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

		Page<Airport> page = airportRepository.findByCountry(country, pageRequest);

		return page.getContent();
	}

	public Airport create(CreateAirportCommand command)
	{

		String airportName = command.getAirportName();
		String city = command.getCity();
		String country = command.getCountry();
		String icao = command.getIcao();
		Long id = command.getId();
		String type = Airport.TYPE;
		String tz = command.getTz();

		Airport airport = new Airport(airportName, city, country, icao, id, tz, type);

		airportRepository.save(airport);

		return airport;
	}
}
