package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.Recharge;

@Repository
public interface IRechargeRepository extends JpaRepository<Recharge, Long>{

}
