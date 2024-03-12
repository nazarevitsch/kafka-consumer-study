package com.study.kafka.consumer.service;

import com.study.kafka.consumer.dao.PersonDao;
import com.study.kafka.consumer.model.DbMessage;
import com.kafka.study.producer.client.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaService {

    private final PersonDao personDao;

    @Value("${pod.id}")
    private Integer podId;

    @Value("${kafka.consumer.group.name}")
    private String groupId;

    @KafkaListener(
            topics = "${kafka.topic.name}",
            groupId = "${kafka.consumer.group.name}",
            concurrency = "${kafka.consumer.concurrency}")
    public void listenGroup1(ConsumerRecord<String, Message> record) {
        log.info("Received Message in group: {}, message: {}", groupId, record.value());
        DbMessage personToSave = new DbMessage();
        personToSave.setMessage(record.value().getMessage());
        personToSave.setProducerId(record.value().getProducerId());
        personToSave.setKey(record.key());
        personToSave.setOffsetCount(record.offset());
        personToSave.setConsumerId(this.podId);
        personToSave.setConsumerGroup(groupId);
        personToSave.setBrand(record.value().getBrand());
        personToSave.setState(record.value().getState());
        personToSave.setPrice(record.value().getPrice());
        personToSave.setPartitionId(record.partition());
        personToSave.setThreadId(Thread.currentThread().getId());
        personDao.save(personToSave);
//        acknowledgment.acknowledge();
    }

    @KafkaListener(
            topics = "${kafka.topic.name2}",
            groupId = "${kafka.consumer.group.name}",
            concurrency = "${kafka.consumer.concurrency}")
    public void listenGroup2(ConsumerRecord<String, Integer> record) {
        log.info("Received Message 2 in group: {}, message: {}", groupId, record.value());
    }
}
