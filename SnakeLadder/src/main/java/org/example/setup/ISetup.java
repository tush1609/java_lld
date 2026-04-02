package org.example.setup;

import org.example.model.Board;
import org.example.model.entity.Entity;

import java.util.List;

public interface ISetup {
    void snakeSetup(Board board);
    void ladderSetup(Board board);
}
