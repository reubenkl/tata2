package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.Pack;

@Repository
public interface IPackRepository extends JpaRepository<Pack, Long>{

}
