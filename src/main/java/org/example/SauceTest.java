package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceTest {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Username.sendKeys("standard_user");
        WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
        Password.sendKeys("secret_sauce");
        WebElement Login = driver.findElement(By.xpath("//input[contains(@id,'login-button')]"));
        Login.click();
        WebElement Bag = driver.findElement(By.xpath("//button[@id ='add-to-cart-sauce-labs-backpack']"));
        Bag.click();
        WebElement Bike_light = driver.findElement(By.xpath("//button[contains(@data-test,'add-to-cart-sauce-labs-bike-light')]"));
        Bike_light.click();
        //WebElement Bolt_T_Shirt = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]"));//button[@class ="btn btn_secondary btn_small btn_inventory " and @id="remove-sauce-labs-bolt-t-shirt"]
        //Bolt_T_Shirt.click();
        WebElement Bolt_T_Shirt = driver.findElement(By.xpath("//button[@name = \"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
        Bolt_T_Shirt.click();


        WebElement Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Cart.click();
        WebElement Bol_T_Shirt = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]"));//button[@class ="btn btn_secondary btn_small btn_inventory " and @id="remove-sauce-labs-bolt-t-shirt"]
        Bol_T_Shirt.click();
        WebElement R_Bagpack = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
        R_Bagpack.click();
        WebElement Checkout = driver.findElement(By.id("checkout"));
        Checkout.click();
        WebElement First_name = driver.findElement(By.id("first-name"));
        First_name.sendKeys("Imtiaz");
        WebElement Last_name = driver.findElement(By.xpath("//*[@id=\"last-name\" and @name=\"lastName\"]"));
        Last_name.sendKeys("Ahmed");
        WebElement Zip_code = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        Zip_code.sendKeys("1230");
        WebElement Continue = driver.findElement(By.xpath("//*[@id=\"continue\" and @class=\"submit-button btn btn_primary cart_button btn_action\"]"));
        Continue.click();
        WebElement Finish = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        Finish.click();
        WebElement Back_home = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
        Back_home.click();
        driver.close();
    }
}
