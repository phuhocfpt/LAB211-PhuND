/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.Comparator;

/**
 *
 * @author shopp
 */
public class SortWorkerById implements Comparator<SalaryHistoryWorker>{
    @Override
    public int compare(SalaryHistoryWorker o1, SalaryHistoryWorker o2) {
        return o1.getWorkerId().compareToIgnoreCase(o2.getWorkerId());
    }
    
}
