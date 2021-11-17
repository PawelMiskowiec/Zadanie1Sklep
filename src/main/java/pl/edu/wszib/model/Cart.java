package pl.edu.wszib.model;

import pl.edu.wszib.database.DB;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(int productID, int quantity){
        for(Product product: DB.getInstance().getProducts()){
            if(product.getId() == productID){
                for(Product productInCart: products){
                    if(productInCart.getId() == productID){
                        if(product.getQuantity() >= quantity + productInCart.getQuantity() && quantity > 0){
                            productInCart.setQuantity(productInCart.getQuantity() + quantity);
                            return;
                        } else{
                            System.out.println("Podano nieprawidłową ilość");
                            return;
                        }
                    }
                }
                if(product.getQuantity() >= quantity && quantity > 0){
                    this.products.add(new Product(product.getName(), product.getPrice(), quantity, product.getId()));
                } else{
                    System.out.println("Podano nieprawidłową ilość");
                }
                return;
            }
        }
    }

    public void emptyCart(){
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
