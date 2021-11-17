package pl.edu.wszib.view;

import pl.edu.wszib.model.Product;

public class CartView {
    public static void printCart(Product product){
        System.out.println(product.getId() + ". " + product.getName()
                + " ilosc " + product.getQuantity() + " cena(szt) " + product.getPrice());
    }
}
