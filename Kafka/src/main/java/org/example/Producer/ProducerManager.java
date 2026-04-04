package org.example.Producer;

import org.example.Message;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducerManager {
    Map<String, Topic> topics;

    public ProducerManager() {
        this.topics = new HashMap<>();
    }

    public void createTopic(String topic, int noOfPart) {
        this.topics.put(topic, new Topic(topic, noOfPart));
    }

    public boolean checkTopic(String topic) {
        return this.topics.containsKey(topic);
    }

    public void addMessageToTopic(String topic, Message message) {
        Topic currTopic = this.topics.get(topic);
        currTopic.addMessage(message);
    }

    public Map<String, List<Partition>> assignConsumers(String topic, List<String> consumerIds) {
        Topic top = this.topics.get(topic);
        return top.assignConsumers(consumerIds);
    }

    public void printAll() {
        this.topics.values().forEach(Topic::printAll);
    }
}
