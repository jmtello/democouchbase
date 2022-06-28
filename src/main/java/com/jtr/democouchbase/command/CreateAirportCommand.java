package com.jtr.democouchbase.command;

public class CreateAirportCommand
{

	private String airportName;

	private String city;

	private String country;

	private String icao;

	private Long id;

	private String tz;

	public String getAirportName()
	{
		return airportName;
	}

	public void setAirportName(String airportName)
	{
		this.airportName = airportName;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getIcao()
	{
		return icao;
	}

	public void setIcao(String icao)
	{
		this.icao = icao;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTz()
	{
		return tz;
	}

	public void setTz(String tz)
	{
		this.tz = tz;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("CreateAirportCommand{");
		sb.append("airportName='").append(airportName).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append(", country='").append(country).append('\'');
		sb.append(", icao='").append(icao).append('\'');
		sb.append(", id=").append(id);
		sb.append(", tz='").append(tz).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
