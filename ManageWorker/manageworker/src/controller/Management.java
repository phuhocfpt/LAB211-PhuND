/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import object.SalaryHistoryWorker;
import object.SalaryStatus;
import object.SortWorkerById;
import object.Worker;

/**
 *
 * @author shopp
 */
public class Management {

    private ArrayList<Worker> workerList;
    private ArrayList<SalaryHistoryWorker> historyList;

    public Management() {
        workerList = new ArrayList<>();
        historyList = new ArrayList<>();
    }

    private Worker findWorkerById(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    //function 1: Add worker
    public boolean addWorker(Worker worker) throws Exception {
        //check null list?
        if (workerList == null) {
            throw new Exception("List is null!");
        }
        //check isExisted worker's id?
        if (findWorkerById(worker.getId()) != null) {
            throw new Exception("Worker ID is existed!");
        }
        //check age range 18-50
        if (worker.getAge() < 18 || worker.getAge() > 50) {
            throw new Exception("Age must in range 18-50");
        }
        //check salary > 0
        if (worker.getSalary() <= 0.0) {
            throw new Exception("Salary must be > 0");
        }

        workerList.add(worker);
        return true;
    }

    //function 2 + 3: Increase salary
    public boolean changeSalary(SalaryStatus status, String id, double amount) throws Exception {
        Worker changeWorker = findWorkerById(id);

        //check list null?
        if (workerList == null) {
            throw new Exception("List is null!");
        }
        //check existed id
        if (changeWorker == null) {
            throw new Exception("Worker ID is not existed!");
        }
        //check amount
        if (amount <= 0) {
            throw new Exception("Amount of money must be > 0!");
        }

        double currentSalary = changeWorker.getSalary();
        double newSalary = 0;

        if (status == SalaryStatus.UP) {
            newSalary = currentSalary + amount;
        } else {
            if (amount >= currentSalary) {
                throw new Exception("Amount decrease must < current salary: " + currentSalary);
            }
            newSalary = currentSalary - amount;
        }

        changeWorker.setSalary(newSalary);

        SalaryHistoryWorker newHistory = new SalaryHistoryWorker(changeWorker, status);
        historyList.add(newHistory);
        return true;

    }

    //function 4: Show list history
    public List<SalaryHistoryWorker> getHistoryList() {
        if (historyList.isEmpty() || historyList == null) {
            System.err.println("Empty or Null history list!");
        }

        SortWorkerById sortRule = new SortWorkerById();
        Collections.sort(historyList, sortRule);

        return historyList;
    }

}
