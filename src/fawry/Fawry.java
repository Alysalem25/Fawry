/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fawry;

/**
 *
 * @author Aly
 */
public class Fawry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TV tv = new TV("Samsung 55 inch", 799.99, 10 , 1.1);
        MobileScratch mobileScratch = new MobileScratch("Vodafone Scratch Card", 10.00, 5);
        Cheese cheese = new Cheese("Cheddar Cheese", 5.99, 20, false, 1.2);
        Biscuits biscuits = new Biscuits("Oreo Biscuits", 2.99, 30, false);
        Customer customer = new Customer("Aly", 1000.00);

        Cart cart = new Cart();
        cart.add(tv, 1);
        cart.add(mobileScratch, 2);
        cart.add(cheese, 1);
        cart.add(biscuits, 3);
        cart.remove(biscuits, 5);
        cart.checkout(customer);
    }
    
}
