package pl.edu.wszib.model;

import pl.edu.wszib.database.DB;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(int addedProductID, int requestedQuantity){
        for(Product productFromDB: DB.getInstance().getProducts()){
            if(addedProductID == productFromDB.getId()){
                for(Product productInCart: products){
                    if(productInCart.getId() == addedProductID){
                        if(productFromDB.getQuantity() >= requestedQuantity + productInCart.getQuantity() && requestedQuantity > 0){
                            productInCart.setQuantity(productInCart.getQuantity() + requestedQuantity);
                            return;
                        } else{
                            System.out.println("\nPodano nieprawidłową ilość\n");
                            return;
                        }
                    }
                }
                if(productFromDB.getQuantity() >= requestedQuantity && requestedQuantity > 0)
                    this.products.add(new Product(productFromDB.getName(), productFromDB.getPrice(),
                            requestedQuantity, productFromDB.getId()));
                else
                    System.out.println("\nPodano nieprawidłową ilość\n");
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
