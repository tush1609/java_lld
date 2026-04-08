package org.example.AllocationStrategy;

import org.example.model.Developer;

import java.util.concurrent.ConcurrentLinkedDeque;

public interface IAllocationStrategy {
    Developer assignDeveloper(ConcurrentLinkedDeque<Developer> requestedDevelopers);
}
