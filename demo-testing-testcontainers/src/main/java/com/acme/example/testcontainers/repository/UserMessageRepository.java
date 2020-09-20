package com.acme.example.testcontainers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.example.testcontainers.entity.UserMessage;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

}
