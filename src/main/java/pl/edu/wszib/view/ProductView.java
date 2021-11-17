package pl.edu.wszib.view;

public class ProductView {
    public void printProducts(int id, String productName, double productPrice, int productQuantity){
        System.out.print(id + ". ");
        System.out.print(productName);
        System.out.print(" cena:" + productPrice);
        System.out.print(" dostepne:" + productQuantity +" sztuk\n");
    }
}
