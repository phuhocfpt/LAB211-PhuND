/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.time.LocalDate;

/**
 *
 * @author shopp
 */
public class SalaryHistoryWorker {

    private String workerId;
    private String workerName;
    private int workerAge;
    private double workerSalary;
    private SalaryStatus status;
    private LocalDate date;

    public SalaryHistoryWorker() {
    }

    public SalaryHistoryWorker(Worker worker, SalaryStatus status) {
        this.workerId = worker.getId();
        this.workerName = worker.getName();
        this.workerAge = worker.getAge();
        this.workerSalary = worker.getSalary(); 
        
        this.status = status;
        this.date = LocalDate.now();
    }

    public String getWorkerId() {
        return workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public int getWorkerAge() {
        return workerAge;
    }

    public double getWorkerSalary() {
        return workerSalary;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

}
