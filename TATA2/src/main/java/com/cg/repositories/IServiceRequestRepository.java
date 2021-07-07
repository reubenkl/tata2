package com.cg.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.ServiceRequest;

@Repository
public interface IServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
	
	

}
