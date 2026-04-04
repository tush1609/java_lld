package org.example.PartitionStrategy;

public class KeyLength implements IPartitionStrategy {
    public int getPartitionKey(String key) {
        return key.length();
    }
}
