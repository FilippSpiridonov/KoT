package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.ksodd.Helpers.TestHelper;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static ru.ksodd.Helpers.TestHelper.log;

public class Statement {

    public static void clickCheck(String word){
        sleep(1000);
        $(By.xpath("//label[text()[contains(.,'"+word+"')]]")).should(Condition.exist);
        $(By.xpath("//label[text()[contains(.,'"+word+"')]]")).click();
    }

    public static void inputDate(){
        sleep(1000);
        $(By.xpath("//span[text()[contains(.,'Дата ')]]/..//input[@aria-label='Выберите дату']")).click();
        $(By.xpath("//tr[last()-1]/td[last()-1]/button[@type='button']/div[@class='v-btn__content']")).click();
    }

    public static void inputDateEnd(){
//        $(By.xpath("//span[text()[contains(.,'Дата реализации')]]/..//input[@aria-label='Выберите дату']")).click();
        $(By.xpath("//tr[last()]/td[last()]/button[@type='button']/div[@class='v-btn__content']")).click();
    }

    public static void inputDateEnd1() throws IOException {
        String xpath= "//span[text()[contains(.,'Дата реализации')]]/..//input[@aria-label='Выберите дату']";
        String xpath1="//tr[last()]/td[last()]/button[@type='button']/div[@class='v-btn__content']";
        log("Клик на дату","Клик на дату НЕ произошел",xpath,"click","");
        log("Выбор даты","Выбор даты НЕ произошел",xpath1,"click","");

    }


}
