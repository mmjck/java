package com.magalu.notificaion_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magalu.notificaion_ms.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long>{
    
}
