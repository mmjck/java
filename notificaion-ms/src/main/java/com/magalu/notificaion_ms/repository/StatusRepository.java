package com.magalu.notificaion_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magalu.notificaion_ms.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{
    
}
