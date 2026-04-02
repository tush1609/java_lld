package org.example.rule;

import org.example.model.entity.Entity;

import java.util.List;
import java.util.Map;

public interface IRule {
    boolean isValidMove(int currPosition, int diceValue, int boardSize);
    boolean isGaveOver(int currPosition, int boardSize);
    int getPlayerNextPosition(int diceMaxVal, int diceValue, int boardSize, Map<Integer, Entity> entities, int currPosition, List<Integer> moveHistory);
    boolean canPlayerRepeatMove(int diceMaxVal, int diceValue, List<Integer> moveHistory);
}
