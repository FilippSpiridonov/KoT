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
}
