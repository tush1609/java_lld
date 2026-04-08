package org.example.AllocationStrategy;

import org.example.model.Developer;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AssignToFirstRequest implements IAllocationStrategy {
    @Override
    public Developer assignDeveloper(ConcurrentLinkedDeque<Developer> requestedDevelopers) {
        return requestedDevelopers.poll();
    }
}
