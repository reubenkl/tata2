package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

}
