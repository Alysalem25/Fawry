/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawry;

/**
 *
 * @author Aly
 */
public class Biscuits extends Product implements Expirable{
    private boolean expired;

    public Biscuits(String name, double price, int quantity, boolean expired) {
        super(name, price, quantity);
        this.expired = expired;
    }

    @Override
    public boolean isExpired() {
        return expired;
    } 
    
    
}
