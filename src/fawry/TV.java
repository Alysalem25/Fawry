/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawry;

/**
 *
 * @author Aly
 */
public class TV extends Product implements Shippable {

    private double weight;

    public TV(String name, double price, int quantity, double weight ) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

   
    
}
