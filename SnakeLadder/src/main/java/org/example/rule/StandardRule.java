package org.example.rule;

import org.example.model.entity.Entity;

import java.util.List;
import java.util.Map;

public class StandardRule implements IRule {
    @Override
    public boolean isValidMove(int currPosition, int diceValue, int boardSize) {
        return currPosition + diceValue <= boardSize;
    }

    @Override
    public boolean isGaveOver(int currPosition, int boardSize) {
        return currPosition == boardSize;
    }

    @Override
    public int getPlayerNextPosition(int diceMaxVal, int diceValue, int boardSize, Map<Integer, Entity> entities, int currPosition, List<Integer> moveHistory) {
        if (this.canPlayerMove(diceMaxVal, diceValue, moveHistory)) {
            int newPosition = currPosition + diceValue;
            while (entities.containsKey(newPosition)) {
                Entity entity = entities.get(newPosition);
                newPosition = entity.getEnd();
            }

            System.out.println("Player moved from " + currPosition + " to " + newPosition);
            return newPosition;
        }

        return currPosition - 2 * diceMaxVal;
    }

    boolean canPlayerMove(int diceMaxVal, int diceValue, List<Integer> moveHistory) {
        int size = moveHistory.size();
        if (size >= 2 && moveHistory.get(size - 1) == diceMaxVal
                && moveHistory.get(size - 2) == diceMaxVal
                && diceValue == diceMaxVal
        ) {
            System.out.println("3 SIX, CAN'T MOVE");

            return false;
        }

        return true;
    }

    @Override
    public boolean canPlayerRepeatMove(int diceMaxVal, int diceValue, List<Integer> moveHistory) {
        if (diceValue == diceMaxVal) {
            return this.canPlayerMove(diceMaxVal, diceValue, moveHistory);
        }

        return false;
    }
}
