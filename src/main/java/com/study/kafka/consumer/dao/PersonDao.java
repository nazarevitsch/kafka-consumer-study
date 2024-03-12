package com.study.kafka.consumer.dao;

import com.study.kafka.consumer.model.DbMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<DbMessage, Long> {
}
