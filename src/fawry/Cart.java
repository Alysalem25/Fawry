package fawry;

import fawry.Product;
import fawry.Expirable;
import java.util.Stack;

public class Cart {

    private int price = 0;
    private int shippingPrice = 0;
    Stack<cartItem> custmerCart = new Stack<>();

    public void add(Product p, int num_of) {
        // Check if product is expired
        if (p instanceof Expirable) {
            if (((Expirable) p).isExpired()) {
                System.out.println("Cannot add '" + p.getName() + "' to cart: Product is expired.");
                return;
            }
        }

        if (p instanceof Shippable) {
            double weight = ((Shippable) p).getWeight();
            shippingPrice += weight * 1.0;
        }
        // Check stock availability
        if (p.getQuantity() >= num_of) {
            p.setQuantity(p.getQuantity() - num_of);
            custmerCart.add(new cartItem(p, num_of));
        } else {
            if (p.getQuantity() > 0) {
                System.out.println(p.getQuantity() + " only available of this product");
            } else {
                System.out.println("This product is out of stock");
            }
        }
    }


    public void remove(Product p, int num_of) {
        if (custmerCart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        boolean found = false;
        Stack<cartItem> tempStack = new Stack<>();

        while (!custmerCart.isEmpty()) {
            cartItem c1 = custmerCart.pop();
            if (c1.getProduct().getName().equals(p.getName())) {
                if (c1.getQuantity() >= num_of) {
                    c1.setQuantity(c1.getQuantity() - num_of);
                    if (c1.getQuantity() > 0) {
                        tempStack.push(c1);
                    }
                    found = true;
                } else if (c1.getQuantity() > 0) {
                    System.out.println("Removing only " + c1.getQuantity() + " of " + c1.getProduct().getName() + " from cart.");
                    c1.setQuantity(0); // Remove all of this product
                    tempStack.push(c1);
                }
            } else {
                tempStack.push(c1);
            }
        }

        while (!tempStack.isEmpty()) {
            custmerCart.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Product not found in cart.");
        }
    }

    public void checkout(Customer customer) {
        if (custmerCart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("** Checkout Receipt **");
        while (!custmerCart.isEmpty()) {
            cartItem c1 = custmerCart.pop();
            System.out.println(c1.getQuantity() + " x " + c1.getProduct().getName() + " = $" + c1.getPrice());
            price += c1.getPrice();
        }

        System.out.println("---------------------------------");
        System.out.println("** End of Receipt **");
        if (customer.getBalance() >= price + shippingPrice) {
            customer.setBalance(customer.getBalance() - (price + shippingPrice));
            System.out.println("Subtotal: $" + price);
            System.out.println("Shipping: $" + shippingPrice);
            System.out.println("Total Amount: $" + (price + shippingPrice));
            System.out.println("your balance: $" + customer.getBalance());
        } else {
            System.out.println("low balance");
        }

        // Reset total after checkout
    }
}

class cartItem {

    private Product p;
    private int quantity;

    public cartItem(Product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return p;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product p) {
        this.p = p;
    }

    public double getPrice() {
        return p.getPrice() * quantity;
    }
}