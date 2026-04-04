package org.example;

public class Message {
    String key;
    String name;
    String content;

    public Message(String key, String name, String content) {
        this.key = key;
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return this.name;
    }

    public String getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return this.key + " " + this.name + " " + this.content;
    }
}
