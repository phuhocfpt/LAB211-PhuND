/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import common.Input;
import controller.Management;
import java.util.List;
import object.SalaryHistoryWorker;
import object.SalaryStatus;
import object.Worker;

/**
 *
 * @author shopp
 */
public class Menu {

    private static Management management = new Management();

    public void run() {
        while (true) {
            displayMenu();
            int choice = Input.getInt("Enter your choice:", 1, 5);
            switch (choice) {
                case 1:
                    //add
                    displayAddWorker();
                    break;
                case 2:
                    //up salary
                    changeSalary(SalaryStatus.UP);
                    break;
                case 3:
                    //down salary
                    changeSalary(SalaryStatus.DOWN);
                    break;
                case 4:
                //show history list
                    displayStatusHistory();
                    break;
                case 5:
                    System.out.println("=== EXITTING PROGRAM ===");
                    return;
            }
        }
    }

    public void displayMenu() {
        System.out.println("======= Worker Management =======");
        System.out.println("1. Add worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
    }

    public void displayAddWorker() {
        System.out.println("------- Add Worker -------");
        String id = Input.getString("Enter worker ID:");
        String name = Input.getString("Enter worker NAME:");
        int age = Input.getInt("Enter worker AGE:", 18, 50);
        double salary = Input.getDouble("Enter worker SALARY:", 0.1, Double.MAX_VALUE);
        String workLocate = Input.getString("Enter worker WORK LOCATION:");

        Worker newWorker = new Worker(id, name, age, salary, workLocate);
        try {
            if (management.addWorker(newWorker)) {
                System.out.println("Added successfully!");
            }
        } catch (Exception e) {
            System.err.println("Error adding worker: " + e.getMessage());
        }
    }

    public void changeSalary(SalaryStatus status) {
        if (status == SalaryStatus.UP) {
            System.out.println("------- Up Salary -------");
        } else {
            System.out.println("------- Down Salary -------");
        }

        String code = Input.getString("Enter worker ID to change:");
        double amount = Input.getDouble("Enter amount to " + status + " salary:", 0.1, Double.MAX_VALUE);

        try {
            if (management.changeSalary(status, code, amount)) {
                if (status == SalaryStatus.UP) {
                    System.out.println("UP salary done!");
                } else {
                    System.out.println("DOWN salary done!");
                }
            }
        } catch (Exception e) {
            System.err.println("Error when change salary: " + e.getMessage());
        }
    }

    public void displayStatusHistory() {
        System.out.println("----- Display Information Salary -----");

        List<SalaryHistoryWorker> historyList = management.getHistoryList();

        if (historyList.isEmpty()) {
            System.out.printf("===== No Status Change Founded =====\n");
        } else {
            System.out.printf("%-10s%-15s%-5s%-10s%-10s%-15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
            for(SalaryHistoryWorker his : historyList){
                System.out.printf("%-10s%-15s%-5d%-10.1f%-10s%-15s\n"
                        , his.getWorkerId().toUpperCase(), his.getWorkerName(), his.getWorkerAge()
                        , his.getWorkerSalary(), his.getStatus(),
                        his.getDate()
                        );
            }
        }
        }
    }
