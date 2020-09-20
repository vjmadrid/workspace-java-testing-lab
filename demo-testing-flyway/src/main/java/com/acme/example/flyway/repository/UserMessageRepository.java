package com.acme.example.flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.example.flyway.entity.UserMessage;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

}
