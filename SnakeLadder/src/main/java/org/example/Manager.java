package org.example;

import org.example.model.Player;
import org.example.model.dice.BiasedDice;
import org.example.model.dice.IDice;
import org.example.model.dice.StandardDice;
import org.example.rule.StandardRule;
import org.example.service.Game;
import org.example.setup.EasySetup;

public class Manager {
    Game game;

    Manager() {
        this.game = new Game(
                100,
                new StandardRule(),
                new StandardDice(6),
                new EasySetup()
        );
        this.game.setupBoard();
    }

    void registerPlayer(String id, String name) {
        this.game.addPlayer(new Player(id, name, 0));
    }

    void move() {
        this.game.move();
    }

    void setBiasedDice(int num) {
        this.game.setDice(new BiasedDice(num));
    }

    void setStandardDice() {
        this.game.setDice(new StandardDice(6));
    }

    void printALL() {
        this.game.printALL();
    }
}
