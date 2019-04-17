package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.ksodd.Helpers.TestHelper;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class Matching {

    public static String number1 = "";

    public static void inputStreet() {
        $(By.xpath("//input[@placeholder='Выберите улицу']")).click();
        sleep(4000);
        $(By.xpath("//input[@placeholder='Выберите улицу']")).click();
        $(By.xpath("//input[@placeholder='Выберите улицу']")).setValue("Новый Арбат");
        $(By.xpath("//span[@class='v-list__tile__mask' and text()='Новый Арбат']")).click();
        actions().sendKeys(Keys.ESCAPE).perform();
    }

    public static void inputList() {
        $(By.xpath("//div[@class='v-radio theme--light'][1]")).click();
    }

    public static void inputDateNow() {
        $(By.xpath("//*[text()[contains(.,'Дата начала работ')]]")).click();
        $(By.xpath("//div[@class='v-menu__content theme--light menuable__content__active']//tr/td/button[@class[contains(.,'accent--text')]]/div")).click();
    }

    public static void InputDateEnd(){
        $(By.xpath("//*[text()[contains(.,'Дата окончания работ')]]")).click();
        $(By.xpath("//div[@class='v-menu__content theme--light menuable__content__active']//tr/td/button[@class[contains(.,'')]]/div[text()='30']")).click();
    }

    public static void clickTuskDate() {
        sleep(3000);
//        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + TestHelper.number + "')]]")).should(Condition.visible);
        $(By.xpath("//span[text()[contains(.,'"+TestHelper.number+"')]]/../../../..//div[@data-id='20']")).click();
    }

    public static void clickTuskDate1() {
        sleep(1000);
//        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + TestHelper.number + "')]]")).should(Condition.visible);
        $(By.xpath("//span[text()[contains(.,'"+TestHelper.number+"')]]/../../../..//div[@data-id='21']")).click();
    }

}
