package pl.edu.wszib.view;

import pl.edu.wszib.model.Product;

import java.util.List;

public class CartView {
    public static void printCart(List<Product> productsInCart){
        System.out.println("Zawartosc koszyka:");
        for(Product product: productsInCart){
            System.out.println(product.getId() + ". " + product.getName()
                    + " ilosc " + product.getQuantity() + " cena(szt) " + product.getPrice());
        }
    }
}
