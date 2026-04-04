package org.example.Consumer;

import org.example.Producer.Partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerManager {
    Map<String, ConsumerGroup> consumerGroup;

    public ConsumerManager() {
        this.consumerGroup = new HashMap<>();
    }

    public void createConsumerGroup(String consumerGroupId) {
        if (this.consumerGroup.containsKey(consumerGroupId)) {
            return;
        }

        ConsumerGroup consumerGroup = new ConsumerGroup(consumerGroupId);
        this.consumerGroup.put(consumerGroup.id, consumerGroup);
    }

    public void addConsumerToGroup(String consumerGroupId, String consumerId) {
        ConsumerGroup consumerGroup = this.consumerGroup.get(consumerGroupId);
        if (consumerGroup == null) {
            consumerGroup = new ConsumerGroup(consumerGroupId);
        }
        consumerGroup.addConsumer(consumerId);
        this.consumerGroup.put(consumerGroupId, consumerGroup);
    }

    public List<String> getConsumerIds(String consumerGroupId) {
        ConsumerGroup consumerGroup = this.consumerGroup.get(consumerGroupId);
        if (consumerGroup != null) {
            return consumerGroup.getConsumerIds();
        }

        return new ArrayList<>();
    }

    public List<String> getSubscribedTopics(String consumerGroupId) {
        ConsumerGroup consumerGroup = this.consumerGroup.get(consumerGroupId);
        if (consumerGroup != null) {
            return consumerGroup.getSubscribedTopics();
        }

        return new ArrayList<>();
    }

    public void adjust(String consumerGroupId, Map<String, List<Partition>> consumerIdPartMap) {
        ConsumerGroup consumerGroup = this.consumerGroup.get(consumerGroupId);
        if (consumerGroup != null) {
            consumerGroup.adjust(consumerIdPartMap);
        }
    }

    public void printAll() {
        this.consumerGroup.values().forEach(ConsumerGroup::printAll);
    }
}
