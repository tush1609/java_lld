package org.example.Consumer;

import org.example.Producer.Partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerGroup {
    String id;
    HashMap<String, Consumer> consumers;
    List<String> subscribedTopics;

    public ConsumerGroup(String id) {
        this.id = id;
        this.consumers = new HashMap<>();
        this.subscribedTopics = new ArrayList<>();
    }

    public void addConsumer(String id) {
        if (!this.consumers.containsKey(id)) {
            Consumer consumer = new Consumer(id);
            this.consumers.put(consumer.id, consumer);
        }
    }

    public List<String> getConsumerIds() {
        List<String> consumerIds = new ArrayList<>();
        this.consumers.values().forEach(c -> consumerIds.add(c.getId()));

        return consumerIds;
    }

    public void subscribeTopic(String topics) {
        this.subscribedTopics.add(topics);
    }

    public List<String> getSubscribedTopics() {
        return this.subscribedTopics;
    }

    // map of cid -> partition
    public void adjust(Map<String, List<Partition>> consumerIdPartMap) {
        try {
            for (Map.Entry<String, Consumer> curr: this.consumers.entrySet()) {
                Consumer consumer = curr.getValue();
                consumer.stopConsumption();
            }

            // part id with offset
            Map<String, Integer> offsetMap = new HashMap<>();
            for (Map.Entry<String, Consumer> consumerMap : this.consumers.entrySet()) {
                Consumer consumer = consumerMap.getValue();
                offsetMap.putAll(consumer.getOffSet());
            }

            for (Map.Entry<String, List<Partition>> consumerPart : consumerIdPartMap.entrySet()) {
                Consumer consumer = this.consumers.get(consumerPart.getKey());
                Map<String, Integer> currOffset = new HashMap<>();
                consumerPart.getValue().forEach(p -> {
                    int index = 0;
                    if (offsetMap.containsKey(p.getId())) {
                        index = offsetMap.get(p.getId());
                    }
                    currOffset.put(p.getId(), index);
                });

                consumer.setPartitions(consumerPart.getValue());
                consumer.setOffSet(currOffset);
            }

            consumerIdPartMap.keySet().forEach(c -> this.consumers.get(c).startConsumption());
        } catch (Exception e) {
            System.out.println("ERR: ADJUST_FAIL " + e.getMessage());
        }
    }

    public void printAll() {
        System.out.println("CONSUMER_GROUP " + this.id);
        this.consumers.values().forEach(Consumer::printAll);
    }
}
