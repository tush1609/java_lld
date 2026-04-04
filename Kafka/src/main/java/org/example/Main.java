package org.example;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();

        manager.createTopic("TOPIC_1", 4);
        manager.createTopic("TOPIC_2", 2);

        manager.createConsumer("CONSUMER_GROUP_1", "CONSUMER_1");
        manager.createConsumer("CONSUMER_GROUP_1", "CONSUMER_2");
        manager.createConsumer("CONSUMER_GROUP_2", "CONSUMER_3");
        manager.createConsumer("CONSUMER_GROUP_2", "CONSUMER_4");
        manager.createConsumer("CONSUMER_GROUP_3", "CONSUMER_5");

        manager.addMessageToTopic("TOPIC_1", new Message("MSG_1", "user_1", "DATA_1"));
        manager.addMessageToTopic("TOPIC_1", new Message("MSG2", "user_2", "DATA_2"));
        manager.addMessageToTopic("TOPIC_1", new Message("MSG_3", "user_3", "DATA_2"));
        manager.addMessageToTopic("TOPIC_2", new Message("MSG_41", "user_4", "DATA_4"));
        manager.addMessageToTopic("TOPIC_2", new Message("MSG_5", "user_5", "DATA_5"));

        manager.subscribeTopic("CONSUMER_GROUP_1", "TOPIC_1");
        manager.subscribeTopic("CONSUMER_GROUP_1", "TOPIC_2");

        manager.printAll();
    }
}
