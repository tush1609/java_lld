package org.example.GroupAssignStrategy;

import org.example.Producer.Partition;

import java.util.List;
import java.util.Map;

public interface IConsumerAssignStrategy {
    Map<String, List<Partition>> execute(List<Partition> partitions, List<String> consumerIds);
}
