package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.community.gateway.model.City;
import com.community.gateway.model.District;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

	Iterable<City> findAllByDistrict(District district);

}
