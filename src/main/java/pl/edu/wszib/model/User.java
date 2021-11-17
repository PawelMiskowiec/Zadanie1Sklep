package pl.edu.wszib.model;

public class User {
    private String login;
    private String password;
    private Cart cart;
    private boolean loginStatus;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.cart = new Cart();
        this.loginStatus=false;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
