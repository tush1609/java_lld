package org.example;

import org.example.enums.ProjectTypes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ProjOrchestrator projOrcha = new ProjOrchestrator();

        projOrcha.createLeader("L1", "Leader_1", "100");
        projOrcha.createLeader("L2", "Leader_1", "100");
        projOrcha.createLeader("L3", "Leader_1", "100");

        projOrcha.createDeveloper("D1", "DEVELOPER_1", "100");
        projOrcha.createDeveloper("D2", "DEVELOPER_1", "100");

        projOrcha.createProject("P1", "my_proj", ProjectTypes.BACKEND, "L1");
        projOrcha.requestDeveloper("P1", "D1");
        projOrcha.approveProject("P1", "L1");
        projOrcha.startProject("P1");
        projOrcha.deliverProject("P1");
//        projOrcha.cancelProject("P1");
//        projOrcha.requestDeveloper("P1", "D1");
//        projOrcha.requestDeveloper("P1", "D1");
//        projOrcha.getAvailableProjects();
        projOrcha.printAllProjects();
    }
}
