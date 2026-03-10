package com.example.test;

import com.example.classes.Machine;
import com.example.classes.Salle;
import com.example.service.MachineService;
import com.example.service.SalleService;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        Salle salle1 = new Salle("X100");
        Salle salle2 = new Salle("Y200");
        Salle salle3 = new Salle("Z300");
        Salle salle4 = new Salle("W400");
        Salle salle5 = new Salle("V500");

        salleService.create(salle1);
        salleService.create(salle2);
        salleService.create(salle3);
        salleService.create(salle4);
        salleService.create(salle5);

        Machine machine1 = new Machine("ABC-001", new Date(124, 0, 5), salle1);
        Machine machine2 = new Machine("ABC-002", new Date(124, 0, 12), salle1);
        Machine machine3 = new Machine("ABC-003", new Date(124, 1, 3), salle1);
        Machine machine4 = new Machine("DEF-001", new Date(123, 11, 10), salle2);
        Machine machine5 = new Machine("DEF-002", new Date(124, 2, 15), salle2);
        Machine machine6 = new Machine("GHI-001", new Date(123, 10, 20), salle3);
        Machine machine7 = new Machine("GHI-002", new Date(124, 3, 8), salle3);
        Machine machine8 = new Machine("JKL-001", new Date(122, 8, 14), salle4);
        Machine machine9 = new Machine("JKL-002", new Date(123, 5, 25), salle4);
        Machine machine10 = new Machine("MNO-001", new Date(124, 4, 30), salle5);
        Machine machine11 = new Machine("MNO-002", new Date(124, 4, 30), salle5);
        Machine machine12 = new Machine("PQR-001", new Date(123, 7, 18), salle3);

        machineService.create(machine1);
        machineService.create(machine2);
        machineService.create(machine3);
        machineService.create(machine4);
        machineService.create(machine5);
        machineService.create(machine6);
        machineService.create(machine7);
        machineService.create(machine8);
        machineService.create(machine9);
        machineService.create(machine10);
        machineService.create(machine11);
        machineService.create(machine12);

        for(Salle salle : salleService.findAll()) {
            System.out.println("Salle: " + salle.getCode());
            for(Machine machine : salle.getMachines()) {
                System.out.println("  Machine: " + machine.getRef());
            }
        }

        Date d1 = new Date(124, 0, 1);
        Date d2 = new Date(124, 3, 30);
        System.out.println("Machines achetées entre janvier et avril 2024:");
        for(Machine m : machineService.findBetweenDate(d1, d2)) {
            System.out.println(m.getRef() + " achetée le " + m.getDateAchat());
        }
    }
}