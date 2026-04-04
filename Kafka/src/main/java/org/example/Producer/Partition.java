package org.example.Producer;

import org.example.Message;
import java.util.ArrayList;
import java.util.List;

public class Partition {
    String id;
    List<Message> messages;

    Partition(String id) {
        this.id = id;
        this.messages = new ArrayList<>();
    }

    void addData(Message message) {
        this.messages.add(message);
    }

    public Message getMessage(int offSet) {
        if (offSet < this.messages.size()) {
            return this.messages.get(offSet);
        }

        return null;
    }

    public String getId() {
        return this.id;
    }

    public void printAll() {
        System.out.println("PART: " + this.id + "->");
        this.messages.forEach(System.out::println);
    }
}
