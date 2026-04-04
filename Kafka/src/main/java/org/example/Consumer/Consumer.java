package org.example.Consumer;

import org.example.Message;
import org.example.Producer.Partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consumer {
    String id;
    List<Partition> partitions;
    Map<String, Integer> offSet;
    boolean isConsumerRunning = false;
    Thread th;

    public Consumer(String id) {
        this.id = id;
        this.partitions = new ArrayList<>();
        this.offSet = new HashMap<>();
    }

    public void stopConsumption() throws Exception {
        if (this.th != null) {
            this.isConsumerRunning = false;
            this.th.join();
        }
    }

    public void startConsumption() {
        this.isConsumerRunning = true;
        this.th = new Thread(this::execute);
        this.th.start();
    }

    public void execute() {
        try {
            while (this.isConsumerRunning) {
                for (Partition part : this.partitions) {
                    int currOffSet = 0;
                    if (this.offSet.containsKey(part.getId())) {
                        currOffSet = this.offSet.get(part.getId());
                    }
                    Message message = part.getMessage(currOffSet);
                    if (message != null) {
                        System.out.println("RECEIVED: " + this.id + "->" + part.getId() + " " + message + " " + currOffSet);
                        this.offSet.put(part.getId(), currOffSet + 1);
                    }
                }
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getOffSet() {
        return offSet;
    }

    public void setOffSet(Map<String, Integer> offSet) {
        this.offSet = offSet;
    }

    public void setPartitions(List<Partition> partitions) {
        this.partitions = partitions;
    }

    public void printAll() {
        System.out.println("CONSUMER " + this.id);
        this.partitions.forEach(Partition::printAll);
    }
}
