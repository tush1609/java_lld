package org.example.setup;

import org.example.model.Board;
import org.example.model.entity.Ladder;
import org.example.model.entity.Snake;

public class EasySetup implements ISetup {
    @Override
    public void snakeSetup(Board board) {
        for (int i = 0; i <= 5; i++) {
            int start = (int) (Math.random() * board.getSize()) + 5;
            if (start >= 100) start = 99;

            int end = (int) (Math.random() * start) - 5;
            if (end <= 0) end = 1;

            board.addEntity(new Snake(start, end));
        }
    }

    @Override
    public void ladderSetup(Board board) {
        for (int i = 0; i <= 10; i++) {
            int end = (int) (Math.random() * board.getSize()) + 5;
            if (end >= 100) end = 99;

            int start = (int) (Math.random() * end) - 5;
            if (start <= 0) start = 1;

            board.addEntity(new Ladder(start, end));
        }
    }
}
