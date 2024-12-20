package org.csiszer.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;


@DefaultUrl("https://www.evomag.ro/cart/")
public class CartPage extends PageObject {


    @FindBy(xpath = "/html/body/div[5]/div[4]/div[1]/div[2]/h3")
    WebElementFacade cartLabel;

    @FindBy(className = "cart_article_row")
    List<WebElementFacade> cartItem;


    @FindBy(className = "cart_product_name_cell")
    List<WebElementFacade> cartProductNames;




    public String getCartLabel() {
        return cartLabel.getText();
    }

    public List<String> getCartProductNames() {
        return cartProductNames.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }


    public void delete_product_from_cart(String productName) {
        cartItem.stream()
                .filter(element -> element.findElement(By.className("cart_product_name_cell")).getText().contains(productName))
                .forEach(element -> element.findElement(By.className("sterge_tab")).click());
    }
}
