package pl.edu.wszib.controller;

import pl.edu.wszib.database.DB;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.model.User;
import pl.edu.wszib.view.CartView;
import pl.edu.wszib.view.ProductView;

import java.util.ArrayList;
import java.util.List;


public class UserController {
    private List<User> users;
    private List<Product> products;
    private ProductView productView;

    public UserController(List<User> users, List<Product> products, ProductView productView) {
        this.users = users;
        this.products = products;
        this.productView = productView;
    }

    public boolean authenticate(){
        DB.getInstance().logIn();
        return DB.getInstance().isAnyUserLoggedIn();
    }
    public void logOut(){
        DB.getInstance().logOut();
    }

    public void addProductToCart(int productID, int quantity){
        for(User user: users){
            if(user.isLoginStatus()){
                user.getCart().addProduct(productID, quantity);
            }
        }

    }

    public void getProductView() {
        this.productView.printProducts(this.products);
    }

    public void getCartView(){
        for(User user: users){
            if(user.isLoginStatus())
                CartView.printCart(user.getCart().getProducts());
        }
    }
    public void processOrder(){
        for(User user: users){
            if(user.isLoginStatus()){
                for(Product productInCart: user.getCart().getProducts()){
                    for(Product productInDB: DB.getInstance().getProducts()){
                        if(productInCart.getId() == productInDB.getId()){
                            productInDB.setQuantity(productInDB.getQuantity() - productInCart.getQuantity());
                        }
                    }
                }
                user.getCart().emptyCart();
            }
        }
    }
}
