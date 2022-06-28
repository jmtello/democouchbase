package com.jtr.democouchbase.dao;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jtr.democouchbase.entity.Airport;

public interface AirportRepository extends PagingAndSortingRepository<Airport, String> 
{

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND country = $country")
    Page<Airport> list(String country, Pageable pageable);

    Page<Airport> findByCountry(String country, Pageable pageable);
    
    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter}")
    Page<Airport> findAll(Pageable pageable);
}
