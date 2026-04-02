package org.example.service;

import org.example.model.Board;
import org.example.model.Player;
import org.example.model.dice.IDice;
import org.example.rule.IRule;
import org.example.setup.ISetup;

import java.util.ArrayDeque;
import java.util.Queue;

public class Game {
    Board board;
    IRule rule;
    IDice dice;
    ISetup setup;
    Queue<Player> playerQ;
    boolean isGameActive;

    public Game(int size, IRule rule, IDice dice, ISetup setup) {
        this.board = new Board(size);
        this.rule = rule;
        this.dice = dice;
        this.playerQ = new ArrayDeque<>();
        this.setup = setup;
        this.isGameActive = true;
    }

    public void setupBoard() {
        this.setup.snakeSetup(this.board);
        this.setup.ladderSetup(this.board);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public IRule getRule() {
        return rule;
    }

    public void setRule(IRule rule) {
        this.rule = rule;
    }

    public IDice getDice() {
        return dice;
    }

    public void setDice(IDice dice) {
        this.dice = dice;
    }

    public Queue<Player> getPlayerQ() {
        return playerQ;
    }

    public void addPlayer(Player player) {
        this.playerQ.add(player);
    }

    public boolean isGameActive() {
        return isGameActive;
    }

    public void setGameActive(boolean gameActive) {
        isGameActive = gameActive;
    }

    public void move() {
        if (this.isGameActive) {
            Player playerToMove = this.playerQ.element();
            if (playerToMove == null) return;

            System.out.println("Player to move " + playerToMove);
            int diceVal = this.dice.roll();

            if (this.rule.isValidMove(playerToMove.getPosition(), diceVal, this.board.getSize())) {
                int nextPos = this.rule.getPlayerNextPosition(
                        this.getDice().getMaxNum(),
                        diceVal,
                        this.board.getSize(),
                        this.board.getEntity(),
                        playerToMove.getPosition(),
                        playerToMove.getMoveHistory()
                );

                playerToMove.setPosition(nextPos);

                if (!this.rule.canPlayerRepeatMove(this.getDice().getMaxNum(), diceVal, playerToMove.getMoveHistory())) {
                    this.playerQ.poll();
                    this.playerQ.add(playerToMove);
                }

                if (this.rule.isGaveOver(playerToMove.getPosition(), this.board.getSize())) {
                    System.out.println("Player " + playerToMove.getName() + " WON");
                    this.isGameActive = false;
                }

            }

            return;
        }

        System.out.println("GAME ALREADY OVER");
    }

    public void printALL() {
        System.out.println("GAME: ");
        this.board.print();

        System.out.println("PLAYER: ");
        for (Player player : this.playerQ) {
            System.out.println(player);
        }

        System.out.println("\n");
    }
}
