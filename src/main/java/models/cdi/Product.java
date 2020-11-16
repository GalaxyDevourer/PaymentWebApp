package models.cdi;

public abstract class Product {
    public String title;
    int price;
    boolean isFresh;

    public abstract void startSpoiling();
    public abstract void showStatus();
}
