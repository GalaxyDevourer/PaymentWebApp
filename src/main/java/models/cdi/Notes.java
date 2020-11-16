package models.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.List;

interface Notes {
    void setProductList(List<Product> productList);
}

class TitleProducer{
    @Produces
    String title = "Notes about Food";
}

@ApplicationScoped
@CustomInterceptor
class FoodNotes implements Notes {
    @Inject
    String title;

    @Inject
    @FreshProduct
    Product freshProd;

    @Inject
    @SpoiledProduct
    Product spoiledProd;

    public String getTitle() {
        return title;
    }

    public Product getFreshProd() {
        return freshProd;
    }

    public Product getSpoiledProd() {
        return spoiledProd;
    }

    @CustomInterceptor
    void showProducts(List<Product> productList){
        System.out.println("----- " + title + " -----");
        productList.forEach(Product::showStatus);
    }

    @Override
    public void setProductList(List<Product> productList) {
        productList.add(freshProd);
        productList.add(spoiledProd);
    }
}