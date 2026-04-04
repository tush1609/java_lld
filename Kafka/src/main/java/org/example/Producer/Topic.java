package org.example.Producer;

import org.example.GroupAssignStrategy.IConsumerAssignStrategy;
import org.example.GroupAssignStrategy.Sequential;
import org.example.Message;
import org.example.PartitionStrategy.IPartitionStrategy;
import org.example.PartitionStrategy.KeyLength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {
    String id;
    List<Partition> partitions;
    IConsumerAssignStrategy consumerAssignStrategy;
    IPartitionStrategy partitionStrategy;

    Topic(String id, int countOfPartitions) {
        this.id = id;
        this.partitions = new ArrayList<>();

        for (int i = 0; i < countOfPartitions; i++) {
            Partition part = new Partition(id + "_" + i);
            this.partitions.add(part);
        }

        this.consumerAssignStrategy = new Sequential();
        this.partitionStrategy = new KeyLength();
    }

    Map<String, List<Partition>> assignConsumers(List<String> consumerIds) {
        return this.consumerAssignStrategy.execute(this.partitions, consumerIds);
    }

    void addMessage(Message message) {
        String key = message.getKey();
        int partitionIndex = this.partitionStrategy.getPartitionKey(key);
        partitionIndex %= this.partitions.size();
        Partition part = this.partitions.get(partitionIndex);
        part.addData(message);
    }

    void printAll() {
        System.out.println("TOPIC: " + this.id + "->");
        this.partitions.forEach(Partition::printAll);
        System.out.println("\n");
    }
}
