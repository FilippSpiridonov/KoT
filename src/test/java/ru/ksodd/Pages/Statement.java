package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Statement {

    public static void clickCheck(String word){
        sleep(1000);
        $(By.xpath("//label[text()[contains(.,'"+word+"')]]")).should(Condition.exist);
        $(By.xpath("//label[text()[contains(.,'"+word+"')]]")).click();
    }

    public static void inputDate(){
        $(By.xpath("//span[text()[contains(.,'Дата реализации')]]/..//input[@aria-label='Выберите дату']")).click();
        $(By.xpath("//tr[last()]/td[last()-1]/button[@type='button']/div[@class='v-btn__content']")).click();
    }

    public static void inputDateEnd(){
//        $(By.xpath("//span[text()[contains(.,'Дата реализации')]]/..//input[@aria-label='Выберите дату']")).click();
        $(By.xpath("//tr[last()]/td[last()]/button[@type='button']/div[@class='v-btn__content']")).click();
    }

    public static void inputDateEnd1(){
        $(By.xpath("//span[text()[contains(.,'Дата реализации')]]/..//input[@aria-label='Выберите дату']")).click();
        $(By.xpath("//tr[last()]/td[last()]/button[@type='button']/div[@class='v-btn__content']")).click();
    }


}
