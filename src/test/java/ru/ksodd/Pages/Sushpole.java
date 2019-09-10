package ru.ksodd.Pages;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.ksodd.Helpers.TestHelper;

import java.io.IOException;
import java.security.Key;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static ru.ksodd.Helpers.TestHelper.log;

public class Sushpole {


    public static void inputSush(String input, String text) throws IOException {
        String xpath = "//*[@aria-label='" + input + "']";
        String xpath1 = "//span[@class='v-list__tile__mask' and text()[contains(.,'" + text + "')]]";
        log("Произошел клик на поле " + input + "", "Клик на поле " + input + " не произошел",
                xpath, "click", "");
        log("Ввод " + input + "", "Ввод " + input + " не произошел",
                xpath, "setValue", text);
        log("Выбран "+input+" из списка", "Не был выбран "+input+" из списка",
                xpath1, "click", "");

    }

    public static void clickIconPlus() throws IOException {
        String xpath = "//div[@class='v-btn__content']/i[text()='add']";
        log("Клик на иконку 'плюс' произошел","Клик на иконку 'плюс' НЕ произошел",xpath,"click", "");
    }

    public static void inputForm(String name, String text) throws IOException {
        try {
            String xpath = "//p[text()=' "+name+" ']/../div/*";
            TestHelper.log("Поле "+name+" существует", "Поле "+name+" НЕ существует", xpath, "should","");
            TestHelper.log("Выбор поля "+name+" произошел", "Клик на поле "+name+" НЕ произошел", xpath, "click","");
            TestHelper.log("Ввод в поле "+name+" произошел", "Ввод в поле "+name+" НЕ произошел", xpath, "setValue",""+text+"");
        } catch (Error e) {
            String xpath = "//*[text()=' " + name + " ']/../div[@class='line__item-input']";
            String xpath1 = "//input[@placeholder='"+name+"']";
            TestHelper.log("Поле "+name+" существует", "Поле "+name+" НЕ существует", xpath, "should","");
            TestHelper.log("Выбор поля "+name+" произошел", "Клик на поле "+name+" НЕ произошел", xpath, "click","");
            TestHelper.log("Ввод в поле "+name+" произошел", "Ввод в поле "+name+" НЕ произошел", xpath1, "setValue",""+text+"");
            actions().sendKeys(Keys.ENTER).build().perform();
        } catch (IllegalArgumentException q){
            String xpath = "//p[text()=' "+name+" ']/..//input";
            TestHelper.log("Поле "+name+" существует", "Поле "+name+" НЕ существует", xpath, "should","");
            TestHelper.log("Выбор поля "+name+" произошел", "Клик на поле "+name+" НЕ произошел", xpath, "click","");
            TestHelper.log("Ввод в поле "+name+" произошел", "Ввод в поле "+name+" НЕ произошел", xpath, "setValue",""+text+"");
        }
    }

    public static void clickButton(){
        $(By.xpath("//div[@class='modal-footer']//*[text()='Создать']")).click();
    }

}
