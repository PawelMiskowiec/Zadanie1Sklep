package pl.edu.wszib;

import pl.edu.wszib.controller.UserController;
import pl.edu.wszib.database.DB;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.model.User;
import pl.edu.wszib.view.ProductView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Product> products = DB.getInstance().getProducts();
        List<User> users = DB.getInstance().getUsers();
        ProductView productView =
                new ProductView();
        UserController userController =
                new UserController(users, products, productView);
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        userController.LogIn();
        Boolean isAnyoneLoggedIn= userController.isAnyoneLoggedIn();

        while(isAnyoneLoggedIn){
            System.out.println("\nWybierz dzialanie");
            System.out.println("1.Wyswietl produkty");
            System.out.println("2.Dodaj do koszyka");
            System.out.println("3.Wyswietl zawartosc koszyka");
            System.out.println("4.Złóż zamowienie");
            System.out.println("5.Wyloguj sie\n");
            try {
                switch(br.readLine()){
                    case("1"):
                        userController.getProductView();
                        break;
                    case("2"):
                        System.out.print("Podaj id produktu: ");
                        int productID = Integer.parseInt(br.readLine());
                        System.out.print("Podaj ilosc: ");
                        int quantity = Integer.parseInt(br.readLine());
                        userController.addProductToCart(productID, quantity);
                        break;
                    case("3"):
                        userController.getCartView();
                        break;
                    case("4"):
                        userController.processOrder();
                        break;
                    case("5"):
                        userController.logOut();
                        userController.LogIn();
                        isAnyoneLoggedIn= userController.isAnyoneLoggedIn();
                        break;
                    default:
                        System.out.println("\nWybierz numer z listy\n");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
