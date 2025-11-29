/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author phuga
 */
public class Order {

    private String fruitName;
    private int fruitQuantity;
    private double fruitPrice;

    public Order() {
    }

    public Order(String fruitName, int fruitQuantity, double fruitPrice) {
        this.fruitName = fruitName;
        this.fruitQuantity = fruitQuantity;
        this.fruitPrice = fruitPrice;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
    
    public double getAmount(){
        return fruitQuantity * fruitPrice;
    }
}
