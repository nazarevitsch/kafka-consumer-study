package com.study.kafka.consumer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "message")
public class DbMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;

    private Integer message;

    private Integer price;

    private String brand;

    private String state;

    private Long offsetCount;

    private Integer producerId;

    private Integer consumerId;

    private String consumerGroup;

    private Integer partitionId;

    private Long threadId;

    @CreationTimestamp
    private Instant creationDate;
}
