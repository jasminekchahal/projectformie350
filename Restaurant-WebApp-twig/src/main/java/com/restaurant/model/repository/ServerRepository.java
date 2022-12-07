package com.restaurant.model.repository;

import org.springframework.stereotype.Repository;
import com.restaurant.model.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long>
{

}

