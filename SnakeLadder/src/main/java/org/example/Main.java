package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
     static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Manager manager = new Manager();
        manager.registerPlayer("1", "p1");
        manager.registerPlayer("2", "p2");
        manager.registerPlayer("3", "p3");
        manager.registerPlayer("4", "p4");
        manager.registerPlayer("5", "p5");

        manager.move();
        manager.printALL();

        manager.move();
        manager.printALL();

        manager.setBiasedDice(5);
        manager.move();
        manager.printALL();
        manager.move();
        manager.printALL();
        manager.move();
        manager.printALL();

    }
}
