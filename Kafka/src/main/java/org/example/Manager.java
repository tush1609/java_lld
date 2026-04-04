package org.example;

import org.example.Consumer.ConsumerManager;
import org.example.Producer.Partition;
import org.example.Producer.ProducerManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    ProducerManager producerManager;
    ConsumerManager consumerManager;

    public Manager() {
        this.producerManager = new ProducerManager();
        this.consumerManager = new ConsumerManager();
    }

    public void createTopic(String topic, int noOfPart) {
        this.producerManager.createTopic(topic, noOfPart);
    }

    public void addMessageToTopic(String topic, Message message) {
        Thread t = new Thread(() -> {
            try {
                if (this.producerManager.checkTopic(topic)) {
                    for (int i = 0; i <= 100; i++) {
                        message.content += i;
                        message.key += i;
                        this.producerManager.addMessageToTopic(topic, message);
                        System.out.println("SENT: " + topic + " " + message.key);
                        Thread.sleep(1000);
                    }

                    return;
                }

                System.out.println("ERR: TOPIC_NOT_CREATED");
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        t.start();
    }

    public void createConsumer(String consumerGroupId, String consumerId) {
        this.consumerManager.createConsumerGroup(consumerGroupId);
        this.consumerManager.addConsumerToGroup(consumerGroupId, consumerId);

        List<String> consumerIds = this.consumerManager.getConsumerIds(consumerGroupId);
        List<String> subscribedTopics = this.consumerManager.getSubscribedTopics(consumerGroupId);

        this.adjust(consumerGroupId, subscribedTopics, consumerIds);
    }

    public void subscribeTopic(String consumerGroupId, String topic) {
        if (this.producerManager.checkTopic(topic)) {
            List<String> consumerIds = this.consumerManager.getConsumerIds(consumerGroupId);
            List<String> subscribedTopics = this.consumerManager.getSubscribedTopics(consumerGroupId);
            subscribedTopics.add(topic);

            this.adjust(consumerGroupId, subscribedTopics, consumerIds);
            return;
        }

        System.out.println("ERR: TOPIC_NOT_CREATED");
    }

    void adjust(String consumerGroupId, List<String> subscribedTopics, List<String> consumerIds) {
        Map<String, List<Partition>> consumerIdPartMap = new HashMap<>();
        for (String topic: subscribedTopics) {
            Map<String, List<Partition>> mp = this.producerManager.assignConsumers(topic, consumerIds);
            for (Map.Entry<String, List<Partition>> entry: mp.entrySet()) {
                if (!consumerIdPartMap.containsKey(entry.getKey())) {
                    consumerIdPartMap.put(entry.getKey(), new ArrayList<>());
                }
                List<Partition> part = consumerIdPartMap.get(entry.getKey());
                part.addAll(entry.getValue());
                consumerIdPartMap.put(entry.getKey(), part);
            }
        }

        this.consumerManager.adjust(consumerGroupId, consumerIdPartMap);
    }

    void printAll() {
//        this.producerManager.printAll();
        this.consumerManager.printAll();
    }
}

