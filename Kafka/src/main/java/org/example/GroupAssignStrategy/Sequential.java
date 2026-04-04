package org.example.GroupAssignStrategy;

import org.example.Producer.Partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sequential implements IConsumerAssignStrategy {
    public Map<String, List<Partition>> execute(List<Partition> partitions, List<String> consumerIds) {
        if (consumerIds.isEmpty()) return new HashMap<>();
        if (partitions.isEmpty()) return new HashMap<>();

        Map<String, List<Partition>> mp = new HashMap<>();
        int cIndex = 0;
        for (Partition part: partitions) {
            String currConsumerId = consumerIds.get(cIndex);

            if (!mp.containsKey(currConsumerId)) {
                mp.put(currConsumerId, new ArrayList<>());
            }

            List<Partition> p = mp.get(currConsumerId);
            p.add(part);
            mp.put(currConsumerId, p);
            cIndex = (cIndex + 1) % consumerIds.size();
        }

        return mp;
    }
}
