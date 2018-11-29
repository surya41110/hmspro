package com.nareshit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nareshit.domain.Hospital;

public interface IHospitalRepository extends CrudRepository<Hospital, Integer> {
	
	/*@Query(name="findHospitalByName",
			value="from Hospital hosp where hosp.name like : "+ "\'%"+"hospName"+ "%\'")*/
	@Query(name="findHospitalByName",
			value="from Hospital hosp where lower(hosp.name) like lower(concat('%', :hospName,'%'))")
	public List<Hospital>  findHospitalByName(@Param("hospName")String name);
	
	
}
