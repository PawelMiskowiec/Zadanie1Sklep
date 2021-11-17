package pl.edu.wszib.database;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    private final static DB instance = new DB();

    private DB(){
        products.add(new Product("Patyczki do uszu", 2.50, 4, 1));
        products.add(new Product("Filtr HEPA do odkurzacza", 30, 2, 2));
        products.add(new Product("Monster Ultra Fiesta Mango", 5.50, 10, 3));
        products.add(new Product("Silikon wysokotemperaturowy", 25.0, 3, 4));
        products.add(new Product("Zużyty zawias", 0.50, 7, 5));

        users.add(new User("janusz", DigestUtils.md5Hex("janusz")));
        users.add(new User("admin", DigestUtils.md5Hex("admin")));
        users.add(new User("roman", DigestUtils.md5Hex("roman")));
    }
    public boolean signIn(){
        try {
            for(int i=0; i<3; i++){
                System.out.print("podaj login:");
                String login = br.readLine();
                System.out.print("podaj haslo:");
                String password = br.readLine();
                for (User user : this.users) {
                    if (user.getLogin().equals(login) && user.getPassword().equals(DigestUtils.md5Hex(password))) {
                        user.setLoginStatus(true);
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<User> getUsers() {
        return users;
    }

    public static DB getInstance() {
        return instance;
    }
}
