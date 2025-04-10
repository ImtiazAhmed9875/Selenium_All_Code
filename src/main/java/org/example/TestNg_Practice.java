package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg_Practice {

    WebDriver driver;

    @BeforeClass
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test(priority = 1)
    public void loginToSauceDemo(){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@id,'login-button')]")).click();
    }
    @Test(priority = 2)
    public void AddProductToCart(){
        driver.findElement(By.xpath("//button[@id ='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[contains(@data-test,'add-to-cart-sauce-labs-bike-light')]")).click();
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

    }
    @Test(priority = 3)
    public void RemoveSomeProduct(){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//*[@id='remove-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
    }
    @Test(priority = 4)
    public void checkoutCart() {
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Imtiaz");
        driver.findElement(By.xpath("//*[@id='last-name' and @name='lastName']")).sendKeys("Ahmed");
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("1230");
    }
    @Test(priority = 5)
    public void finishOrder() {
        driver.findElement(By.xpath("//*[@id='continue' and @class='submit-button btn btn_primary cart_button btn_action']")).click();
        driver.findElement(By.xpath("//*[@id='finish']")).click();
        driver.findElement(By.xpath("//*[@id='back-to-products']")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}
