package models.cdi;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@RequestScoped
public class Customer {

    @Inject
    Notes notes;

    private List<Product> productList;

    public Customer() {
        productList = new LinkedList<>();
    }

    void shopping(){
        System.out.println("Customer go shopping");
        notes.setProductList(productList);
    }

}

@Decorator
class NotesDecorator implements Notes{
    @Inject
    @Delegate
    FoodNotes foodNotes;
    List<Product> productList;

    @Override
    public void setProductList(List<Product> productList) {
        this.productList = productList;
        foodNotes.setProductList(productList);

        foodNotes.showProducts(productList);
    }
}
