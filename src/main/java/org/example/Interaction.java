package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class Interaction {
    static WebDriver driver;
    public void IntWithTextBox(){
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement Username = driver.findElement(By.xpath("//input[@id=\"username\"]"));
        Username.sendKeys("tomsmith");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        Username.clear();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Username.sendKeys("tomsmith");
        WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        Password.sendKeys("SuperSecretPassword!");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Username = "+ Username.getAttribute("value"));
        System.out.println("Password = "+ Password.getAttribute("value"));
    }
public void IntWithButton(){
    driver.get("https://the-internet.herokuapp.com/login");
    WebElement Username = driver.findElement(By.xpath("//input[@id=\"username\"]"));
    Username.sendKeys("tomsmith");
    WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
    Password.sendKeys("SuperSecretPassword!");
    WebElement Button = driver.findElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));
    Button.click();
    try{
        Thread.sleep(2000);
    }catch (InterruptedException e){
        throw new RuntimeException(e);
    }
}
public void IntWithCheckBox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement CheckBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
    System.out.println("Is Selected = "+ CheckBox1.isSelected());
    CheckBox1.click();

    System.out.println("Is Selected = "+ CheckBox1.isSelected());
    WebElement Checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
    System.out.println("Is Selected = "+ Checkbox2.isSelected());
}


public void IntWithDropDown(){
    driver.get("https://the-internet.herokuapp.com/dropdown");
    Select dropdown = new Select(driver.findElement(By.xpath("//select")));
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    dropdown.selectByIndex(1);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

public void IntWithTextLink(){
        driver.get("https://the-internet.herokuapp.com");
        WebElement thirdLink = driver.findElement(By.linkText("Context Menu"));
        thirdLink.click();
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

public void IntWithTables(){
    System.out.println("Use Table");
    driver.get("https://the-internet.herokuapp.com/tables");
    WebElement Table =driver.findElement(By.id("table1"));
    for(WebElement row : Table.findElements(By.tagName("tr"))){
//        System.out.println(row.getText());

        for(WebElement Column : row.findElements(By.tagName("td"))){
            System.out.print(Column.getText()+"\t");
        }
        System.out.println();
    }

}

public void IntWithFrame(){
    driver.get("https://the-internet.herokuapp.com/iframe");
    WebElement Title = driver.findElement(By.xpath("//h3"));
    System.out.println("Title = "+ Title.getText());
    driver.switchTo().frame("mce_0_ifr");
//    WebElement IframeTitle = driver.findElement(By.xpath());
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
//    System.out.println("Title = "+Title.getText());
    driver.switchTo().defaultContent();
//    WebElement Title1 =driver.findElement(By.xpath("//h3"));
    System.out.println("Title = "+ Title.getText());
}

public void IntWithAlarts(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement FirstAlart = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        FirstAlart.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    driver.switchTo().defaultContent();
    WebElement SecondAlart = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
    SecondAlart.click();
    Alert alart1 = driver.switchTo().alert();
//    alart1.accept();
//    try {
//        Thread.sleep(3000);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
    alart1.dismiss();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    driver.switchTo().defaultContent();
    WebElement ThirdAlart = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
    ThirdAlart.click();
    Alert alert3 =driver.switchTo().alert();
    alert3.sendKeys("My name is Imtiaz");
    alert3.accept();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}
public void IntWithWindow(){
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator e = handles.iterator();
        if (e.hasNext()){
            String window = (String)e.next();
            driver.switchTo().window(window);
        }
        driver.findElement(By.xpath("//a[text()='Click Here']"));
    try {
        Thread.sleep(3000);
    } catch (InterruptedException ex) {
        throw new RuntimeException(ex);
    }


}
public void IntWithHoverOverElements(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement avter = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        actions.moveToElement(avter).perform();
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    WebDriver user1 = driver;
    System.out.println("Hover over element of: "+ user1.findElement(By.xpath("//h5[text()=\"name: user1\"]")).getText());
}


    public static void main(String[] args) {
        driver = new ChromeDriver();
        try{
            Interaction f1 = new Interaction();
//            f1.IntWithTextBox();
//            f1.IntWithButton();
//            f1.IntWithCheckBox();
//            f1.IntWithDropDown();
//            f1.IntWithTextLink();
//            f1.IntWithTables();
//            f1.IntWithFrame();
//            f1.IntWithAlarts();
//            f1.IntWithWindow();
            f1.IntWithHoverOverElements();


        }finally {
            driver.quit();
        }

    }
}
