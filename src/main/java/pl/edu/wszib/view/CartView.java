package pl.edu.wszib.view;

import pl.edu.wszib.model.Product;

import java.util.List;

public class CartView {
    public static void printCart(List<Product> productsInCartList){
        System.out.println("Zawartosc koszyka:");
        for(Product product: productsInCartList){
            System.out.println(product.getId() + ". " + product.getName()
                    + " ilosc " + product.getQuantity() + " cena(szt) " + product.getPrice());
        }
    }
}
