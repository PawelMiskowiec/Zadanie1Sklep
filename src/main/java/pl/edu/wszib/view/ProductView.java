package pl.edu.wszib.view;

import pl.edu.wszib.model.Product;

import java.util.List;

public class ProductView {
    public void printProducts(List<Product> productsList){
        System.out.println("Lista dostepnych produktów:");
        for(Product product: productsList){
            System.out.print(product.getId() + ". ");
            System.out.print(product.getName());
            System.out.print(" cena:" + product.getPrice());
            System.out.println(" dostepne:" + product.getQuantity() +" sztuk");
        }

    }
}
