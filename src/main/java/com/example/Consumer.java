package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaConfig.class);



    @KafkaListener(topics = "tanana-56300.messages", groupId = "tanana-56300.demo-group")
    public void listenWithHeaders(@Payload Foo message,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        LOG.info("Received Message: " + message.toString() + "from partition: " + partition);
    }
}
