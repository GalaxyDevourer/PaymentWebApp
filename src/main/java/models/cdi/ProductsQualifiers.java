package models.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface FreshProduct {}

@FreshProduct
class FreshProductClass extends Product {

    FreshProductClass() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    @Override
    public void startSpoiling() {
        System.out.println("Product start spoiling");
    }

    @Override
    public void showStatus() {
        System.out.println("Fresh Product: " + title + " Price: " + price + " isFresh: " + isFresh);
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface SpoiledProduct {}

@SpoiledProduct
class SpoiledProductClass extends Product {

    SpoiledProductClass() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    @Override
    public void startSpoiling() {
        System.out.println("The product is already spoiled");
    }

    @Override
    public void showStatus() {
        System.out.println("Spoiled Product: " + title + " Price: " + price + " isFresh: " + isFresh);
    }
}